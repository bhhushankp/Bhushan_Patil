package com.bhushan_blogging_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhushan_blogging_api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
