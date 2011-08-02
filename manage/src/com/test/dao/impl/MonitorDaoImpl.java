package com.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.IMonitorDao;
import com.test.model.DispatchModel;
import com.test.model.ErrLogRecord;
import com.test.model.User;

/**
 * com.nccd.report.odsmonitor.dao.impl.MonitorDaoImpl
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-29
 */
@Repository
public class MonitorDaoImpl extends SqlSessionDaoSupport implements IMonitorDao {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	public void setSqlSessionFactory0(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<ErrLogRecord> getErrLogRecord(String etlDate) {
		return getSqlSessionTemplate().selectList("getErrLogRecordByEtlDate",
				etlDate);
	}

	@Override
	public List<DispatchModel> getDispatchItem(String etlDate) {
		return getSqlSessionTemplate().selectList("getDispatchItemByEtlDate",
				etlDate);
	}

	@Override
	public List<DispatchModel> getDispatchStatus(String etlDate) {
		return getSqlSessionTemplate().selectList("getDispatchStatusByEtlDate",
				etlDate);
	}

	@Override
	public String login(User user) {
		// org.apache.ibatis.type.JdbcType.CURSOR
		Map<String, String> map = new HashMap<String, String>();
		map.put("i_username", user.getUsername());
		map.put("i_passwd", user.getPasswd());
		map.put("o_logflag", "");
		getSqlSessionTemplate().selectOne("loginPro", map);
		return (String) map.get("o_logflag");
	}

}
