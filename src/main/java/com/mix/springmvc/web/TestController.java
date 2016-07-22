package com.mix.springmvc.web;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mix.springmvc.domain.PhoneNumberModel;
import com.mix.springmvc.domain.TUser;
import com.mix.springmvc.domain.User;

@Controller
public class TestController {
	@ModelAttribute("cityList")
	public List<String> cityList(){
		return Arrays.asList("Beijing","Shandong");
	}
	
	@RequestMapping(value="/test1")
	public String helloWorld(Model model){
		model.addAttribute("name", "tangyinbo");
		return "test";
	}
	
	@RequestMapping("/test2")
	public String test2(Model model){
		 return "index";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(params="create",value="pathv/{userName}")
	public String pathVariable(@PathVariable(value="userName")String userName ,Model model){
		model.addAttribute("testType", "pathVariable:"+userName);
		return "test";
	}
	
	@RequestMapping(value="/login")
	public String login(User user,Model model,TUser tuser,HttpServletRequest request){
		model.addAttribute("testType", "login:"+user.getName());
		CsrfToken ts = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("tt", "attributeValue==============");
		ts = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		System.out.println("------------------------------------");
		return "login";
	}
	
	@RequestMapping(value="/requestParameter")
	public String requestParameter(@RequestParam("username") String username,Model model){
		model.addAttribute("testType", "requestParameter:"+username);
		return "test";
	}
	
	@RequestMapping("/testConvert")
	public String testConvert( PhoneNumberModel m,Model model){
		model.addAttribute("testType", "testConvert:"+m.getAreaCode()+"-"+m.getPhoneNumber());
		System.out.println("-----testConvert----");
		return "test";
	}
}
