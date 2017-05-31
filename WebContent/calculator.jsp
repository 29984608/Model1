<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>案例一</title>
</head>
<body>

	<jsp:useBean id="calculator" class="eurasia.javaweb.Calculator" />
	<jsp:setProperty property="*" name="calculator"/>

	<%
		if(calculator.validate())
		{ 
	%>
	<font color="green">运算结果：
	<jsp:getProperty property="fristNum" name="calculator"/>
	<jsp:getProperty property="operator" name="calculator"/>	
	<jsp:getProperty property="secondNum" name="calculator"/>
	= <%=calculator.calculate() %> </font>
	<%
   	 	}else {
    		Map<String,String>errors=calculator.getErrors();
    		pageContext.setAttribute("errors", errors);
    	}
	%>
	<form action="" method="POST">
	第一个运算数：<input type="text" name="fristNum">
	<font color="red">${errors.fristNum}</font><br>
	运算符：<select name="operator" style="margin-left:100px">
	<option value="+">+</option>
	<option value="-">-</option>
	<option value="*">*</option>
	<option value="/">/</option>
	</select><br>
	第二个运算数：<input type="text" name="secondNum">
	<font color="red">${errors.senondNum}</font><br>
	<input type="submit" value="计算">
</form>

</body>
</html>