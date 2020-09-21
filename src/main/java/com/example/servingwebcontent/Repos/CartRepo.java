package com.example.servingwebcontent.Repos;

import com.example.servingwebcontent.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Object> {
    List<Cart> findByUserId(long userId);
}
