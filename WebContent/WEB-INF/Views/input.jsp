<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<form:form action="/Yamiedie/mingge/emp" method="post" modelAttribute="employee">

id<form:input path="id"/><br>
姓名<form:input path="name"/><br>
性别<form:input path="sex"/><br>
年龄<form:input path="age"/><br>
部门名称<form:select path="department.id" items="${departments}" itemLabel="dName" itemValue="id"></form:select> 
<input type="hidden" name="_method" value="PUT">
<input type="submit" value="提交">
</form:form>
</body>
</html>