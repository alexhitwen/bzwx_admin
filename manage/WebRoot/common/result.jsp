<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	request.setAttribute("WebContextPath", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎光临</title>
	</head>
	<body>
		<h2>
			<s:property value="message" />
		</h2>
		<s:a href="%{#request.WebContextPath}/">返回</s:a>
	</body>
</html>
