package com.spring_mvc.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	// index 에서 로그인 메뉴 선택하면(/loginForm) 요청 처리 메소드
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ajax/loginForm";
	}
	
	@RequestMapping("/loginForm2")
	public String loginForm2() {
		return "ajax/loginForm2";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("id") String id , 
							 @RequestParam("pw") String pw) {
		String result="";
		if(id.equals("abcd") && pw.equals("1234")) {
			result = "sucess";
		}else {
			result = "fail";
		}
		return result;
	}
}
