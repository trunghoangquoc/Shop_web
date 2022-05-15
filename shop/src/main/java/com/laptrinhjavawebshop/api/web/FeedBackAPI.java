package com.laptrinhjavawebshop.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.service.IFeedBackService;

@RestController(value = "newApiOfWeb1")
public class FeedBackAPI {
	
		@Autowired
		private IFeedBackService feedBackService;
			
		@DeleteMapping("/api/feedBack")
		public void deleteUserActive(@RequestBody long[] ids) {
			feedBackService.deleteFeedBack(ids);
			
		}
}
