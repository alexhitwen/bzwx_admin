package com.test.dwr;

import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.model.DispatchModel;
import com.test.model.ErrLogRecord;
import com.test.service.IMonitorService;

@Controller
@RemoteProxy
public class DwrSping {
	@Autowired
	IMonitorService monitorService;

//	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 获取错误日志记录
	 * 
	 * @param etlDate
	 * @return
	 */
	@RemoteMethod
	public String getErrLogRecord(String etlDate) {
		String result = "";
		try {
			List<ErrLogRecord> list = monitorService.getErrLogRecord(etlDate);
			if (list.size() > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td align='left' width='100'>ETL时间</td>");
				sb.append("<td align='left' width='100'>开始时间</td>");
				sb.append("<td align='left' width='100'>结束时间</td>");
				sb.append("<td align='left' width='600'>错误描述</td>");
				sb.append("</tr>");
				for (ErrLogRecord record : list) {
					sb.append("<tr>");
					sb.append("<td>" + etlDate + "</td>");
					sb.append("<td>"
							+ (record.getStartTime() != null ? record
									.getStartTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getEndTime() != null ? record
									.getEndTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getErrMsg() != null ? record.getErrMsg()
									: "") + "</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				result = sb.toString();
			} else {
				result = "<font color='red'>没有错误信息...</font>";
			}
		} catch (Exception e) {
			result = "<font color='red'>出错了，请重试...</font>";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取批量调度细节
	 * 
	 * @param etlDate
	 * @return
	 */
	@RemoteMethod
	public String getDispatchItem(String etlDate) {
		String result = "";
		try {
			List<DispatchModel> list = monitorService.getDispatchItem(etlDate);
			if (list.size() > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td align='left' width='100'>ETL时间</td>");
				sb.append("<td align='left' width='200'>开始时间</td>");
				sb.append("<td align='left' width='200'>结束时间</td>");
				sb.append("<td align='left' width='400'>运行状态</td>");
				sb.append("</tr>");
				for (DispatchModel record : list) {
					sb.append("<tr>");
					sb.append("<td>" + etlDate + "</td>");
					sb.append("<td>"
							+ (record.getStartTime() != null ? record
									.getStartTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getEndTime() != null ? record
									.getEndTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getStatus().equals("0") ? "成功" : "失败")
							+ "</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				result = sb.toString();
			} else {
				result = "<font color='red'>没有相关信息...</font>";
			}
		} catch (Exception e) {
			result = "<font color='red'>出错了，请重试...</font>";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取批量调度状态
	 * 
	 * @param etlDate
	 * @return
	 */
	@RemoteMethod
	public String getDispatchStatus(String etlDate) {
		String result = "";
		try {
			List<DispatchModel> list = monitorService
					.getDispatchStatus(etlDate);
			if (list.size() > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td align='left' width='100'>ETL时间</td>");
				sb.append("<td align='left' width='200'>开始时间</td>");
				sb.append("<td align='left' width='200'>结束时间</td>");
				sb.append("<td align='left' width='400'>当前状态</td>");
				sb.append("</tr>");
				for (DispatchModel record : list) {
					sb.append("<tr>");
					sb.append("<td>" + etlDate + "</td>");
					sb.append("<td>"
							+ (record.getStartTime() != null ? record
									.getStartTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getEndTime() != null ? record
									.getEndTime() : "") + "</td>");
					sb.append("<td>"
							+ (record.getStatus().equals("0") ? "成功" : "失败")
							+ "</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				result = sb.toString();
			} else {
				result = "<font color='red'>没有相关信息...</font>";
			}
		} catch (Exception e) {
			result = "<font color='red'>出错了，请重试...</font>";
			e.printStackTrace();
		}
		return result;
	}
}
