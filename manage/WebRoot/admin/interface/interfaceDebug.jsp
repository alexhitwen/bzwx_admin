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
	var showDataIframe;

	$(document).ready(function() {
		showDataIframe = document.getElementById("showDataIframe");
	});

	function debugInterface(url) {
		$("#url").html(
				"——      <a href='"+url+"' target='blank'>" + url + "</a>");
		showDataIframe.src = url;
	}
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br> <b>——||<a
			href="${ctx}/admin/interface/interfaceDebug.jsp">接口测试</a>||——</b>需要使用Chrome调试
		<p id="url">&nbsp;</p>

		<table id="tab1" width="100%" height="100%">
			<tr>
				<td width="12%" valign="top">
					<table id="tabLeft" width="100%">
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getAllList.action')"><font
									color=green>分类所有列表</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getCategoryById.action?cateId=1')"><font
									color=green>分类更新对象</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getAllList.action')"><font
									color=green>分类更新列表</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/recipes/recipes!getAllList.action')"><font
									color=green>菜谱所有列表</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getAllList.action')"><font
									color=green>菜谱更新对象</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getAllList.action')"><font
									color=green>菜谱更新列表</font> </a></td>
						</tr>
						<tr>
							<td><a
								href="javascript:debugInterface('${ctx}/category/category!getAllList.action')"><font
									color=green>...</font> </a></td>
						</tr>
					</table>
				</td>
				<td width="88%" valign="top">

					<div style="border: 0px solid; height: 560px;">
						<iframe scrolling=yes frameborder=0 marginwidth=0 marginheight=0
							id="showDataIframe" name="showDataIframe" src="" width="100%"
							height="100%"> </iframe>
					</div></td>
			</tr>
		</table>

	</div>

	<div></div>
</body>
</html>
