package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email", "src8655@naver.com");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(
			Model model) {
		model.addAttribute("email", "dooly@naver.com");
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello4")
	public String hello4(
			Model model,
			@RequestParam(value="email", required=false) String email,
			@RequestParam String name	//어노테이션의 값 생략 시
			) {
		System.out.println(name);
		model.addAttribute("email", email);
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	//Servlet기술 침투
	@RequestMapping("/hello5")
	public String hello5(
			Model model,
			HttpServletRequest request
			) {
		System.out.println(request.getParameter("name"));
		model.addAttribute("email", request.getParameter("email"));
		
		return "/WEB-INF/views/hello.jsp";
	}
}
