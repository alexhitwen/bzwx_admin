<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
	String parentId = request.getParameter("parentId") == null
			? "1"
			: request.getParameter("parentId");
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
	var rightCategoryIframeSrc;
	var parentId = '<%=parentId%>';
	if ("null" == parentId) {
		parentId = 1;
	}
	$(document)
			.ready(
					function() {
						var url = "${ctx}/category/category!getChildListByParentId.action?cateId=1";
						$.post(url, function(jsondata) {
							//渲染左栏页面
							renderingPage(jsondata);
							//初始化所有栏目
							getChildList(parentId);
						});
					});

	function renderingPage(jsondata) {
		$.each(jsondata.list, function(key, o) {
			var trLeft = $("<tr><td><a href=javascript:getChildList("
					+ o.cateId + ")>" + o.cateName + "</a></td></tr>");
			$("#tabLeft").append(trLeft);
		});
	}

	function getChildList(v) {
		$("#tabRight")
		.html(
				"<td>|主键</td><td>|父节点</td><td>|分类名称</td><td>|分类代号</td><td>|分类拼音值</td><td>|分类批注</td>"
						+ "<td>|分类描述</td><td>|排序</td><td>|状态</td><td>|操作| - <a href='javascript:insertItem("
								+ v
								+ ")'><font color=red>|添加|</font></a></td></tr>");
		var url = "${ctx}/category/category!getChildListByParentId.action?cateId="
				+ v;

		$.post(url, function(jsondata) {
			//渲染右栏页面
			$.each(jsondata.list, function(key, o) {
				var tr = $("<tr>" + "<td>" + o.cateId + "</td>" + "<td>"
						+ o.parentId + "</td>" + "<td>" + o.cateName + "</td>"
						+ "<td>" + o.cateCode + "</td>" + "<td>" + o.cateValue
						+ "</td>" + "<td>" + o.cateNote + "</td>" + "<td>"
						+ o.cateDesc + "</td>" + "<td>" + o.sortFlag + "</td>"
						+ "<td>" + o.cateStatus + "</td>"
						+ "<td><a href=javascript:updateItem(" + o.cateId + ","
						+ o.parentId + ")><font color=red>修改</font>"
						+ "</a>  <a href=javascript:deleteItem(" + o.cateId
						+ "," + o.parentId
						+ ")><font color=red>删除</font></a></td>" + "</tr>");
				$("#tabRight").append(tr);
			});
		});
	}

	function insertItem(v) {
		window.location.href = "${ctx}/admin/category/categoryManage.jsp?parentId="
				+ v;
	}

	function updateItem(v1, v2) {
		window.location.href = "${ctx}/admin/category/categoryManage.jsp?cateId="
				+ v1 + "&parentId=" + v2;
	}

	function deleteItem(v1, v2) {
		window.location.href = "${ctx}/category/deleteAction!deleteById.action?cateId="
				+ v1 + "&parentId=" + v2;
	}
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br>
		<b>——||<a href="${ctx}/admin/category/categoryTreeList.jsp">栏目树管理</a>||</b>
		————————————————————————————————————<br>
		<br>

		<table id="tab1" width="100%" height="100%">
			<tr>
				<td width="12%" valign="top">
					<table id="tabLeft" width="100%">
						<tr>
							<td><a href="${ctx}/admin/category/categoryTreeList.jsp"><font
									color=red>分类根节点</font> </a>
							</td>
						</tr>
					</table></td>
				<td width="88%" valign="top"><table id="tabRight">
						<tr>
							<td>|分类主键</td>
							<td>|父节点</td>
							<td>|分类名称</td>
							<td>|分类代号</td>
							<td>|分类拼音值</td>
							<td>|分类批注</td>
							<td>|分类描述</td>
							<td>|排序</td>
							<td>|状态</td>
							<td>|操作|</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</div>

	<div></div>
</body>
</html>
