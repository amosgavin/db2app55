package com.ai.comframe.vm.engine;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.util.StringUtils;
import com.ai.comframe.ComframeWorkflowFactory;
import com.ai.comframe.client.service.interfaces.IComframeCallBusiDefaultSV;
import com.ai.comframe.config.ivalues.IBOVmExceptionCodeValue;
import com.ai.comframe.config.service.interfaces.IExceptionConfigSV;
import com.ai.comframe.config.service.interfaces.ITemplateSV;
import com.ai.comframe.locale.ComframeLocaleFactory;
import com.ai.comframe.utils.PropertiesUtil;
import com.ai.comframe.utils.TimeUtil;
import com.ai.comframe.vm.common.Constant;
import com.ai.comframe.vm.common.TaskConfig;
import com.ai.comframe.vm.engine.impl.ProcessflowImpl;
import com.ai.comframe.vm.engine.impl.WorkflowImpl;
import com.ai.comframe.vm.template.TaskTemplate;
import com.ai.comframe.vm.template.WorkflowTemplate;
import com.ai.comframe.vm.workflow.bo.BOHVmTaskBean;
import com.ai.comframe.vm.workflow.bo.BOHVmWFBean;
import com.ai.comframe.vm.workflow.bo.BOVmTaskBean;
import com.ai.comframe.vm.workflow.bo.BOVmWFAttrBean;
import com.ai.comframe.vm.workflow.bo.BOVmWFBean;
import com.ai.comframe.vm.workflow.dao.interfaces.IVmTaskDAO;
import com.ai.comframe.vm.workflow.dao.interfaces.IVmWorkflowDAO;
import com.ai.comframe.vm.workflow.ivalues.IBOVmTaskTSValue;
import com.ai.comframe.vm.workflow.ivalues.IBOVmTaskValue;
import com.ai.comframe.vm.workflow.ivalues.IBOVmWFAttrValue;
import com.ai.comframe.vm.workflow.ivalues.IBOVmWFValue;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FlowFactory
{
  public static void save(FlowBase workflow)
    throws Exception
  {
    saveFlowBase(workflow);
  }

  public static void save(IBOVmTaskValue task) throws Exception {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    taskDAO.saveVmtaskInstacne(task);
  }

  public static void save(IBOVmWFValue workflow) throws Exception
  {
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    workflowDAO.saveVmWorkflowInstacne(workflow);

    if (((workflow.getWorkflowKind() == 1) && (workflow.getParentTaskId() != null) && (!"-1".equals(workflow.getParentTaskId()))) || (workflow.getWorkflowKind() == 2))
    {
      return;
    }

    _move2His(workflow.getWorkflowId(), workflow.getState(), workflow.getFinishDate());
  }

  public static void saveFlowBase(FlowBase workflow) throws Exception
  {
    workflow.fillBack();
    DataContainerInterface[] taskdatas = workflow.getTaskBeans();
    DataContainerInterface workflowdata = workflow.getDataBean();

    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    BOVmWFBean workflowbean = new BOVmWFBean();
    workflowbean.copy(workflowdata);
    workflowDAO.saveVmWorkflowInstacne(workflowbean);
    saveVmWorkflowAttr(workflow);

    for (int i = 0; i < taskdatas.length; ++i) {
      IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
      BOVmTaskBean taskbean = new BOVmTaskBean();
      taskbean.copy(taskdatas[i]);
      taskDAO.saveVmtaskInstacne(taskbean);
      taskdatas[i].setStsToOld();
    }

    if (((workflow.getWorkflowKind() == 1) && (workflow.getParentTaskId() != null) && (!"-1".equals(workflow.getParentTaskId()))) || (workflow.getWorkflowKind() == 2))
    {
      return;
    }
    _move2His(workflow.getWorkflowId(), workflow.getState(), workflowbean.getFinishDate());
  }

  private static void _move2His(String workflowId, int workflowState, Timestamp transferDate) throws Exception {
    boolean isHisState = false;

    for (int i = 0; i < Constant.WORKFLOW_HIS_STATE.length; ++i) {
      if (workflowState == Constant.WORKFLOW_HIS_STATE[i]) {
        isHisState = true;
        break;
      }
    }

    if (!isHisState)
      return;
    List workflowIds = getAllChildWorkflows(workflowId);

    if ((workflowIds != null) && (workflowIds.size() > 0)) {
      IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
      IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);

      for (int i = 0; i < workflowIds.size(); ++i) {
        String temp = (String)workflowIds.get(i);
        workflowDAO.workflowToHis(temp, transferDate);
        workflowDAO.workflowAttrToHis(temp, transferDate);
        taskDAO.taskToHis(temp, transferDate);
        taskDAO.taskTSToHis(temp, transferDate);
      }
    }
  }

  private static List getAllChildWorkflows(String workflowId)
    throws Exception
  {
    List wfList = new ArrayList();
    wfList.add(workflowId);

    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);

    IBOVmTaskValue[] tasks = taskDAO.getAllChildWorkflowTasks(workflowId);
    IBOVmWFValue[] wfValues = null;

    IBOVmWFValue exwf = workflowDAO.getExceptionChildWorkflow(workflowId);
    if (exwf != null) {
      wfList.addAll(getAllChildWorkflows(exwf.getWorkflowId()));
    }

    if ((tasks != null) && (tasks.length > 0)) {
      for (int i = 0; i < tasks.length; ++i)
      {
        wfValues = workflowDAO.getChildWorkflows(tasks[i].getTaskId());
        if (wfValues == null) continue; if (wfValues.length == 0) {
          continue;
        }

        for (int j = 0; j < wfValues.length; ++j) {
          exwf = workflowDAO.getExceptionChildWorkflow(wfValues[j].getWorkflowId());
          if (exwf != null) {
            wfList.addAll(getAllChildWorkflows(exwf.getWorkflowId()));
          }
          wfList.addAll(getAllChildWorkflows(wfValues[j].getWorkflowId()));
        }
      }
    }
    return wfList;
  }

  private static Collection getExceptionWorkflows(String workflowId) throws Exception {
    List wfList = new ArrayList();
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    IBOVmWFValue exwf = workflowDAO.getExceptionChildWorkflow(workflowId);
    if (exwf != null) {
      wfList.addAll(getAllChildWorkflows(exwf.getWorkflowId()));
    }
    return wfList;
  }

  public static WorkflowImpl reload(String workflowId)
    throws Exception
  {
    return reload(workflowId, false);
  }
  public static WorkflowImpl reload(String workflowId, boolean isSchedule) throws Exception {
    if (isSchedule == true) {
      return reloadForSchedule(workflowId);
    }
    return reloadForAll(workflowId);
  }

  protected static WorkflowImpl reloadForSchedule(String workflowId) throws Exception {
    DataContainerInterface workflowBean = null;
    DataContainerInterface[] taskBeans = null;
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    workflowBean = (BOVmWFBean)workflowDAO.getVmWorkflowBeanbyId(workflowId);
    if (workflowBean == null) {
      throw new Exception(ComframeLocaleFactory.getResource("com.ai.appframe2.vm.engine.FlowFactory.reloadForAll_notFoundProcessIns") + workflowId);
    }
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    taskBeans = (BOVmTaskBean[])(BOVmTaskBean[])taskDAO.getVmTaskbeanByWorkflowId(workflowId);
    WorkflowTemplate aWorkflowTemplate = null;
    ITemplateSV templateSV = (ITemplateSV)ServiceFactory.getService(ITemplateSV.class);
    boolean publish = templateSV.isPublish(workflowBean.getAsString("TEMPLATE_TAG"));
    if (!publish)
      aWorkflowTemplate = templateSV.getWorkflowTemplateFromFile(workflowBean.getAsString("TEMPLATE_TAG"));
    else {
      aWorkflowTemplate = templateSV.getWorkflowTemplateByID(workflowBean.getAsLong("TEMPLATE_VERSION_ID"));
    }
    return new WorkflowImpl(aWorkflowTemplate, workflowBean, taskBeans);
  }

  protected static WorkflowImpl reloadForAll(String workflowId)
    throws Exception
  {
    DataContainerInterface workflowBean = null;
    DataContainerInterface[] taskBeans = null;
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    boolean isHis = false;
    workflowBean = (BOVmWFBean)workflowDAO.getVmWorkflowBeanbyId(workflowId);
    if (workflowBean != null) {
      isHis = false;
    } else {
      workflowBean = (BOHVmWFBean)workflowDAO.getHisVmWorkflowBeanbyId(workflowId);
      if (workflowBean == null)
        throw new Exception(ComframeLocaleFactory.getResource("com.ai.appframe2.vm.engine.FlowFactory.reloadForAll_notFoundProcessIns") + workflowId);
      isHis = true;
    }
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    if (!isHis)
      taskBeans = (BOVmTaskBean[])(BOVmTaskBean[])taskDAO.getVmTaskbeanByWorkflowId(workflowId);
    else {
      taskBeans = (BOHVmTaskBean[])(BOHVmTaskBean[])taskDAO.getHVmTaskbeanByWorkflowId(workflowId);
    }
    WorkflowTemplate aWorkflowTemplate = null;
    ITemplateSV templateSV = (ITemplateSV)ServiceFactory.getService(ITemplateSV.class);
    boolean publish = templateSV.isPublish(workflowBean.getAsString("TEMPLATE_TAG"));
    if (!publish)
      aWorkflowTemplate = templateSV.getWorkflowTemplateFromFile(workflowBean.getAsString("TEMPLATE_TAG"));
    else {
      aWorkflowTemplate = templateSV.getWorkflowTemplateByID(workflowBean.getAsLong("TEMPLATE_VERSION_ID"));
    }
    return new WorkflowImpl(aWorkflowTemplate, workflowBean, taskBeans);
  }

  public static WorkflowImpl reloadWorkflowHis(String workflowId, String acctPeriod) throws Exception {
    DataContainerInterface workflowBean = null;
    DataContainerInterface[] taskBeans = null;
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    workflowBean = (BOHVmWFBean)workflowDAO.getHisVmWorkflowBeanbyId(workflowId, acctPeriod);
    if (workflowBean == null)
      throw new Exception(ComframeLocaleFactory.getResource("com.ai.appframe2.vm.engine.FlowFactory.reloadForAll_notFoundProcessIns") + workflowId);
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    taskBeans = (BOHVmTaskBean[])(BOHVmTaskBean[])taskDAO.getHVmTaskbeanByWorkflowId(workflowId, acctPeriod);
    WorkflowTemplate aWorkflowTemplate = null;
    ITemplateSV templateSV = (ITemplateSV)ServiceFactory.getService(ITemplateSV.class);
    boolean publish = templateSV.isPublish(workflowBean.getAsString("TEMPLATE_TAG"));
    if (!publish)
      aWorkflowTemplate = templateSV.getWorkflowTemplateFromFile(workflowBean.getAsString("TEMPLATE_TAG"));
    else {
      aWorkflowTemplate = templateSV.getWorkflowTemplateByID(workflowBean.getAsLong("TEMPLATE_VERSION_ID"));
    }
    return new WorkflowImpl(aWorkflowTemplate, workflowBean, taskBeans);
  }

  public static Task createTask(FlowBase workflow, DataContainerInterface taskBean)
    throws Exception
  {
    long taskTemplateId = taskBean.getAsLong(TaskBaseImpl.S_TASK_TEMPLATE_ID);
    TaskTemplate aTaskTemplate = workflow.getWorkflowTemplate().getTaskTemplate(taskTemplateId);
    if("zqs0002".equals(aTaskTemplate.getTaskTag())){System.out.println("hahahahah");}
    Class tmpClass = Class.forName(TaskConfig.getInstance().getExecuteClass(aTaskTemplate.getTaskType()));
    
    Constructor constructor = tmpClass.getConstructor(new Class[] { FlowBase.class, TaskTemplate.class, DataContainerInterface.class });

    return (Task)constructor.newInstance(new Object[] { workflow, aTaskTemplate, taskBean });
  }

  public static Task createTask(String aQueueId, FlowBase workflow, TaskTemplate aTaskTemplate) throws Exception {
    Class tmpClass = Class.forName(TaskConfig.getInstance().getExecuteClass(aTaskTemplate.getTaskType()));
    Constructor constructor = tmpClass.getConstructor(new Class[] { FlowBase.class, String.class, TaskTemplate.class, Integer.TYPE, Date.class, Date.class });

    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    String taskId = taskDAO.getNewTaskId(aQueueId, workflow.getDistrictId());

    return (Task)constructor.newInstance(new Object[] { workflow, taskId, aTaskTemplate, new Integer(2), new Date(TimeUtil.getSysTime().getTime()), new Date(TimeUtil.getSysTime().getTime()) });
  }

  public static Processflow createProcess(String aQueueId, FlowBase parentFlow, String workflowCode, Map aVars)
    throws Exception
  {
    ITemplateSV templateSV = (ITemplateSV)ServiceFactory.getService(ITemplateSV.class);
    WorkflowTemplate template = templateSV.getWorkflowTemplateByTag(workflowCode);
    return createProcess(aQueueId, parentFlow, template, aVars);
  }

  public static Processflow createProcess(String aQueueId, FlowBase parentFlow, WorkflowTemplate aFlowTemplate, Map aVars) throws Exception {
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    String workflowId = workflowDAO.getNewWorkFlowId(aQueueId, parentFlow.getDistrictId());
    Processflow flow = new ProcessflowImpl(aQueueId, parentFlow, workflowId, aFlowTemplate, aVars);
    return flow;
  }

  public static Workflow createWorkflow(String aQueueId, String parentTaskId, String workflowCode, int isExceptionWorkflow, String staffId, String objectTypeId, String objectId, Map aVars)
    throws Exception
  {
    ITemplateSV templateSV = (ITemplateSV)ServiceFactory.getService(ITemplateSV.class);
    WorkflowTemplate template = templateSV.getWorkflowTemplateByTag(workflowCode);
    return createWorkflow(aQueueId, parentTaskId, template, isExceptionWorkflow, staffId, objectTypeId, objectId, aVars);
  }

  public static Workflow createWorkflow(String aQueueId, String parentTaskId, WorkflowTemplate template, int isExceptionWorkflow, String staffId, String objectTypeId, String objectId, Map aVars)
    throws Exception
  {
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    String regionId = "";

    if ((CenterFactory.isSetCenterInfo()) && (CenterFactory.getCenterInfo() != null))
      regionId = CenterFactory.getCenterInfo().getRegion();
    String workflowId = workflowDAO.getNewWorkFlowId(aQueueId, regionId);
    Workflow workflow = new WorkflowImpl(aQueueId, parentTaskId, workflowId, isExceptionWorkflow, template, aVars, 2, new Date(TimeUtil.getSysTime().getTime()), new Date(TimeUtil.getSysTime().getTime()), staffId, objectTypeId, objectId);

    save(workflow);
    return workflow;
  }

  public static IBOVmWFValue getWorkflowBean(String workflowId) throws Exception {
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    IBOVmWFValue workflowbean = null;
    workflowbean = workflowDAO.getVmWorkflowBeanbyId(workflowId);
    return workflowbean;
  }

  public static IBOVmTaskValue getTaskBean(String taskId) throws Exception
  {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IBOVmTaskValue taskBean = taskDAO.getVmTaskbeanById(taskId);
    return taskBean;
  }

  public static IBOVmTaskValue[] getTaskBeansByWorkflowId(String workflowId, boolean isWorkflowFinished) throws Exception
  {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IBOVmTaskValue[] taskBeans = null;
    if (!isWorkflowFinished)
      taskBeans = taskDAO.getVmTaskbeanByWorkflowId(workflowId);
    return taskBeans;
  }

  public static String getStationId(String organizeId, String stationTypeId) throws Exception {
    return ComframeWorkflowFactory.getComframeCallBusiInstance().getStationIdByStationTypeIdAndOrgId(stationTypeId, organizeId);
  }

  public static IBOVmTaskTSValue getTaskTransBean(String taskId) throws Exception {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IBOVmTaskTSValue taskBean = taskDAO.getVmTaskTransBeanById(taskId);
    return taskBean;
  }

  public static IBOVmTaskTSValue[] getTaskTransBeans(String workflowId, String parentTaskId) throws Exception {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IBOVmTaskTSValue[] taskBeans = taskDAO.getVmTaskTransBeans(workflowId, parentTaskId);
    return taskBeans;
  }

  public static void saveTaskTrans(IBOVmTaskTSValue task) throws Exception {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    taskDAO.saveVmtaskTransInstacne(task);
  }

  public static void saveTaskTrans(IBOVmTaskTSValue[] tasks) throws Exception
  {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    taskDAO.saveVmtaskTransInstacnes(tasks);
  }

  public static void saveVmWorkflowAttr(FlowBase workflow) throws Exception {
    if (!PropertiesUtil.isAttrRecord())
      return;
    Map vmVars = workflow.getWorkflowContext().getParameters();
    String workflowId = workflow.getWorkflowId();
    if ((vmVars.isEmpty()) || (workflowId == null)) {
      return;
    }
    IVmWorkflowDAO workflowDAO = (IVmWorkflowDAO)ServiceFactory.getService(IVmWorkflowDAO.class);
    IBOVmWFAttrValue[] attrBeans = workflowDAO.getVmWorkflowAttrsByWorkflowId(workflowId);
    if ((attrBeans != null) && (attrBeans.length > 0)) {
      for (int i = 0; i < attrBeans.length; ++i) {
        if (vmVars.containsKey(attrBeans[i].getAttrCode())) {
          String value = String.valueOf(vmVars.get(attrBeans[i].getAttrCode()));
          if ((!StringUtils.isEmptyString(value)) && 
            (value.length() > 90)) {
            value = value.substring(0, 90);
          }

          attrBeans[i].setAttrValue(value);
          attrBeans[i].setCreateDate(TimeUtil.getSysTime());
        }
      }
      workflowDAO.saveVmWorkflowAttrBeans(attrBeans);
    } else {
      BOVmWFAttrBean[] attrs = new BOVmWFAttrBean[vmVars.size()];
      int i = 0;
      for (Iterator iter = vmVars.entrySet().iterator(); iter.hasNext(); ++i) {
        Map.Entry entry = (Map.Entry)iter.next();
        attrs[i] = new BOVmWFAttrBean();
        attrs[i].setQueueId(workflow.getQueueId());
        attrs[i].setWorkflowId(workflowId);
        attrs[i].setAttrCode(String.valueOf(entry.getKey()));
        String value = String.valueOf(entry.getValue());
        if ((!StringUtils.isEmptyString(value)) && 
          (value.length() > 90)) {
          value = value.substring(0, 90);
        }

        attrs[i].setCreateDate(TimeUtil.getSysTime());
        attrs[i].setAttrValue(value);
      }
      workflowDAO.saveVmWorkflowAttrBeans(attrs);
    }
  }

  public static IBOVmTaskTSValue[] getTaskTransBeansParentOrWorkflowId(String parentTaskId, String workflowId) throws Exception
  {
    IVmTaskDAO taskDAO = (IVmTaskDAO)ServiceFactory.getService(IVmTaskDAO.class);
    IBOVmTaskTSValue[] taskts = taskDAO.getTaskTransBeansParentOrWorkflowId(parentTaskId, workflowId);
    return taskts;
  }

  public static String[][] getExceptionCode(String sqlStr, HashMap parameter)
    throws Exception
  {
    IExceptionConfigSV exConfigSV = (IExceptionConfigSV)ServiceFactory.getService(IExceptionConfigSV.class);
    IBOVmExceptionCodeValue[] exCodes = exConfigSV.getExceptionCodeValuesBySql(sqlStr, parameter);

    String[][] result = new String[exCodes.length][2];

    for (int i = 0; i < exCodes.length; ++i)
    {
      result[i][0] = exCodes[i].getExceptionCode();
      result[i][1] = exCodes[i].getExceptionName();
    }

    return result;
  }
  public static void main(String[] args) throws Exception {
    List list = new ArrayList();
    IBOVmWFValue wf = new BOVmWFBean();
    wf.setWorkflowId("test");
    list.add(wf);
    wf = new BOVmWFBean();
    list.add(wf);
    System.out.println(((IBOVmWFValue)list.get(1)).getWorkflowId());
  }
}