<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'manage.jsp' page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.6.2.min.js"></script>
</head>
<script type="text/javascript">
	var rightIframe;

	$(document).ready(function() {
		rightIframe = document.getElementById("rightIframe");
	});
	function getCategoryManager(value) {
		rightIframe.src = value;
	}
</script>
<body>
	<div align="center">
		<table height="100%" width="100%" style="border: 1px solid;">
			<tr height="15%">
				<td colspan="2"><jsp:include page="/admin/common/top.jsp"></jsp:include></td>
			</tr>
			<tr height="80%">
				<td width="20%" height="100%" valign="top">
					<div style="border: 1px solid; height: 560px;">
						<table height="100%" width="90%" align="center">
							<tr align="center">
								<td>字典管理</td>
							</tr>
							<tr align="center">
								<td><a
									href="javascript:getCategoryManager('${ctx}/admin/category/categoryTreeList.jsp')"><b>分类管理</b>
								</a></td>
							</tr>
							<tr align="center">
								<td><a
									href="javascript:getCategoryManager('${ctx}/recipes/pageQuery!pageQuery.action')"><b>菜品管理</b>
								</a>
								</td>
							</tr>
							<tr align="center">
								<td><a
									href="javascript:getCategoryManager('${ctx}/getRecListByCateId!getRecListByCateId.action')"><b>菜品分类</b>
								</a>
								</td>
							</tr>
							<tr align="center">
								<td><a
									href="javascript:getCategoryManager('${ctx}/getRecListByCateId!getRecListByCateId.action?cateId=26&parentId=22')"><b><span style="red">*</span>推荐管理</b>
								</a>
								</td>
							</tr>
							<tr align="center">
								<td><a
									href="javascript:getCategoryManager('${ctx}/getRecListByCateId!getRecListByCateId.action?cateId=23&parentId=22')"><b>*促销管理</b>
								</a></td>
							</tr>
							<tr align="center">
								<td>热门排行</td>
							</tr>
							<tr align="center">
								<td><a href="javascript:getCategoryManager('${ctx}/admin/interface/interfaceDebug.jsp')"><b>接口测试</b> </a></td>
							</tr>
							<tr align="center">
								<td>订单管理</td>
							</tr>
							</tr>
							<tr align="center">
								<td>桌台管理</td>
							</tr>
							</tr>
							<tr align="center">
								<td>酒店管理</td>
							</tr>
							</tr>
							<tr align="center">
								<td>用户管理</td>
							</tr>
							<tr align="center">
								<td>权限管理</td>
							</tr>
							<tr align="center">
								<td>...</td>
							</tr>
						</table>
					</div>
				</td>
				<td height="100%" valign="top">
				<div style="border: 0px solid; height: 560px;"><iframe scrolling=yes 
						frameborder=0 marginwidth=0 marginheight=0
						id="rightIframe" name="rightIframe"
						src="${ctx }/admin/welcome.jsp" width="100%" height="100%">
					</iframe></div></td>
			</tr>
			<tr height="10%">
				<td colspan="2"><jsp:include page="/admin/common/bottom.jsp"></jsp:include></td>
			</tr>
		</table>

	</div>
</body>
</html>
