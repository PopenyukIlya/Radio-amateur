package com.example.servingwebcontent.Repos;

import com.example.servingwebcontent.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Object> {
}
