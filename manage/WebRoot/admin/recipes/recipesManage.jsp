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
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js">
	
</script>

<script type="text/javascript">
	function uploadImage() {
		alert("a");
	}

	function submitForm() {
		if (validateForm()) {
			$("#recipesForm").submit();
		}
	}
	function validateForm() {
		return true;
	}
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left">
		<br> <b>——||<a href="${ctx}/admin/recipes/recipesManage.jsp">菜品管理</a>
		</b>|| ———————————————————————————————||<b><a
			href="${ctx}/recipes/pageQuery!pageQuery.action">返回</a> </b>||——<br>
		<br> <br>




		<s:form action="fileUpload" method="POST"
			enctype="multipart/form-data">

			<!-- <s:textfield name="caption" label="Caption"></s:textfield> -->

			<table id="tab1" width="50%" style="margin-left: 200px">
				<tr style="height: 12px;">
					<td colspan="2"><s:textfield name="recId" label="RecId"></s:textfield><input
						type="text" id="recId" name="recId" value="" /></td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品名称</td>
					<td><s:textfield name="recName" label="RecName"></s:textfield><font
						color=red>*</font>（限200）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品拼音</td>
					<td><s:textfield name="recCode" label="RecCode"></s:textfield><font
						color=red>*</font>（限100）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品价格</td>
					<td><input type="text" id="recPrice" name="recPrice"
						value="111" /><font color=red>*</font>（限数字）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品折扣价</td>
					<td><input type="text" id="recDiscountPrice"
						name="recDiscountPrice" value="111" /> （限数字）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品图片</td>
					<td><s:file size="10" name="image"></s:file></td>
				</tr>
				<!--  
				<tr style="height: 12px;">
					<td>&nbsp;</td>
					<td><img alt="" src="/样式 (1).bmp"><a
						href="javascript:uploadImage()">点击预览</a>
					</td>
				</tr>-->
				<tr style="height: 12px;">
					<td>菜品批注</td>
					<td><input type="text" id="recNote" name="recNote"
						value="菜品批注" /> （限400）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品详情</td>
					<td><input type="text" id="recDesc" name="recDesc"
						value="菜品详情" /> （限2000）</td>
				</tr>
				<tr style="height: 12px;">
					<td>排序标识</td>
					<td><input type="text" id="sortFlag" name="sortFlag" value="1" />
						（限数字）</td>
				</tr>
				<tr style="height: 12px;">
					<td>菜品版本</td>
					<td><input type="text" id="recVersion" name="recVersion"
						value="1" /> （限数字）</td>
				</tr>
				<tr style="height: 12px;">
					<td>同步状态</td>
					<td><input type="text" id="recStatus" name="recStatus"
						value="1" /> （限数字1位）</td>
				</tr>
				<tr style="height: 12px;">
					<td>创建时间</td>
					<td><input type="text" id="createDate" name="createDate"
						onclick="WdatePicker();" readonly="readonly" value="" /> （限日期）</td>
				</tr>
				<tr style="height: 12px;">
					<td>修改时间</td>
					<td><input type="text" id="updateDate" name="updateDate"
						onclick="WdatePicker();" readonly="readonly" value="" /> （限日期）</td>
				</tr>
				<tr align="center">
					<td colspan="2"><br> <br> <s:submit value="提交" /><input
						value="重 置" onclick="reset()" type="button" /></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
