package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public FeedBackDTO save(FeedBackDTO dto) {

		FeedBackEntity feedBackentity = new FeedBackEntity();
		UserEntity userEntity = new UserEntity();
		if( !dto.getAddress().isEmpty() && !dto.getEmail().isEmpty() &&  !dto.getNumberPhone().isEmpty()) {
			feedBackentity = feedbackConverter.toEntity(dto);
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!object.equals("anonymousUser")) {
				MyUser myUser = (MyUser) object;
				
//				MyUser myUser1 = securityUtil.getPrincipal().getUsername();
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
	
	@Override
	public List<FeedBackDTO> findAll(Pageable page) {
		List<FeedBackDTO> feedbackDTO = new ArrayList<FeedBackDTO>();
		List<FeedBackEntity> feedbackEntity = feedbackRepository.findAll(page).getContent();
		for (FeedBackEntity item : feedbackEntity) {
			FeedBackDTO result = new FeedBackDTO();
			result = feedbackConverter.toDto(item);
			feedbackDTO.add(result);
		}
		return feedbackDTO;

	}
	
	@Override
	public int getTotalItem() {
		return (int) feedbackRepository.count();
	}
	
	@Override
	@Transactional
	public void deleteFeedBack(long[] ids) {
		for (long id : ids) {
			feedbackRepository.deleteById(id);
		}
	}

	
	
}
