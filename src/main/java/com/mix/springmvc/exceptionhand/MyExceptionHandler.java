package com.mix.springmvc.exceptionhand;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		Map<String,Object> errorModel = new HashMap<String,Object>();
		if(ex instanceof ArithmeticException){
			errorModel.put("errorMsg", "ex instanceof ArithmeticException:"+ex.getMessage());
			return new ModelAndView("error", errorModel);
		}
		return null;
	}

}
