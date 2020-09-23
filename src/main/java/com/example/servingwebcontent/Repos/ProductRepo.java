package com.example.servingwebcontent.Repos;

import com.example.servingwebcontent.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends  JpaRepository<Product, Long> {

   Product findByCategory(String filter);
    Iterable<Product> findById(String id);

}
