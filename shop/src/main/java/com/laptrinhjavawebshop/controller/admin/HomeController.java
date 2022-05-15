package com.laptrinhjavawebshop.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="homeControllerOfAdmin")

public class HomeController {
	@PreAuthorize("hasAuthority('ADMIN')")
	
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("/admin/home");
        return mav;
    }

}
