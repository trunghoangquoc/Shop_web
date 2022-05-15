package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavawebshop.constant.SystemConstant;
import com.laptrinhjavawebshop.converter.UserConverter;
import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.entity.CartEntity;
import com.laptrinhjavawebshop.entity.RoleEntity;
import com.laptrinhjavawebshop.entity.UserEntity;
import com.laptrinhjavawebshop.repository.CartRepository;
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
	private CartRepository cartRepository;
	
	@Autowired
	private SystemConstant constant;

	@Override
	@Transactional
	public UserDTO registerUser(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		UserDTO userDTO = new UserDTO();
        CartEntity cartEntity = new CartEntity();
		if ((!dto.getEmail().isEmpty()) && (!dto.getUserName().isEmpty()) && (!dto.getPassWord().isEmpty())) {
			UserEntity user = userRepository.findByUserName(dto.getUserName());
			UserEntity user1 = userRepository.findByEmail(dto.getEmail());
			if (user == null && user1 == null) {
				userEntity = userConverter.toEntity(dto);
				List<RoleEntity> roles = new ArrayList<>();
				roles.add(roleRepository.findOneByCode("USER"));
				userEntity.setRoles(roles);
				userEntity.setStatus(1);
				userDTO = userConverter.toDto(userRepository.save(userEntity));
				cartEntity.setUserCart(userEntity);
				cartEntity.setUserNameOfCart(userEntity.getUserName());
				cartRepository.save(cartEntity);
				return userDTO;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
 
	// = ( findAll Status =1 + findAll Status = 0 )
	@Override
	public Page<UserEntity> findByStatus(Integer status, Pageable page) {
		
		return userRepository.findByStatus(status, page);
	}

	@Override
	public int getTotalItem() {

		return (int) userRepository.count();
	}

	// findAll danh sach status = 1
//	@Override
//	public List<UserDTO> findAllActive(Pageable page) {
//		List<UserDTO> userDto = new ArrayList<UserDTO>();
//		List<UserEntity> userEntity = userRepository.findAll(page).getContent();
//		for (UserEntity item : userEntity) {
//			if (item.getStatus() == SystemConstant.ACTIVE_STATUS) {
//				UserDTO dto = userConverter.toDto(item);
//				userDto.add(dto);
//			}
//		}
//		return userDto;
//	}
//
//	// findAll danh sách status = 0 (đã delete)
//	@Override
//	public List<UserDTO> findAllDelete(Pageable page) {
//		List<UserDTO> userDto = new ArrayList<UserDTO>();
//		List<UserEntity> userEntity = userRepository.findAll(page).getContent();
//
//		for (UserEntity item : userEntity) {
//			if (item.getStatus() == SystemConstant.INACTIVE_STATUS) {
//				UserDTO dto = userConverter.toDto(item);
//				userDto.add(dto);
//			}
//
//		}
//		return userDto;
//	}

	@Override
	public UserDTO findById(long id) {
		Optional<UserEntity> entity = userRepository.findById(id);
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.entityToEntity(entity);
		userEntity.setRoles(entity.get().getRoles());

		return userConverter.toDto(userEntity);
	}

	// instes + update
	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		Optional<UserEntity> oldUserEntity;
		CartEntity cartEntity = new CartEntity();
//		userEntity = userConverter.toEntity(dto);
		if (dto.getId() != null) {
			oldUserEntity = userRepository.findById(dto.getId());
			userEntity = userConverter.entityToEntity(oldUserEntity);
			userEntity.setFullName(dto.getFullName());
			userEntity.setStatus(dto.getStatus());
			userEntity.setUserName(dto.getUserName());
			userEntity.setEmail(dto.getEmail());
			userEntity.setAddress(dto.getAddress());
			userEntity.setPhoneNumber(dto.getPhoneNumber());
		}else {
			userEntity = userConverter.toEntity(dto);
		}
		
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(roleRepository.findOneByCode(dto.getRoleCode()));
		userEntity.setRoles(roles);
		//Tạo cart
		cartEntity.setUserCart(userEntity);
		cartEntity.setUserNameOfCart(userEntity.getUserName());
		cartRepository.save(cartEntity);
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void deleteUserActive(long[] ids) {

		Optional<UserEntity> user;
		UserEntity userEntity = new UserEntity();
		for (long id : ids) {
			user = userRepository.findById(id);
			userEntity = userConverter.entityToEntity(user);
			userEntity.setStatus(0);

			userRepository.save(userEntity);
		}
	}

	@Override
	@Transactional
	public void deleteUserNoActive(long[] ids) {

		for (long id : ids) {
			userRepository.deleteById(id);
		}
	}

	
}
