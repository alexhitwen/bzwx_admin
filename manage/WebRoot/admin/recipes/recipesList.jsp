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
	
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br> <b>——||<a
			href="${ctx}/recipes/pageQuery!pageQuery.action">菜品首页</a>||——||<a
			href="${ctx}/admin/recipes/recipesManage.jsp">新增菜品</a>||</b>
		————————————————————————————————————<br>
		<jsp:include page="/admin/common/pageQuery.jsp"></jsp:include>
		<br>

		<table id="tab1">
			<tr valign="top" height="10%">
				<td>菜品主键</td>
				<td>菜品名称</td>
				<td>菜品代号</td>
				<td>所属分类</td>
				<td>菜品价格</td>
				<td>菜品折扣价</td>
				<td>菜品图片</td>
				<td>菜品批注</td>
				<td>菜品详情</td>
				<td>排序字段</td>
				<td>菜品版本</td>
				<td>同步状态</td>
				<td>创建时间</td>
				<td>修改时间</td>
				<td>操作人员</td>
				<td>操作</td>
			</tr>
			<s:iterator value="pageList" id="recipes" status="st">
				<tr valign="top">
					<td valign="top"><s:property value="#recipes.recId" /></td>
					<td valign="top"><s:property value="#recipes.recName" /></td>
					<td valign="top"><s:property value="#recipes.recCode" /></td>
					<td valign="top"><s:property value="#recipes.recCateName" />
					</td>
					<td valign="top"><s:property value="#recipes.recPrice" /></td>
					<td valign="top"><s:property value="#recipes.recDiscountPrice" />
					</td>
					<td valign="top"><a href="${ctx}<s:property value="#recipes.recPicUrl"/>" target="_blank">预览</a></td>
					<td valign="top"><s:property value="#recipes.recNote" /></td>
					<td valign="top"><s:property value="#recipes.recDesc" /></td>
					<td valign="top"><s:property value="#recipes.sortFlag" /></td>
					<td valign="top"><s:property value="#recipes.recVersion" /></td>
					<td valign="top"><s:property value="#recipes.recStatus" /></td>
					<td valign="top"><s:property value="#recipes.createDate" /></td>
					<td valign="top"><s:property value="#recipes.updateDate" /></td>
					<td><a
						href="${ctx}/updateRecipes!getInfo.action?recId=<s:property value="#recipes.recId"/>">修改</a>
						<a
						href="${ctx}/recipes/deleteRecipes!deleteById.action?recId=<s:property value="#recipes.recId"/>">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<script type="text/javascript">
		var searchKey = '<%=(String) request.getAttribute("searchKey")%>';
		if (searchKey == "null") {
			searchKey = "";
		}
		searchKey = encodeURI(encodeURI(searchKey));
		$("#searchKey").val(decodeURI(decodeURI(searchKey)));

		function updateItem(v) {
			window.location.href = "${ctx}/updateRecipes!getInfo.action?recId="
					+ v
					+ "&beginNum="
					+ beginNum
					+ "&endNum="
					+ endNum
					+ "&searchKey=" + searchKey;
		}
		function deleteItem(v) {
			alert(v);
			window.location.href = "${ctx}/recipes/deleteRecipes!deleteById.action?recId="
					+ v
					+ "&beginNum="
					+ beginNum
					+ "&endNum="
					+ endNum
					+ "&searchKey=" + searchKey;
		}

		function pageQuery(beginNum, endNum) {
			searchKey = $("#searchKey").val();
			window.location.href = "${ctx}/recipes/pageQuery!pageQuery.action?beginNum="
					+ beginNum
					+ "&endNum="
					+ endNum
					+ "&searchKey="
					+ searchKey;
		}

		function searchByKey() {
			searchKey = $("#searchKey").val();
			window.location.href = "${ctx}/recipes/pageQuery!pageQuery.action?searchKey="
					+ searchKey;
		}

		function UrlEncode(str) {
			var ret = "";
			var strSpecial = "!\"#$%&'()*+,/:;<=>?[]^`{|}~%";
			for ( var i = 0; i < str.length; i++) {
				var chr = str.charAt(i);
				var c = str2asc(chr);
				if (parseInt("0x" + c) > 0x7f) {
					ret += "%" + c.slice(0, 2) + "%" + c.slice(-2);
				} else {
					if (chr == " ")
						ret += "+";
					else if (strSpecial.indexOf(chr) != -1)
						ret += "%" + c.toString(16);
					else
						ret += chr;
				}
			}
			return ret;
		}
	</script>
</body>
</html>
