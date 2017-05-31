package eurasia.javaweb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Calculator {

	private String fristNum;//第一个数
	private String secondNum;//第二个数
	private char operator;//运算符
	private String err;
	private Map<String,String>errors=new HashMap<String,String>();//封装错误信息
	
	//set和get方法

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

	
	//calculate()方法根据传入的数据进行运算
	public String calculate(){
		BigDecimal result=null;
		BigDecimal frist=new BigDecimal(fristNum);
		BigDecimal second=new BigDecimal(secondNum);
		switch(operator){
		case '+': result=frist.add(second);break;
		case '-': result=frist.subtract(second);break;
		case '*': result=frist.multiply(second);break;
		case '/': if("0".equals(secondNum)){
			err ="除数不能为0";
			return err.toString();
//			throw new RuntimeException("除数不能为0");
		}
		result=frist.divide(second);break;
		default:
		break;
		}
		
		return result.toString();
		
	}
	
	
	
	
	//validate方法用于验证表单传入的数据是否合法
	public boolean validate(){
		boolean flag=true;
		//flag是标识符，如果合法flag为true,否则为false
		Pattern p=Pattern.compile("\\d+");
		if(fristNum==null||"".equals(fristNum)){
			errors.put("fristNum", "第一个运算数不能为空");
			flag=false;
		}else if(!p.matcher(fristNum).matches()){
			errors.put("secondNum", "第一个运算数字必须为数字");
			flag=false;
		}
		if(secondNum==null||"".equals(secondNum)){
			errors.put(secondNum, "第二个运算数不能为空");
			flag=false;
		}else if(!p.matcher(secondNum).matches()){
			errors.put("secondNum", "第二个运算数必须为数字");
			flag=false;
		}
		
		return flag;
		
	}
	
}
