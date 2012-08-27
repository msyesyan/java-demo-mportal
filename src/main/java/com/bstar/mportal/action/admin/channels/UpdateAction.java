package com.bstar.mportal.action.admin.channels;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.bind.ServletRequestUtils;

import com.bstar.mportal.model.Category;

@Action
@Result(type="redirect", location="/admin/channels/")
public class UpdateAction extends EditAction {
	
	private static final long serialVersionUID = -8660545498730864291L;
	
	public String execute() throws Exception {
		int[] categoryIds = ServletRequestUtils.getIntParameters(request, "categoryIds");
		List<Category> categories = categoryService.findByIds(categoryIds);
		channel.setCategories(categories);
		channelService.update(channel);
		channelService.upload(logo, servletContext, channel, logoFileName);
		return "success";
	}
}
