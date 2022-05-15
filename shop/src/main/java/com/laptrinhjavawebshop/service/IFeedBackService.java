package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.FeedBackDTO;


public interface IFeedBackService {
   FeedBackDTO save (FeedBackDTO dto);
   void deleteFeedBack(long[] ids);
   
   List<FeedBackDTO> findAll(Pageable page);
   int getTotalItem();
}
