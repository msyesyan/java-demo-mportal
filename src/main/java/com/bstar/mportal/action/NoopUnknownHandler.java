package com.bstar.mportal.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.UnknownHandler;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class NoopUnknownHandler implements UnknownHandler {

	public ActionConfig handleUnknownAction(String namespace, String actionName) {
		return null;
	}

	public Result handleUnknownResult(ActionContext actionContext, String actionName, ActionConfig actionConfig, String resultCode) {
		return null;
	}

	public Object handleUnknownActionMethod(Object action, String methodName) {
		return null;
	}

}
