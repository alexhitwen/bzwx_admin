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
	function clearUrl(){
		$("#recPicUrl").val("");
	}
</script>
</head>

<body>
	<div style="height: 558px; border: 1px solid; overflow: scroll;"
		align="left" >

		<br> <b>——||<a
			href="${ctx}/recipes/pageQuery!pageQuery.action">菜品首页</a>||——||<a
			href="${ctx}/admin/recipes/recipesManage.jsp">新增菜品</a>||
			————————————————————————————<a
			href="${ctx}/recipes/pageQuery!pageQuery.action">返回</a> </b>||——<br>
		<br> <br>
		<div style="">
		
		<s:form action="fileUpload" method="POST"
			enctype="multipart/form-data">

			<!--  <s:textfield name="caption" label="Caption"></s:textfield> -->
			<table id="tab1" width="50%" style="margin-left: 200px">
			
				<tr style="height: 12px;">
					<td colspan="2">
					<s:hidden name="recId" label="RecId" value="%{recipes.recId}"></s:hidden>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recName" label="菜品名称（必须，限200字）"
							value="%{recipes.recName}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recCode" label="菜品拼音（必须，限100字）"
							value="%{recipes.recCode}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recPrice" label="菜品价格（必须，限数字）"
							value="%{recipes.recPrice}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recDiscountPrice" label="菜品折扣价（可选，限数字）"
							value="%{recipes.recDiscountPrice}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:file size="10" name="image" onchange="clearUrl()" label="菜品图片"></s:file></td>
				</tr>
				
				
				<tr style="height: 12px;">
					<td><s:hidden name="recPicUrl" id="recPicUrl" label="菜品图片URL"
							value="%{recipes.recPicUrl}" ></s:hidden>
					</td>
				</tr>

				<!--  
				<tr style="height: 12px;">
					<td>&nbsp;</td>
					<td><img alt="" src="${ctx }/%{recipes.recPicUrl}"> </td>
				</tr>-->
				<tr style="height: 12px;">
					<td><s:textfield name="recNote" label="菜品批注（限400字）"
							value="%{recipes.recNote}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recDesc" label="菜品详情（限2000字）"
							value="%{recipes.recDesc}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="sortFlag" label="排序标识（限数字，后续自动）"
							value="%{recipes.sortFlag}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recVersion" label="菜品版本（限数字，默认值其实1）"
							value="%{recipes.recVersion}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="recStatus" label="同步状态（限数字，默认0尚未同步）"
							value="%{recipes.recStatus}"></s:textfield>
					</td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="createDate" label="创建时间"
							onclick="WdatePicker();" readonly="readonly"
							value="%{recipes.createDate}"></s:textfield></td>
				</tr>
				<tr style="height: 12px;">
					<td><s:textfield name="updateDate" label="修改时间"
							onclick="WdatePicker();" readonly="readonly"
							value="%{recipes.updateDate}"></s:textfield></td>
				</tr>
				<tr align="center">
					<td colspan="2"><br> <br> <s:submit value="提交" /></td>
				</tr>
			</table>
		</s:form>
		<img alt="" src="${ctx}${recipes.recPicUrl}" style="width: 800px;height: 600px" />
		</div>
	</div>

</body>
</html>
