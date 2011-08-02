package com.test.dao;

import java.util.List;

import com.test.model.DispatchModel;
import com.test.model.ErrLogRecord;
import com.test.model.User;

/**
 * com.nccd.report.odsmonitor.dao.IMonitorDao
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-29
 */
public interface IMonitorDao {

	List<ErrLogRecord> getErrLogRecord(String etlDate);

	List<DispatchModel> getDispatchItem(String etlDate);

	List<DispatchModel> getDispatchStatus(String etlDate);

	String login(User user);
}
