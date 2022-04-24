package com.laptrinhjavawebshop.controller.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.util.MessageUtil;
import com.laptrinhjavawebshop.util.SecurityUtils;

@Controller(value ="homeControllerOfWeb")
public class HomeController {

	@Autowired
	private MessageUtil messageUtil;
	
    @RequestMapping(value = {"/trang-chu"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("web/home");
        return mav;
    }

    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public ModelAndView homeProduct() {
        ModelAndView mav = new ModelAndView("web/contact");
        return mav;
    }

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
	}

    @RequestMapping(value = "/dang-ky" , method = RequestMethod.GET)
	public ModelAndView registerAccount(@RequestParam(value = "message" ,required = false) String message, HttpServletRequest request) {
		 ModelAndView mav = new ModelAndView("web/sign-up");
		 

//			if (request.getParameter("message") != null) {
//				Map<String, String> message_alert = messageUtil.getMessage(request.getParameter("message"));
//				mav.addObject("message", message_alert.get("message"));
//				mav.addObject("alert", message_alert.get("alert"));
//			}
			return mav;
	}

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
    
    //CustomSuccessHandler
	@RequestMapping(value = "/customSuccessHandler", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()") // true nếu ng dùng đã đăng nhập
	public ModelAndView customSuccessHandler(Authentication authentication) {
    	
    		ModelAndView mav = null;
    		//SecurityUtils.getAuthorities() get cái code để phân quyền
    		List<String> roles = SecurityUtils.getAuthorities();
    		if (isAdmin(roles)) {
    			mav = new ModelAndView("/admin/home");
    		} 
//    		else if (isAdmin1(roles)) {
//    			
//    		}
    		else if (isUser(roles)) {
    			mav = new ModelAndView("/web/home");
    		}
    		return mav;
    	}
    	
    	private boolean isAdmin(List<String> roles) {
    		if (roles.contains("ADMIN")) {
    			return true;
    		}
    		return false;
    	}
//    	private boolean isAdmin1(List<String> roles) {
//    		if (roles.contains("ADMIN1")) {
//    			return true;
//    		}
//    		return false;
//    	}
    	private boolean isUser(List<String> roles) {
    		if (roles.contains("USER")) {
    			return true;
    		}
    		return false;
    	}	

		// logout
		@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
		public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return new ModelAndView("redirect:/trang-chu");
		}

}
