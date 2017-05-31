package eurasia.javaweb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Calculator {

	private String fristNum;//��һ����
	private String secondNum;//�ڶ�����
	private char operator;//�����
	private String err;
	private Map<String,String>errors=new HashMap<String,String>();//��װ������Ϣ
	
	//set��get����

	public String getFristNum() {
		return fristNum;
	}

	public void setFristNum(String fristNum) {
		this.fristNum = fristNum;
	}

	public String getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	
	//calculate()�������ݴ�������ݽ�������
	public String calculate(){
		BigDecimal result=null;
		BigDecimal frist=new BigDecimal(fristNum);
		BigDecimal second=new BigDecimal(secondNum);
		switch(operator){
		case '+': result=frist.add(second);break;
		case '-': result=frist.subtract(second);break;
		case '*': result=frist.multiply(second);break;
		case '/': if("0".equals(secondNum)){
			err ="��������Ϊ0";
			return err.toString();
//			throw new RuntimeException("��������Ϊ0");
		}
		result=frist.divide(second);break;
		default:
		break;
		}
		
		return result.toString();
		
	}
	
	
	
	
	//validate����������֤������������Ƿ�Ϸ�
	public boolean validate(){
		boolean flag=true;
		//flag�Ǳ�ʶ��������Ϸ�flagΪtrue,����Ϊfalse
		Pattern p=Pattern.compile("\\d+");
		if(fristNum==null||"".equals(fristNum)){
			errors.put("fristNum", "��һ������������Ϊ��");
			flag=false;
		}else if(!p.matcher(fristNum).matches()){
			errors.put("secondNum", "��һ���������ֱ���Ϊ����");
			flag=false;
		}
		if(secondNum==null||"".equals(secondNum)){
			errors.put(secondNum, "�ڶ�������������Ϊ��");
			flag=false;
		}else if(!p.matcher(secondNum).matches()){
			errors.put("secondNum", "�ڶ�������������Ϊ����");
			flag=false;
		}
		
		return flag;
		
	}
	
}
