package com.fundraising.admin.controller.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fundraising.util.common.CommonConstant;

public class AdminIntereptor extends HandlerInterceptorAdapter {

	private List<String> ignoreUrls = null;

	{
		ignoreUrls = Arrays.asList("logIn.html", "logOut.html");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if (!isIgnoreUrl(uri)) {
			if (request.getSession().getAttribute(CommonConstant.LOGIN_USER_SESSION_KEY) == null) {
				response.sendRedirect("logIn.html");
				return false;
			}
		}
		return true;
	}

	public boolean isIgnoreUrl(String uri) {
		for (String ignoreUrl : ignoreUrls) {
			if (uri.endsWith(ignoreUrl)) {
				return true;
			}
		}
		return false;
	}

}
