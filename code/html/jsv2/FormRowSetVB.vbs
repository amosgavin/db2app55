'����textArea��innerText�еĻس����з���ת��Ϊ"\n"
 Function ReplaceCrLfToOther(srcText)
	  IF IsNull(srcText) THEN
	     ReplaceCrLfToOther = ""
      ELSE
	     ReplaceCrLfToOther = replace(srcText, vbCrLf,"\n")   '���滻
      END IF
 End Function


 '�����ݿ���ȡ�õ������е�\n��־�����滻Ϊ�س����з���
 Function ReplaceOtherToCrLf(srcText)
      IF IsNull(srcText) THEN
	     ReplaceOtherToCrLf = ""
      ELSE
	   ReplaceOtherToCrLf = replace(srcText,"\n",vbCrLf)
      END IF
 End Function