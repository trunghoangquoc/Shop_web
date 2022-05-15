package com.laptrinhjavawebshop.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.dto.FeedBackDTO;
import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.service.IFeedBackService;
import com.laptrinhjavawebshop.util.MessageUtil;

@Controller(value ="FeedbackControllerOfAdmin")
@PreAuthorize("hasAuthority('ADMIN_FEEDBACK')")
public class FeedBackController {

	@Autowired
	private IFeedBackService feedBackService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/admin/feedback/list", method = RequestMethod.GET)
	public ModelAndView FeedbackList(@RequestParam(value = "page" ,required = false) int page,
                                    @RequestParam(value ="limit" ,required = false) int limit,
                                    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("admin/feedback/feedbackList");
		FeedBackDTO model = new FeedBackDTO();
		model.setPage(page);
		model.setLimit(limit);
		
		//xử lý offset và limit
		
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);
		
		model.setListResult(feedBackService.findAll(pageable));
		model.setTotalItem(feedBackService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
		
	}
}
