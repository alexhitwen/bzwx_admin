<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
	String parentId = request.getParameter("parentId");
	String cateId = request.getParameter("cateId");
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

	var parentId = '<%=parentId%>';
	var cateId = '<%=cateId%>';
	if (null != parentId && "null" != parentId) {
		var url = "${ctx}/category/category!getListByParentId.action?parentId="
				+ parentId;
	} else {
		var url = "${ctx}/category/category!getAllList.action";
	}

	$.post(url, function(jsonArrayData) {
		$.each(jsonArrayData.list,
				function(key, o) {
					$("#parentId").append(
							"<option value='"+o.cateId+"'>" + o.cateName
									+ "</option>");
				});
	});

	if (null != cateId && "null" != cateId && "" != cateId) {//修改的时候回显信息
		var url = "${ctx}/category/category!getCategoryById.action?cateId="
				+ cateId;
		$.post(url, function(jsonObjectData) {
			$("#cateId").val(jsonObjectData.category.cateId);
			$("#cateName").val(jsonObjectData.category.cateName);
			$("#parentId").val(jsonObjectData.category.parentId); //新增的时候添加父节点信息
			$("#cateCode").val(jsonObjectData.category.cateCode);
			$("#cateValue").val(jsonObjectData.category.cateValue);
			$("#cateNote").val(jsonObjectData.category.cateNote);
			$("#cateDesc").val(jsonObjectData.category.cateDesc);
			$("#sortFlag").val(jsonObjectData.category.sortFlag);
			$("#cateStatus").val(jsonObjectData.category.cateStatus);
		});
	}

	$("#parentId").val(parentId); //新增的时候添加父节点信息

	function submitForm() {
		if (validateForm()) {
			$("#categoryForm").submit();
		}
	}
	function validateForm() {
		return true;
	}
	function setCateValue(o) {
		$("#cateValue").val(o.value);
	}
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br>
		<b>——||<a href="${ctx }/admin/category/categoryManage.jsp">全局新增</a>||——————————————————————————<a
			href="${ctx }/admin/category/categoryTreeList.jsp?parentId=<%=parentId%>">||返回||</a>
		</b>———————<br>
		<br>
		<div align="left">

			<table style="margin-left: 200px">
				<tr>
					<td width="100%">
						<form method="post" name="categoryForm" id="categoryForm"
							action="${ctx}/category/insertOrUpdateAction!insertOrUpdate.action">
							<table id="formTable1" width="100%" height="100%" align="center"
								cellpadding="0" cellspacing="0">
								<tr style="height: 12px;">
									<td>所属分类：</td>
									<td><select id="parentId" name="parentId"
										style="width: 158px"></select><font color=red>*</font>（点击<font
										color=blue><a
											href="${ctx }/admin/category/categoryManage.jsp">全局新增</a>
									</font>任意选择）</td>
								</tr>
								<tr>
									<td colspan="2"><input id="cateId" name="cateId" value=""
										type="hidden" readonly="readonly" />
									</td>
								</tr>
								<tr style="height: 12px;">
									<td>分类名称：</td>
									<td><input id="cateName" name="cateName" value=""
										maxlength="200" type="text" /><font color=red>*</font>（限200）</td>
								</tr>
								<tr style="height: 12px;">
									<td>分类代号：</td>
									<td><input id="cateCode" name="cateCode" value=""
										onchange="setCateValue(this)" onkeypress="setCateValue(this)"
										onmousedown="setCateValue(this)"
										onkeydown="setCateValue(this)" maxlength="200" type="text" /><font
										color=red> </font>（限100）</td>
								</tr>
								<tr style="height: 12px;">
									<td>分类拼音值：</td>
									<td><input id="cateValue" name="cateValue" value=""
										maxlength="200" type="text" /> （限100）</td>
								</tr>
								<tr style="height: 12px;">
									<td>分类批注：</td>
									<td><input id="cateNote" name="cateNote" value=""
										maxlength="200" type="text" /> （限400）</td>
								</tr>
								<tr style="height: 12px;">
									<td>分类描述：</td>
									<td><input id="cateDesc" name="cateDesc" value=""
										maxlength="200" type="text" /> （限2000）</td>
								</tr>
								<tr style="height: 12px;">
									<td>排序：</td>
									<td><input id="sortFlag" name="sortFlag" value=""
										maxlength="200" type="text" /> （限数字，后续自动）</td>
								</tr>
								<tr style="height: 12px;">
									<td>状态：</td>
									<td><input id="cateStatus" name="cateStatus" value="0"
										maxlength="200" type="text" /><font color=red>*</font>（限数字1位：
										0，未同步；1，已同步；2，无需同步；3，等侯同步）</td>
								</tr>
								<tr align="center">
									<td colspan="2"><br>
									<br> <input value="确 定" onclick="submitForm()"
										type="button" /><input value="重 置" onclick="reset()"
										type="button" /></td>
								</tr>

							</table>
						</form></td>
					<!-- 
				<td width="50%"><s:form method="post"
						action="/category/category!insertOrUpdate.action">
						<table id="formTable2" width="100%" height="100%" align="center"
							cellpadding="0" cellspacing="0">
							<tr style="height: 12px;">
								<td>所属分类：</td>
								<td><select id="parentSelect" name="parentSelect"
									style="width: 152px"></select><font color=red>*</font></td>
							</tr>
							<tr style="height: 12px;">
								<td>分类主键：</td>
								<td><input id="cateId" name="cateId" value="自动匹配"
									type="text" readonly="readonly" /><font color=red>*</font></td>
							</tr>
							<tr style="height: 12px;">
								<td>分类名称：</td>
								<td><input id="cateName" name="cateName" value=""
									maxlength="200" type="text" /><font color=red>*</font></td>
							</tr>
							<tr style="height: 12px;">
								<td>拼音代码：</td>
								<td><input id="cateCode" name="cateCode" value=""
									maxlength="200" type="text" /><font color=red>*</font></td>
							</tr>
							<tr style="height: 12px;">
								<td>分类值：</td>
								<td><input id="cateValue" name="cateValue" value=""
									maxlength="200" type="text" /></td>
							</tr>
							<tr style="height: 12px;">
								<td>分类批注：</td>
								<td><input id="cateNote" name="cateNote" value=""
									maxlength="200" type="text" /></td>
							</tr>
							<tr style="height: 12px;">
								<td>分类描述：</td>
								<td><input id="cateDesc" name="cateDesc" value=""
									maxlength="200" type="text" /></td>
							</tr>
							<tr style="height: 12px;">
								<td>排序：</td>
								<td><input id="sortFlag" name="sortFlag" value=""
									maxlength="200" type="text" /></td>
							</tr>
							<tr style="height: 12px;">
								<td>状态：</td>
								<td><input id="cateStatus" name="cateStatus" value=""
									maxlength="200" type="text" /></td>
							</tr>
							<tr align="center">
								<td colspan="2"><input value="确 定" onclick="submit()"
									type="button" /><input value="重 置" onclick="reset()"
									type="button" />
								</td>
							</tr>
						</table>
					</s:form></td> -->
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
