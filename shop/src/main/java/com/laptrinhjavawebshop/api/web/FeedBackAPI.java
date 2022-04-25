package com.laptrinhjavawebshop.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.FeedBackDTO;
import com.laptrinhjavawebshop.service.IFeedBackService;

@RestController(value = "newApiOfWeb1")
public class FeedBackAPI {
	
		@Autowired
		private IFeedBackService feedBackService;
		
		@PostMapping ("/api/feedBack")
			public FeedBackDTO createFeedBack (@RequestBody FeedBackDTO userDTO) {
			return feedBackService.save(userDTO);
		}
}
