package com.bhushan_blogging_api.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhushan_blogging_api.exception.ResourceNotFoundException;
import com.bhushan_blogging_api.model.User;
import com.bhushan_blogging_api.playload.UserDto;
import com.bhushan_blogging_api.repository.UserRepository;
import com.bhushan_blogging_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	@Autowired
	private ModelMapper mp;

	@Override
	public UserDto createUser(UserDto userDto) {
		User u = dtoUser(userDto);
		User savedUser = ur.save(u);
		return usertoDto(savedUser);
	}

	@Override
	public UserDto updateuser(UserDto userDto, Integer id) {
		User u = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		u.setId(id);
		u.setName(userDto.getName());
		u.setEmail(userDto.getEmail());
		u.setPassword(userDto.getPassword());
		u.setAbout(userDto.getAbout());
		User savedUser = ur.save(u);

		return usertoDto(savedUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return usertoDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = ur.findAll();
		// long way
//		List<UserDto> userDto=new LinkedList<>();
//		for(User u:users)
//			userDto.add(usertoDto(u));
		// shortway
		List<UserDto> userDto = users.stream().map(user -> usertoDto(user)).collect(Collectors.toList());
		return userDto;

	}

	@Override
	public void deleteUser(Integer id) {
		User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		ur.delete(user);
	}

	private User dtoUser(UserDto userDto) {
		User user = mp.map(userDto, User.class);//by using model mapper way
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}

	private UserDto usertoDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}
}
