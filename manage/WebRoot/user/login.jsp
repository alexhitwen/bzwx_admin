<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
.STYLE1 {
	color: #FF0000;
	font-size: 12px;
}
</style>
</head>

<body>
	<table cellpadding="0" cellspacing="0" width="100%" height="305"
		border="0">
		<tr>
			<td height="35">
				<table cellpadding="0" cellspacing="0" width="100%" height="35"
					border="0">
					<tr bgcolor="#ffffff">
						<td width="10%"><img border="0"
							src="${pageContext.request.contextPath}/images/gl_head_logo.jpg"
							width="221" height="61">
						</td>
						<td width="23%">&nbsp;</td>
						<td width="40%" style="padding-top: 25px;">
							<h1 style="color: red;">遍在无线-餐饮管理平台</h1>
						</td>
						<td align="right" background=""><img
							src="${pageContext.request.contextPath}/images/window_07.jpg"
							width="100%" height="100%">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="2" valign="bottom" style="background-color: #C6E0FB">
			</td>
		</tr>
		<tr>
			<td height="400" valign="bottom">
				<div align="center">
					<s:form method="post" action="/user/login.action">
						<table cellpadding="0" cellspacing="0" width="220" height="120"
							id="table1">
							<%-- 可以直接用username,或者passwd等模型的属性 --%>
							<tr>
								<td colspan="2"><s:textfield name="model.username"
										label="用户名" maxlength="40"></s:textfield>
								</td>
							</tr>
							<tr>
								<td colspan="2"><s:password name="model.passwd" label="密码"
										maxlength="40"></s:password>
								</td>
							</tr>
							<tr>
								<td colspan="2"><span class="STYLE1"><s:property
											value="model.message" /> </span>
								</td>
							</tr>
							<tr>
								<Td><s:token></s:token> <s:submit value="确定"></s:submit>
								</Td>
								<td><s:reset value="重置"></s:reset>
								</td>
							</tr>
						</table>
					</s:form>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>
