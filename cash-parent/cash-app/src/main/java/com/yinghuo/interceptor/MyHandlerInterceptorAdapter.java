package com.yinghuo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

public class MyHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	/**
	 * 可以根据ex是否为null判断是否发生了异常，进行日志记录.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("结果1:"+response.getOutputStream().toString());
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * bean处理后，有机会修改ModelAndView.
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("结果2:"+response.getOutputStream().toString());
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * bean处理前，可以进行编码、安全控制等处理.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

}
