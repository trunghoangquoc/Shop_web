package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.entity.UserEntity;

public interface IUserService {
   UserDTO save (UserDTO dto);
   UserDTO registerUser (UserDTO userDto);
   int getTotalItem();
   
   Page<UserEntity> findByStatus(Integer status , Pageable page);
//   List<UserDTO> findAllActive(Pageable page);
//   List<UserDTO> findAllDelete(Pageable page);
   UserDTO findById(long id);
   void deleteUserActive(long[] ids);
   void deleteUserNoActive(long[] ids);
   
}
