package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.UserDTO;

public interface IUserService {
   UserDTO save (UserDTO dto);
   UserDTO registerUser (UserDTO userDto);
   int getTotalItem();
   List<UserDTO> findAllActive(Pageable page);
   List<UserDTO> findAllDelete(Pageable page);
   UserDTO findById(long id);
   void deleteUserActive(long[] ids);
   void deleteUserNoActive(long[] ids);
}
