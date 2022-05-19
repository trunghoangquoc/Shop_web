package com.laptrinhjavawebshop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="AccountControllerOfWeb")
public class AccountController {
   

    @RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("web/inforPersonal");
		return mav;
	}
	
}
