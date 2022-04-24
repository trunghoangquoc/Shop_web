package com.laptrinhjavawebshop.service.impl;

import java.util.Optional;

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

		FeedBackEntity feedBackentity = new FeedBackEntity();
		Optional<UserEntity> userEntity ;
		feedBackentity = feedbackConverter.toEntity(dto);
		UserEntity user = new UserEntity();
//		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		MyUser myUser = securityUtil.getPrincipal();
		if (myUser.getId_user() != null) {
			userEntity = userRepository.findById(myUser.getId_user());
			user.setUserName(userEntity.get().getUserName());
			user.setId(userEntity.get().getId());
			feedBackentity.setUser(user);
		} 

		return feedbackConverter.toDto(feedbackRepository.save(feedBackentity));

	}
}
