package com.bstar.mportal.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bstar.mportal.service.CategoryService;
import com.bstar.mportal.service.ChannelService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@Controller
public abstract class BaseAction extends ActionSupport implements ServletRequestAware, SessionAware, ParameterAware, Preparable, ServletContextAware {
	
	private static final long serialVersionUID = -3923356405216264264L;
	
	protected HttpServletRequest request;
	protected Map<String, Object> session;
	protected Map<String, String[]> params;
	protected ServletContext servletContext;

	@Autowired
	protected CategoryService categoryService;

	@Autowired
	public ChannelService channelService;


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void prepare() throws Exception {
	}
	
	public void setParameters(Map<String, String[]> parameters) {
		this.params = parameters;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}
}
