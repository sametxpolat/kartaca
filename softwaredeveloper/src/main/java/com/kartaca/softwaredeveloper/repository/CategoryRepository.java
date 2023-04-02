package com.kartaca.softwaredeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartaca.softwaredeveloper.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
      
}
