package com.example.servingwebcontent.controller.admin;

import com.example.servingwebcontent.Repos.CategoryRepo;
import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.domain.Product;
import com.example.servingwebcontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productedit")
public class AdminProductEditRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> productList(Model model) {
        return productService.findAll();
    }

}
