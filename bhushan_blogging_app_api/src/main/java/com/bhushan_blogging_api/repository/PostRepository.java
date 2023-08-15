package com.bhushan_blogging_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhushan_blogging_api.model.Category;
import com.bhushan_blogging_api.model.Post;
import com.bhushan_blogging_api.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{


	List<Post> getByUser(User user);
	
	List<Post> getByCategory(Category category);
	
	List<Post> getByTitleContaining(String title);
}
