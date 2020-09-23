package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Repos.CategoryRepo;
import com.example.servingwebcontent.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;




}
