package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo userRepo;

    public List findAll() {
        return userRepo.findAll();
    }
}
