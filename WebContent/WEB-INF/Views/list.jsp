<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://"
  + request.getServerName() + ":" + request.getServerPort()
  + path + "/";
%>
<script type="text/javascript" src="<%=basePath%>scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var href = $(this).attr("href");
		
		$("form").attr("action",href).submit();			
		return false;
	});
})
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	
<c:if test="${empty requestScope.employees}">
	没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
	<table>
	<tr>
	<th>员工id</th>
	<th>姓名</th>
	<th>性别</th>
	<th>年龄</th>
	<th>部门</th>
	</tr>
	<c:forEach items="${requestScope.employees }" var="emp">
	<tr>
	<td>${emp.id }</td>
	<td>${emp.name }</td>
	<td>${emp.sex }</td>
	<td>${emp.age }</td>
	<td>${emp.department.id }</td>
	<td>${emp.department.dName }</td>
	<td><a  href="emp/${emp.id }">修改</a></td>
	<td><a class="delete" href="emp/${emp.id }">删除</a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	<br><br>
	<a href="emp">添加</a>
</body>
</html>