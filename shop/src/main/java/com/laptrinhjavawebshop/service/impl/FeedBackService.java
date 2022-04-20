package com.laptrinhjavawebshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.laptrinhjavawebshop.converter.FeedBackConverter;
import com.laptrinhjavawebshop.dto.FeedBackDTO;
import com.laptrinhjavawebshop.dto.MyUser;
import com.laptrinhjavawebshop.entity.FeedBackEntity;
import com.laptrinhjavawebshop.entity.UserEntity;
import com.laptrinhjavawebshop.repository.FeedBackRepository;
import com.laptrinhjavawebshop.repository.UserRepository;
import com.laptrinhjavawebshop.service.IFeedBackService;
import com.laptrinhjavawebshop.util.SecurityUtils;

@Service
public class FeedBackService implements IFeedBackService {

	@Autowired
	private FeedBackRepository feedbackRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FeedBackConverter feedbackConverter;
	
	@Autowired
	private SecurityUtils securityUtil;
	
	@Override
	public FeedBackDTO save(FeedBackDTO dto) {
		FeedBackEntity entity = new FeedBackEntity();
		UserEntity user = new UserEntity();
		entity = feedbackConverter.toEntity(dto);

		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		if(myUser.getUsername() != null) {
			user = userRepository.findOneByUserName(myUser.getUsername());
			entity.setUser(user);//chính là set Field user_id dưới DB
		}else {
			entity.setUser(null);
		}
	
		return feedbackConverter.toDto(feedbackRepository.save(entity));
	}

}