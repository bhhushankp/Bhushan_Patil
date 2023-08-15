package com.bhushan_blogging_api.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhushan_blogging_api.exception.ResourceNotFoundException;
import com.bhushan_blogging_api.model.Category;
import com.bhushan_blogging_api.playload.CategoryDto;
import com.bhushan_blogging_api.repository.CategoryRepository;
import com.bhushan_blogging_api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cr;

	@Autowired
	private ModelMapper mp;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// Category category = mp.map(categoryDto, Category.class);
		Category saveCategory = cr.save(mp.map(categoryDto, Category.class));
		return mp.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = cr.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category saveCategory = cr.save(category);
		return mp.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = cr.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		return mp.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = cr.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map((category)->mp.map(category, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = cr.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		cr.delete(category);
	}

}
