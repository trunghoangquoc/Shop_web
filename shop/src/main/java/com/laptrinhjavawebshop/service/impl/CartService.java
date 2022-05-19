package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavawebshop.constant.SystemConstant;
import com.laptrinhjavawebshop.converter.CartConverter;
import com.laptrinhjavawebshop.converter.ProductConverter;
import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.dto.MyUser;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.CartEntity;
import com.laptrinhjavawebshop.entity.ProductEntity;
import com.laptrinhjavawebshop.repository.CartDetailsRepository;
import com.laptrinhjavawebshop.repository.CartRepository;
import com.laptrinhjavawebshop.repository.ProductRepository;
import com.laptrinhjavawebshop.service.ICartService;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartDetailsRepository cartDetailsRepository;

	@Autowired
	private ProductRepository productRepository;
    
	@Autowired
	private ProductConverter productConvert;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private SystemConstant constant;
	
	@Override
	public CartDTO addCart(long id) {
        
			CartDetailsEntity cartDetailsEntity = new CartDetailsEntity();
			Optional<ProductEntity> productEntity ;
			ProductEntity product = new ProductEntity();
			CartEntity cartEntity = new CartEntity();
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (!object.equals("anonymousUser")) {
				MyUser myUser = (MyUser) object;
//				MyUser myUser = securityUtil.getPrincipal();
				if (myUser.getUsername() != null) {

					productEntity =  productRepository.findById(id);
					product = productConvert.toEntity(productEntity);
					if(productEntity.get().getTotalNumber() > 0) {
						cartDetailsEntity.setUserNameOfCart(myUser.getUsername());
						cartDetailsEntity.setCodeImg(productEntity.get().getCodeImg());
						cartDetailsEntity.setNameProduct(productEntity.get().getName());
						cartDetailsEntity.setPrice(productEntity.get().getPrice());
						
						CartDetailsEntity item = new CartDetailsEntity();
						item = cartDetailsRepository.findByProductIdAndUserNameOfCart(product.getId(), myUser.getUsername());
						if(item != null) {
							cartDetailsEntity.setQuantity((long) item.getQuantity() + 1);
							cartDetailsEntity.setId(item.getId());
							cartDetailsEntity.setProduct(product);
							cartDetailsEntity.setCreatedBy(item.getCreatedBy());
							cartDetailsEntity.setCreatedDate(item.getCreatedDate());
						}else {
							cartDetailsEntity.setQuantity((long) 1);
							//set product_id
							cartDetailsEntity.setProduct(product);
						}
						
						//set cart_id
						cartDetailsEntity.setStatus(1);
						cartEntity = cartRepository.findByUserNameOfCart(myUser.getUsername());
						cartDetailsEntity.setCart(cartEntity);
						cartDetailsRepository.save(cartDetailsEntity);
					}
				
				}
				return cartConverter.toDto(cartDetailsEntity);
			}else {
				return null;
			}
	}
	
//find theo status = 0 đổ vào trang order

	@Override
	public List<CartDetailsEntity> findByStatusAndUserNameOfCart() {
		List<CartDetailsEntity> cartDetailsEntity = new ArrayList<CartDetailsEntity>();
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!object.equals("anonymousUser")) {
			MyUser myUser = (MyUser) object;
			cartDetailsEntity = cartDetailsRepository.findByStatusAndUserNameOfCart(SystemConstant.INACTIVE_STATUS, myUser.getUsername());
		}
		return cartDetailsEntity;
	}


	@Override
	public List<CartDTO> findAll() {
		List<CartDTO> cartDto = new ArrayList<CartDTO>();
		List<CartDetailsEntity> cartDetailsEntity = new ArrayList<CartDetailsEntity>();
		
		cartDetailsEntity = cartDetailsRepository.findAll();
		for (CartDetailsEntity item : cartDetailsEntity) {
			CartDTO dto = new CartDTO();
			dto = cartConverter.toDto(item);
			cartDto.add(dto);
		}
		return cartDto;
	}

    //phan trang theo name
	@Override
	public Page<CartDetailsEntity> findByNameOfCart(String userNameOfCart, Pageable page) {
		return cartDetailsRepository.findByUserNameOfCart(userNameOfCart, page) ;
	}


	@Override
	public int getTotalItem() {
		return (int) cartDetailsRepository.count();

	}


	@Override
	public Boolean deleteProductOfCart(long[] ids) {
		for (long id : ids) {
			cartDetailsRepository.deleteById(id);
		}
		return true;
	}

	@Override
	@Transactional
	public List<CartDTO> updateStatusCart(List<CartDTO> cartDto) {
		List<CartDTO> listCart = new ArrayList<CartDTO>();
		CartDetailsEntity cartDetailsEntity = new CartDetailsEntity();
		Optional<CartDetailsEntity> cartDetaiOptional ;
		for (CartDTO item : cartDto) {
			cartDetaiOptional = cartDetailsRepository.findById(item.getId());
			cartDetailsEntity = cartConverter.toEntity(cartDetaiOptional);
			cartDetailsEntity.setQuantity(item.getQuantity());
			cartDetailsEntity.setStatus(0);
			cartDetailsRepository.save(cartDetailsEntity);
			listCart.add(cartConverter.toDto(cartDetailsEntity));
		}
		if(listCart !=null)
			return listCart;
		else {
			return null;
		}
		
	}

	
}
