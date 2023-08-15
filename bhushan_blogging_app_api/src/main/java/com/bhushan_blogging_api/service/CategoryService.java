package com.bhushan_blogging_api.service;

import java.util.List;

import com.bhushan_blogging_api.playload.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategory();
	
	void deleteCategory(Integer categoryId);
	

}
