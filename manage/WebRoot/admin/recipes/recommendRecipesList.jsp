<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'catagoryList.jsp' page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript">
	window.location.href = "http://192.168.0.114:8080/manage/recipes/recipes!getInfoByMap.action?recId=1";
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br> <b>——||<a
			href="${ctx}/admin/category/categoryTreeList.jsp">推荐菜品管理</a>||</b>
		————————————————————————————————————<br> <br>
		<table id="tab1" width="100%" height="100%">
			<tr>
				<td width="12%" valign="top">推荐菜品管理。。</td>
			</tr>
		</table>

	</div>

</body>
</html>
