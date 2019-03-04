<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
</head>
<body>
	<form action="update" method="post">
			<input type="hidden" name="id" value="${student.id }">
			<input type="hidden" name="currentPage" value="${currentPage }">
			<input type="hidden" name="qname" value="${qname }">
			<input type="hidden" name="qusername" value="${qusername }">
			<input type="hidden" name="qsex" value="${qsex }">
		姓名：<input type="text" name="name" value="${student.name }"><br/>
		帐号：<input type="text" name="username" value="${student.username }"><br/>
		密码：<input type="password" name="password" value="${student.password }"><br/>
		性别：<input type="radio" name="sex" value="1" <c:if test="${student.sex==1 }">checked="checked"</c:if>>男
			<input type="radio" name="sex" value="0" <c:if test="${student.sex==0 }">checked="checked"</c:if>>女<br/>
		年龄：<input type="text" name="age" value="${student.age }"><br/>
		出生日期：<input type="date" name="birthday" value="${student.birthday }"><br/>
			<input type="submit" value="提交"><br/>
	</form>
</body>
</html>