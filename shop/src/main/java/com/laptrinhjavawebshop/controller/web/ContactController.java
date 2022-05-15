package com.laptrinhjavawebshop.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.dto.FeedBackDTO;
import com.laptrinhjavawebshop.service.IFeedBackService;
import com.laptrinhjavawebshop.util.FeedBackValidator;
import com.laptrinhjavawebshop.util.MessageUtil;

@Controller(value = "contactControllerOfWeb")
public class ContactController {

	@Autowired
	private IFeedBackService feedBackService;
	
	@Autowired
	private FeedBackValidator feedBackValidator;
	
	@Autowired
	private MessageUtil messageUtil;
	
	 @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
	    public ModelAndView createContact(@RequestParam(value = "message" ,required = false) String message, HttpServletRequest request) {
	        ModelAndView mav = new ModelAndView("web/contact");
	        
	        mav.addObject("model", new FeedBackDTO());
	        if (request.getParameter("message") != null) {
				Map<String, String> message_alert = messageUtil.getMessage(request.getParameter("message"));
				mav.addObject("message", message_alert.get("message"));
				mav.addObject("alert", message_alert.get("alert"));
			}
			return mav;
	        
	    }
	
	@PostMapping("/contact")
	public ModelAndView valiContact(@ModelAttribute("model") @Valid FeedBackDTO feedBackDto, BindingResult bindingResult) {
	    
		feedBackValidator.validate(feedBackDto, bindingResult);
	
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/contact");
        }else {
        	if( feedBackService.save(feedBackDto) != null) {
        		  return new ModelAndView("redirect:/contact?message=feedback_success");
        	}
        	 
        	  return new ModelAndView("redirect:/contact?message=inaccurate_information");
        }

	}
}
