package com.bhushan_blogging_api.playload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bhushan_blogging_api.model.Comment;

public class PostDto {

	private Integer postId;
	
	private String title;

	private String content;

	private String imageName;

	private Date addedDate;
	
	private UserDto user;
	
	private CategoryDto category;
	
	
	private List<Comment> comments=new ArrayList<>();


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	


	public PostDto(Integer postId, String title, String content, String imageName, Date addedDate, UserDto user,
			CategoryDto category, List<Comment> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.user = user;
		this.category = category;
		this.comments = comments;
	}

	public PostDto() {
		super();
	}

	
	
}
