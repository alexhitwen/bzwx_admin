<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
	String cateId = request.getParameter("cateId");
	String parentId = request.getParameter("parentId");
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
			href="${ctx}/admin/category/categoryTreeList.jsp">栏目首页</a>||——||<a
			href="${ctx}/recipes/pageQuery!pageQuery.action">菜品首页</a>||</b>
		————————————————————————————————————<br>
		<table>
			<tr>

				<td width="50%"><table id="tab1" border="1">
						<tr valign="top" height="10%">
							<td colspan="7" align="center">全部菜品</td>
						</tr>
						<tr valign="top" height="10%">
							<td>菜品名称</td>
							<td>菜品代号</td>
							<td>菜品价格</td>
							<td>菜品折扣价</td>
							<td>菜品图片</td>
							<td>同步状态</td>
							<td>操作</td>
						</tr>
						<s:iterator value="AllList" id="recipes" status="st">
							<tr valign="top">
								<td valign="top"><s:property value="#recipes.recName" />
								</td>
								<td valign="top"><s:property value="#recipes.recCode" />
								</td>
								<td valign="top"><s:property value="#recipes.recPrice" />
								</td>
								<td valign="top"><s:property
										value="#recipes.recDiscountPrice" /></td>
								<td valign="top"><a
									href="${ctx}<s:property value="#recipes.recPicUrl"/>"
									target="_blank">预览</a>
								</td>
								<td valign="top"><s:property value="#recipes.recStatus" />
								</td>
								<td><a
									href="${ctx}/updateRecipes!getInfo.action?recId=<s:property value="#recipes.recId"/>">添加到本栏</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div align="right">
						<table>
							<tr>
								<td id="pagequerytable1"></td>
							</tr>

						</table>
					</div></td>


				<td width="10%" align="center"><b>&gt;&gt;</b>
				</td>

				<td width="40%">
					<table id="tab1" border="1">
						<tr valign="top" height="10%">
							<td colspan="7" align="center">当前栏目</td>
						</tr>
						<tr valign="top" height="10%">
							<td>菜品名称</td>
							<td>菜品代号</td>
							<td>菜品价格</td>
							<td>菜品折扣价</td>
							<td>菜品图片</td>
							<td>同步状态</td>
							<td>操作</td>
						</tr>
						<s:iterator value="pageList" id="recipes" status="st">
							<tr valign="top">
								<td valign="top"><s:property value="#recipes.recName" />
								</td>
								<td valign="top"><s:property value="#recipes.recCode" />
								</td>
								<td valign="top"><s:property value="#recipes.recPrice" />
								</td>
								<td valign="top"><s:property
										value="#recipes.recDiscountPrice" /></td>
								<td valign="top"><a
									href="${ctx}<s:property value="#recipes.recPicUrl"/>"
									target="_blank">预览</a>
								</td>
								<td valign="top"><s:property value="#recipes.recStatus" />
								</td>
								<td><a
									href="${ctx}/updateRecipes!getInfo.action?recId=<s:property value="#recipes.recId"/>">从本栏删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div align="right">
						<table>
							<tr>
								<td id="pagequerytable2"></td>
							</tr>

						</table>
					</div>
				</td>

			</tr>
		</table>

	</div>
	<script type="text/javascript">
		var v = "";
		var count = 10;
		for ( var i = 1; i <= 10; i++) {
			v = v + "&nbsp;" + "<a href='javascript:pageQuery("
					+ ((i - 1) * count + 1) + "," + (i * count) + ")'> " + i
					+ " </a>";
		}
		$("#pagequerytable1").html(v);
		$("#pagequerytable2").html(v);
	</script>

	<script type="text/javascript">
		function pageQuery(beginNum, endNum) {
			searchKey = $("#searchKey").val();
			window.location.href = "${ctx}/recipes/pageQuery!pageQuery.action?beginNum="
					+ beginNum
					+ "&endNum="
					+ endNum
					+ "&searchKey="
					+ searchKey;
		}
	</script>
</body>
</html>