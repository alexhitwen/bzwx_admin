<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table>
	<tr>
		<td align="left">
			<s:a action="../main/dispatchStatus.action">批量调度状态</s:a>
		</td>
	</tr>
	<tr>
		<td align="left">
			<s:a href="%{#request.get('javax.servlet.forward.context_path')}/main/errLogRecord.action">错误日志记录</s:a>
		</td>
	</tr>
	<tr>
		<td align="left">
			<s:a href="%{#request.get('javax.servlet.forward.context_path')}/main/dispatchItem.action">批量调度细节</s:a>
		</td>
	</tr>
</table>