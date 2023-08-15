package com.bhushan_blogging_api.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bhushan_blogging_api.exception.ResourceNotFoundException;
import com.bhushan_blogging_api.model.Category;
import com.bhushan_blogging_api.model.Post;
import com.bhushan_blogging_api.model.User;
import com.bhushan_blogging_api.playload.PostDto;
import com.bhushan_blogging_api.playload.PostResponce;
import com.bhushan_blogging_api.repository.CategoryRepository;
import com.bhushan_blogging_api.repository.PostRepository;
import com.bhushan_blogging_api.repository.UserRepository;
import com.bhushan_blogging_api.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository pr;

	@Autowired
	private UserRepository ur;

	@Autowired
	private CategoryRepository cr;

	@Autowired
	private ModelMapper mp;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		Category category = cr.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

		Post post = mp.map(postDto, Post.class);
		post.setImageName("defult.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post savePost = pr.save(post);

		return mp.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = pr.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post savePost = pr.save(post);

		return mp.map(savePost, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = pr.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		return mp.map(post, PostDto.class);
	}

	@Override
	public PostResponce getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		// turnory operator
		Sort sort = ((sortDir.equalsIgnoreCase("asc")) ? (Sort.by(sortBy).ascending())
				: (Sort.by(sortBy).descending()));

//		if(sortDir.equalsIgnoreCase("asc"))
//		{
//			sort=Sort.by(sortBy).ascending();
//		}
//		else
//		{
//			sort=Sort.by(sortBy).descending();
//		}
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post> pagePost = pr.findAll(p);
		List<Post> post = pagePost.getContent();
		List<PostDto> postDtos = post.stream().map((posts) -> mp.map(posts, PostDto.class))
				.collect(Collectors.toList());

		PostResponce pr = new PostResponce();
		pr.setContent(postDtos);
		pr.setPageNumber(pagePost.getNumber());
		pr.setPageSize(pagePost.getSize());
		pr.setTotalElements(pagePost.getTotalElements());
		pr.setTotalPages(pagePost.getTotalPages());
		pr.setLastPage(pagePost.isLast());

		return pr;
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = pr.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		pr.delete(post);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category category = cr.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		List<Post> categories = pr.getByCategory(category);
		List<PostDto> posts = categories.stream().map((post) -> mp.map(post, PostDto.class))
				.collect(Collectors.toList());
		return posts;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		List<Post> getPost = pr.getByUser(user);
		List<PostDto> posts = getPost.stream().map((post) -> mp.map(post, PostDto.class)).collect(Collectors.toList());
		return posts;
	}

	@Override
	public List<PostDto> serachPost(String keyword) {
		List<Post> post = pr.getByTitleContaining(keyword);
		List<PostDto> postDtos = post.stream().map((pst) -> mp.map(pst, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
