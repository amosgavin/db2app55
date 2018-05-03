/**
��datarowset������excel��
pDataRowSet -Ҫ������datarowset
pIsShowHeadText-�Ƿ���ʾ��ͷ
pHeadShowColNums--��ʾ��ͷ��Ŀ�ĸ���
pTitle--����ı���

����excel�ĳ���������ʹ�ã�
excel��ʹ�ÿ���Excel��¼�ƺ꣬Ȼ�����ʵ�ʲ���
�������ɫ�����ߡ��ϲ���Ԫ��ȣ�Ȼ��༭�ú�鿴Դ���롣
���ڲ鿴���еĳ������壬�������£�
1����Excel�а�Alt+F11����Visual Basic����
2����Visual Basic�����а�F2��ʾ���������
3���ڶ����������������Ҫ��ѯ�ĳ����鿴��������ֵ��
*/
function g_DataRowSet2Excel(pDataRowSet,pIsShowHeadText,pHeadShowColNums,pTitle)
{
   if (pDataRowSet)
	{

				   var xlApp = null;
				  try {
								xlApp =new ActiveXObject("excel.APPLICATION");
								var xlBook = xlApp.Workbooks.Add;
								var xlSheet1 = xlBook.Worksheets(1);

								var rows=pDataRowSet.count();
								var cols = 0;
								if   (pHeadShowColNums!=null&&pHeadShowColNums!="0"){
								    cols=pHeadShowColNums;//�����������ʾ��ͷ����Ŀ�������򰴴���ʾ
								  }else{
								    cols = pDataRowSet.getVisiColCount();//������ʾ���е���Ŀ
								  }

								var i,j;
								var curRow =0;




								var colName ="";
								var colVal ="";
				//��ʾ�����ͷ
				//�ϲ���Ԫ�񣬲���ʾ
				 var  m=0;
				if   (pTitle){
				      xlSheet1.Range(xlSheet1.cells(1,1),xlSheet1.cells(1,cols)).Merge();//Select();
					xlSheet1.cells(1,1).value=pTitle;
					//���С�����
					xlSheet1.cells(1,1).HorizontalAlignment = -4108;
					xlSheet1.cells(1,1).VerticalAlignment = -4108;
				      m=1;
				      curRow=1;
				 }

				//��ʾ����
								if(pIsShowHeadText)
								{
									  var n=0;
									  for(n=0;n<cols;n++)
										{
									      xlSheet1.cells(m+1,n+1).value = pDataRowSet.getTitleByIndex(n);
										}
									 curRow++;
									 m=m+1;//��ʽ�������������
									 //�趨��ͷ�ĵ�ɫ
									 xlSheet1.Range(xlSheet1.cells(2,1),xlSheet1.cells(2,cols)).Interior.ColorIndex = 37;
								}
								for(i=0;i<rows;i++){
								   for(j=0;j<cols;j++)
									  {

										colName = pDataRowSet.getNameByIndex(j);
										//alert(colName);
										colVal = pDataRowSet.getDisplayText(i,colName);
                    
										
										//����Ϊ�ı���ʽ
										xlSheet1.cells(curRow+i+1,j+1).NumberFormatLocal = "@";
										//end of ��Ԫ��ĸ�ʽ
										xlSheet1.cells(curRow+i+1,j+1).value = colVal;
										colName ="";
										colVal ="";
									  }
								}
								   //���ߡ�����
								   xlSheet1.Range(xlSheet1.cells(2,1),xlSheet1.cells(rows+m,cols)).Borders.LineStyle = 1;//xlContinuous;
								   xlSheet1.Range(xlSheet1.cells(2,1),xlSheet1.cells(rows+m,cols)).Borders.ColorIndex = -4105;//xlContinuous;
								   //��ͷ��˫��
								   xlSheet1.Range(xlSheet1.cells(2,1),xlSheet1.cells(2,cols)).Borders(9).LineStyle =  -4119;//xlDouble=-4119  xlEdgeBottom = 9
								   xlApp.Visible = true;
//								xlApp.quit();
								//xlApp = null;

						}
					catch(e) {
								if(e.name=="Error")
								{
								  alert(g_I18NMessage("appframe_core","datarowset_add"));
								}
								else
								  alert(g_I18NMessage("appframe_core","datarowset_syserr")+e.message);
				if(xlApp)
								  {
									 xlApp.quit();
									 xlApp = null;
								  }


						}


    }
}