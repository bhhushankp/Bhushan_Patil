package com.bhushan_blogging_api.service;

import java.util.List;

import com.bhushan_blogging_api.playload.PostDto;
import com.bhushan_blogging_api.playload.PostResponce;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	PostDto getPostById(Integer  postId);
	
	PostResponce getAllPost(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	
	void deletePost(Integer postId);
	
	List<PostDto> getPostByCategory(Integer	categoryId);
	
	List<PostDto> getPostByUser(Integer	userId);
	
	List<PostDto> serachPost(String	keyword);
	
	
	
	
	

	
	
}
