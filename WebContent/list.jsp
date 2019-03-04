<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link type="text/css" href="css/style.css" rel="stylesheet">
</head>
<body>
	<div id="search">
		<form action="queryByPage" method="post">
			姓名：<input type="text" name="qname" value="${qname }">&nbsp;&nbsp;
			账号：<input type="text" name="qusername" value="${qusername }">&nbsp;&nbsp;
			性别：<select name="qsex">
					<option value="-1">--请选择--</option>
					<option value="1" <c:if test="${qsex==1 }">selected="selected"</c:if>>男</option>
					<option value="0" <c:if test="${qsex==0 && qsex!='' }">selected="selected"</c:if>>女</option>
				</select>&nbsp;&nbsp;
				<input type="submit" value="搜索"><br/>
		</form>
	</div>
	<table border=1 id="myTable">
		<tr>
			<th><input type="checkbox"></th>
			<th>编号</th>
			<th>姓名</th>
			<th>账号</th>
			<th>密码</th>
			<th>性别</th>
			<th>年龄</th>
			<th>出生日期</th>
			<th>创建时间</th>
			<th>操作
				<a href="add.jsp">新增</a>
				|
				<a href="#" onclick="deleteMore(${pager.sp },'${qname }','${qusername }','${qsex }');">批量删除</a>
			</th>
		</tr>

		<c:forEach var="student" items="${pager.list }">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);">
				<td><input type="checkbox" value="${student.id }"></td>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${student.username }</td>
				<td>${student.password }</td>
				<td>${student.sex==1?"男":"女" }</td>
				<td>${student.age }</td>
				<td>${student.birthday }</td>
				<td>${student.creatTime }</td>
				<td>
					<a href="queryById?id=${student.id }&currentPage=${pager.sp }&qname=${qname }&qusername=${qusername}&qsex=${qsex}">修改</a>
					|
					<a href="#" onclick="deleteById(${student.id},${pager.sp },'${qname }','${qusername }','${qsex }');">删除</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<div id="page">
		总记录数：${pager.totals }&nbsp;&nbsp;总页数：${pager.pageCounts }&nbsp;&nbsp;当前页：${pager.sp }&nbsp;&nbsp;
		<a href="queryByPage?currentPage=1&qname=${qname }&qusername=${qusername}&qsex=${qsex}">首页</a>&nbsp;&nbsp;
		<a href="queryByPage?currentPage=${pager.sp-1 }&qname=${qname }&qusername=${qusername}&qsex=${qsex}">上一页</a>&nbsp;&nbsp;
		<form action="queryByPage?qname=${qname }&qusername=${qusername}&qsex=${qsex}" method="post" style="display: inline;">
			<input type="text" name="currentPage" size="4" value="${pager.sp }">
		</form>
		<a href="queryByPage?currentPage=${pager.sp+1 }&qname=${qname }&qusername=${qusername}&qsex=${qsex}">下一页</a>&nbsp;&nbsp;
		<a href="queryByPage?currentPage=${pager.pageCounts }&qname=${qname }&qusername=${qusername}&qsex=${qsex}">末页</a>&nbsp;&nbsp;
	</div>
</body>
</html>