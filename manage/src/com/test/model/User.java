package com.test.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * com.nccd.report.odsmonitor.model.User
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-29
 */
@Repository
@Scope("prototype")
public class User implements Serializable {
	private static final long serialVersionUID = -702563468009396666L;
	private String userid;
	private String username;
	private String passwd;
	private String message;

	public User() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
