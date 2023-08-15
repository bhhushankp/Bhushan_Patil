package com.bhushan_blogging_api.service;

import java.util.List;

import com.bhushan_blogging_api.playload.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateuser(UserDto user,Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer id);
}
