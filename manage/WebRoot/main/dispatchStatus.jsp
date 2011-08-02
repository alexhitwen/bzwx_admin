<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎光临</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/tool.js">
</script>
		<script language="javascript" type="text/javascript"
			src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js">
</script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/DwrSping.js'>
</script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'>
</script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'>
</script>

		<SCRIPT type="text/javascript">
function getRecord() {
	var etlDate = dwr.util.getValue("etlDate");
	if(etlDate.trim() == "") {
		alert("请选择ETL时间！");
		$('etlDate').focus();
	} else {
		dwr.engine.setPreHook(function(){
			$('loading').style.display = "";
			dwr.util.setValue("Div_Record", "", {escapeHtml:false});
		});
		DwrSping.getDispatchStatus(etlDate, function(data){
			dwr.util.setValue("Div_Record", data, {escapeHtml:false});
		});
		dwr.engine.setPostHook(function(){
			$('loading').style.display = "none";
		});
	}
}
</SCRIPT>
	</head>
	<body>
		<h4>
			批量调度状态
		</h4>
		<table>
			<tr>
				<td>
					ETL时间:
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					<input type="text" name="etlDate" id="etlDate" onclick="WdatePicker();" readonly="readonly"
						value="${session.TodayDate}" />
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					<input type="button" value="确定" onclick="getRecord()" />
				</td>
				<td>
					&nbsp;
				</td>
				<td id="loading" style="display: none;">
					<font color='red'>正在查询，请稍后...</font>
				</td>
			</tr>
		</table>
		<div id="Div_Record" style="width: 920; height: 700; overflow-y: scroll; border: solid 1;"></div>
	</body>
</html>

