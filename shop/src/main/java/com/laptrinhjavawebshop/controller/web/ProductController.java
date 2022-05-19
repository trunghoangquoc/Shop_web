package com.laptrinhjavawebshop.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.converter.ProductConverter;
import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.entity.ProductEntity;
import com.laptrinhjavawebshop.service.IProductService;

@Controller(value = "ProductControllerOfWeb")
public class ProductController {
	
	@Autowired
	private IProductService productService;
   
	@Autowired
	private ProductConverter productConverter;
	
	@RequestMapping(value = "/productDetails" , method = RequestMethod.GET)
	public ModelAndView productEdit (@RequestParam (value = "id" ,required = false) Long id , HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/productDetails");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
		}
		mav.addObject("model", model);
		
		return mav;
	}
	
	//find List product
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView productList(
			@RequestParam(value = "page" ,required = false) Integer page,
            @RequestParam(value ="limit" ,required = false) Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("web/product");

		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
	   //xử lý offset và limit
		
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);
		
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
		
	}
	//find category rau cu
	@RequestMapping(value = "/productCategory1", method = RequestMethod.GET)
	public ModelAndView productCategory1(
			@RequestParam(value = "category" ,required = false) String category,
			@RequestParam(value = "page" ,required = false) Integer page,
            @RequestParam(value ="limit" ,required = false) Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("web/productCategory/RauCu");
		List<ProductDTO> listProductDto = new ArrayList<ProductDTO>();
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
	   //xử lý offset và limit
		
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);
		
		Page<ProductEntity> resultPage = productService.findByCategoryCode(category, pageable);
		for (ProductEntity item : resultPage) {
			ProductDTO dto = new ProductDTO();
			dto = productConverter.toDto(item);
			listProductDto.add(dto);
		}
		model.setListResult(listProductDto);
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	//find category Hoa quả
	@RequestMapping(value = "/productCategory2", method = RequestMethod.GET)
	public ModelAndView productCategory2(
			@RequestParam(value = "category" ,required = false) String category,
			@RequestParam(value = "page" ,required = false) Integer page,
            @RequestParam(value ="limit" ,required = false) Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("web/productCategory/HoaQua");
		List<ProductDTO> listProductDto = new ArrayList<ProductDTO>();
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
	   //xử lý offset và limit
		
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);
		Page<ProductEntity> resultPage = productService.findByCategoryCode(category, pageable);
		for (ProductEntity item : resultPage) {
			ProductDTO dto = new ProductDTO();
			dto = productConverter.toDto(item);
			listProductDto.add(dto);
		}
		model.setListResult(listProductDto);
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	// Search
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public ModelAndView productSearch( @RequestParam(value = "name" ,required = false) String name ,HttpServletRequest request ){

		if (name != null && name.length() >0) {
			ModelAndView mav = new ModelAndView("web/productSearch");
			ProductDTO model = new ProductDTO();
			
				model.setListResult(productService.findByName(name));
				mav.addObject("model", model);
				return mav;
		} else {
			return new ModelAndView("redirect:/product?page=1&limit=8");
		}
	}
}