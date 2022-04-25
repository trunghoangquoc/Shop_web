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

		FeedBackEntity feedBackentity = new FeedBackEntity();
		UserEntity userEntity = new UserEntity();
		if( !dto.getAddress().isEmpty() && !dto.getEmail().isEmpty() && dto.getNumberPhone() != null) {
			feedBackentity = feedbackConverter.toEntity(dto);
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!object.equals("anonymousUser")) {
				MyUser myUser = (MyUser) object;
//				MyUser myUser = securityUtil.getPrincipal();
				if (myUser.getUsername() != null) {
					userEntity = userRepository.findByUserName(myUser.getUsername());
					
					feedBackentity.setUser(userEntity);
				} 
			}		
			return feedbackConverter.toDto(feedbackRepository.save(feedBackentity));
		}else {
			return null;
		}
		

	}
}
