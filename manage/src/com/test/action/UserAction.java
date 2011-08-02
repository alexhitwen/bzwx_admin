package com.test.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.model.User;
import com.test.service.IMonitorService;

/**
 * com.nccd.report.odsmonitor.action.UserAction
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-28
 */
@ParentPackage("tiles-default")
@Namespace("/user")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private User user;
	@Autowired
	private IMonitorService monitorService;

	private Logger logger = Logger.getLogger(getClass());

	@Action(value = "login", results = {
			@Result(name = "success", type = "tiles", location = "index"),
			@Result(name = "input", location = "/user/login.jsp"),
			@Result(name = "error", type = "tiles", location = "error") })
	public String login() {
		String result = "input";
		try {
			String loginFlag = monitorService.login(user);
			if (loginFlag.equals("Y") || loginFlag.equals("N")) {
				result = "success";
				ActionContext.getContext().getSession().put("loginUser", user);
			} else if (loginFlag.equals("0")) {
				user.setMessage("您输入的用户名或者密码有误！");
			} else if (loginFlag.equals("-1")) {
				user.setMessage("出错了，请稍后再试！");
			}
		} catch (Exception e) {
			user.setMessage("出错了，请稍后再试！");
			e.printStackTrace();
		}
		return result;
	}

	@Action(value = "exit", results = { @Result(name = "input", location = "/user/login.jsp") })
	public String exit() {
		try {
			ActionContext.getContext().getSession().remove("loginUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "input";
	}

	@Override
	public User getModel() {
		return user;
	}

}
