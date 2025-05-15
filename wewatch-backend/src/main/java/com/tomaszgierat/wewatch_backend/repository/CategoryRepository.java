package com.tomaszgierat.wewatch_backend.repository;

import com.tomaszgierat.wewatch_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}