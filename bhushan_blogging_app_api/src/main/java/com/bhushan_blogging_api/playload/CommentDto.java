package com.bhushan_blogging_api.playload;

public class CommentDto {

	private Integer id;

	private String content;

	private PostDto post;

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentDto() {
		super();
	}

	public CommentDto(Integer id, String content, PostDto post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
	}

}
