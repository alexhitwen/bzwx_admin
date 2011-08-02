<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title"></tiles:getAsString>
		</title>
	</head>
	<body>
		<table width="1050" height="800px" border="2" align="center">

			<tr>
				<td colspan="2" align="left" valign="top" width="100%" height="30px">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td align="left" width="120" valign="top">
					<tiles:insertAttribute name="leftmenu" />
				</td>
				<td align="left" valign="top" width="900" >
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<%-- 
			<tr>
				<td colspan="2" bgcolor="#00ff40" height="100px">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
			 --%>
		</table>
	</body>
</html>