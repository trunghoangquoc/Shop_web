package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavawebshop.constant.SystemConstant;
import com.laptrinhjavawebshop.converter.UserConverter;
import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.entity.RoleEntity;
import com.laptrinhjavawebshop.entity.UserEntity;
import com.laptrinhjavawebshop.repository.RoleRepository;
import com.laptrinhjavawebshop.repository.UserRepository;
import com.laptrinhjavawebshop.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private SystemConstant constant;

	@Override
	@Transactional
	public UserDTO registerUser(UserDTO userDto) {
		List<UserEntity> user = userRepository.findByUserName(userDto.getUserName());
		UserEntity userEntity = new UserEntity();
		UserDTO userDTO = new UserDTO();
		if(user.isEmpty()){
			userEntity = userConverter.toEntity(userDto);
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOneByCode("USER"));
			userEntity.setRoles(roles);
			userEntity.setStatus(1);
			userDTO = userConverter.toDto(userRepository.save(userEntity));
		}
		return userDTO;
	}

	@Override
	public int getTotalItem() {
		
		return (int)userRepository.count() ;
	}

	@Override
	public List<UserDTO> findAllActive(Pageable page) {
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		List<UserEntity> userEntity = userRepository.findAll(page).getContent();
	   
		for (UserEntity item : userEntity) {
			if(item.getStatus() == SystemConstant.ACTIVE_STATUS ) {
				UserDTO dto = userConverter.toDto(item);
		    	userDto.add(dto);
			}
	    	
		}
		return userDto;
	}

	@Override
	public UserDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		
		return null;
	}
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
