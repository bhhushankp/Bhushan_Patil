package com.bhushan_blogging_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhushan_blogging_api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
