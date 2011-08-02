package com.test.service;

import java.util.List;

import com.test.model.DispatchModel;
import com.test.model.ErrLogRecord;
import com.test.model.User;

public interface IMonitorService {

	List<ErrLogRecord> getErrLogRecord(String etlDate);

	List<DispatchModel> getDispatchItem(String etlDate);

	List<DispatchModel> getDispatchStatus(String etlDate);

	String login(User user);
}
