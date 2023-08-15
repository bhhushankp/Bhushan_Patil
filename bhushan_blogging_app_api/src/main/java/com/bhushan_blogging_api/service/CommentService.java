package com.bhushan_blogging_api.service;

import com.bhushan_blogging_api.playload.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId); 

}
