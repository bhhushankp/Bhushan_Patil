package com.bhushan_blogging_api.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhushan_blogging_api.exception.ResourceNotFoundException;
import com.bhushan_blogging_api.model.Comment;
import com.bhushan_blogging_api.model.Post;
import com.bhushan_blogging_api.playload.CommentDto;
import com.bhushan_blogging_api.repository.CommentRepository;
import com.bhushan_blogging_api.repository.PostRepository;
import com.bhushan_blogging_api.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository ps;

	@Autowired
	private CommentRepository cr;

	@Autowired
	private ModelMapper mp;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = ps.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = mp.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saveComment = cr.save(comment);
		return mp.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = cr.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "id", commentId));
		cr.delete(comment);
	}

}
