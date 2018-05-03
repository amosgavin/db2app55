package com.asiainfo.task.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.*;

public interface IBOVmTaskValue extends DataStructInterface {

	public final static String S_LockStaffId = "LOCK_STAFF_ID";
	public final static String S_DecisionResult = "DECISION_RESULT";
	public final static String S_State = "STATE";
	public final static String S_TaskBaseType = "TASK_BASE_TYPE";
	public final static String S_EngineWorkflowId = "ENGINE_WORKFLOW_ID";
	public final static String S_StateDate = "STATE_DATE";
	public final static String S_WarningTimes = "WARNING_TIMES";
	public final static String S_TaskId = "TASK_ID";
	public final static String S_FinishDate = "FINISH_DATE";
	public final static String S_QueueId = "QUEUE_ID";
	public final static String S_EngineTaskId = "ENGINE_TASK_ID";
	public final static String S_TaskType = "TASK_TYPE";
	public final static String S_LastTaskId = "LAST_TASK_ID";
	public final static String S_DestTaskTemplateId = "DEST_TASK_TEMPLATE_ID";
	public final static String S_WorkflowId = "WORKFLOW_ID";
	public final static String S_Duration = "DURATION";
	public final static String S_TaskStaffId = "TASK_STAFF_ID";
	public final static String S_WarningDate = "WARNING_DATE";
	public final static String S_ExeFinishDate = "EXE_FINISH_DATE";
	public final static String S_TaskTemplateId = "TASK_TEMPLATE_ID";
	public final static String S_Description = "DESCRIPTION";
	public final static String S_StationId = "STATION_ID";
	public final static String S_DestType = "DEST_TYPE";
	public final static String S_Label = "LABEL";
	public final static String S_IsCurrentTask = "IS_CURRENT_TASK";
	public final static String S_ErrorMessage = "ERROR_MESSAGE";
	public final static String S_LockDate = "LOCK_DATE";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_RemanentWorkflowCount = "REMANENT_WORKFLOW_COUNT";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_TaskTag = "TASK_TAG";
	public final static String S_FinishStaffId = "FINISH_STAFF_ID";
	public final static String S_ChildWorkflowCount = "CHILD_WORKFLOW_COUNT";

	public String getLockStaffId();

	public String getDecisionResult();

	public int getState();

	public String getTaskBaseType();

	public String getEngineWorkflowId();

	public Timestamp getStateDate();

	public int getWarningTimes();

	public String getTaskId();

	public Timestamp getFinishDate();

	public String getQueueId();

	public String getEngineTaskId();

	public String getTaskType();

	public String getLastTaskId();

	public long getDestTaskTemplateId();

	public String getWorkflowId();

	public long getDuration();

	public String getTaskStaffId();

	public Timestamp getWarningDate();

	public Timestamp getExeFinishDate();

	public long getTaskTemplateId();

	public String getDescription();

	public String getStationId();

	public String getDestType();

	public String getLabel();

	public String getIsCurrentTask();

	public String getErrorMessage();

	public Timestamp getLockDate();

	public String getRegionId();

	public long getRemanentWorkflowCount();

	public Timestamp getCreateDate();

	public String getTaskTag();

	public String getFinishStaffId();

	public long getChildWorkflowCount();

}
