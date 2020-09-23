package com.example.servingwebcontent.Repos;

import com.example.servingwebcontent.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {


}
