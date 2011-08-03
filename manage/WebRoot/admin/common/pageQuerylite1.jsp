<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.6.2.min.js"></script>
</head>
<body>
	<div align="right">
		<table>
			<tr>
				<td id="pagequerytable1"></td>
			</tr>

		</table>
	</div>
</body>
<script type="text/javascript">
	var v = "";
	var count = 10;
	for ( var i = 1; i <= 10; i++) {
		v = v + "&nbsp;" + "<a href='javascript:pageQuery("
				+ ((i - 1) * count + 1) + "," + (i * count) + ")'> " + i
				+ " </a>";
	}
	$("#pagequerytable1").html(v);

	function clearSearchKey() {
		$("#searchKey1").val("");
	}
</script>
</html>
