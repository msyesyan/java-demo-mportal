package com.bStar.mportal.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import com.opensymphony.xwork2.config.ConfigurationManager;

public class Restful2ActionMapper extends DefaultActionMapper {

	protected static final Log LOG = LogFactory
			.getLog(Restful2ActionMapper.class);
	public static final String HTTP_METHOD_PARAM = "__http_method";
	private static final byte HTTP_METHOD_GET = 1;
	private static final byte HTTP_METHOD_POST = 2;
	private static final byte HTTP_METHOD_PUT = 3;
	private static final byte HTTP_METHOD_DELETE = 4;

	public Restful2ActionMapper() {
		setSlashesInActionNames("true");
	}

	public ActionMapping getMapping(HttpServletRequest request,
			ConfigurationManager configManager) {

		if (!isSlashesInActionNames()) {
			throw new IllegalStateException(
					"This action mapper requires the setting 'slashesInActionNames' to be set to 'true'");
		}
		ActionMapping mapping = super.getMapping(request, configManager);

		if (mapping == null)
			return null;

		String actionName = mapping.getName();
		if ((actionName == null) || (actionName.length() == 0))
			return mapping;

		// If a method hasn't been explicitly named, try to guess using
		// ReST-style patterns
		if (mapping.getMethod() != null)
			return mapping;

		int lastSlashPos = actionName.lastIndexOf('/');
		if (lastSlashPos == -1)
			return mapping;
		String requestMethod = request.getMethod();
		String httpMethodParam = request.getParameter(HTTP_METHOD_PARAM);
		byte requestMethodCode = 0;
		if ("PUT".equalsIgnoreCase(requestMethod))
			requestMethodCode = HTTP_METHOD_PUT;
		else if ("DELETE".equalsIgnoreCase(requestMethod))
			requestMethodCode = HTTP_METHOD_DELETE;
		else if ("PUT".equalsIgnoreCase(httpMethodParam))
			requestMethodCode = HTTP_METHOD_PUT;
		else if ("DELETE".equalsIgnoreCase(httpMethodParam))
			requestMethodCode = HTTP_METHOD_DELETE;
		else if ("GET".equalsIgnoreCase(requestMethod))
			requestMethodCode = HTTP_METHOD_GET;
		else if ("POST".equalsIgnoreCase(requestMethod))
			requestMethodCode = HTTP_METHOD_POST;

		if (requestMethodCode == HTTP_METHOD_GET) {
			if (lastSlashPos == actionName.length() - 1)
				mapping.setMethod("index");
			else
				mapping.setMethod("view");
		} else if (requestMethodCode == HTTP_METHOD_POST)
			mapping.setMethod("create");
		else if (requestMethodCode == HTTP_METHOD_PUT)
			mapping.setMethod("update");
		else if (requestMethodCode == HTTP_METHOD_DELETE)
			mapping.setMethod("remove");

		return mapping;
	}
}
