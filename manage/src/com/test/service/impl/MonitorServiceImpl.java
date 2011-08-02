package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.IMonitorDao;
import com.test.model.DispatchModel;
import com.test.model.ErrLogRecord;
import com.test.model.User;
import com.test.service.IMonitorService;

@Service
public class MonitorServiceImpl implements IMonitorService {
	@Autowired
	private IMonitorDao monitorDao;

	@Override
	public List<ErrLogRecord> getErrLogRecord(String etlDate) {
		return monitorDao.getErrLogRecord(etlDate);
	}

	@Override
	public List<DispatchModel> getDispatchItem(String etlDate) {
		return monitorDao.getDispatchItem(etlDate);
	}

	@Override
	public List<DispatchModel> getDispatchStatus(String etlDate) {
		return monitorDao.getDispatchStatus(etlDate);
	}

	@Override
	public String login(User user) {
		return monitorDao.login(user);
	}

}
