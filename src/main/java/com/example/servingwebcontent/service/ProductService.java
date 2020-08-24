package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.Repos.UserRepo;
import com.example.servingwebcontent.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ProductRepo productRepo;

    public List findAll() {
        return productRepo.findAll();
    }

    public void updateProduct(Long id, String name, String price, String category,
                              String description, MultipartFile file) throws IOException {
  Product product= productRepo.findById(id).get();
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            product.setFilename(resultFilename);
        }
        product.setCategory(category);
        product.setDescription(description);
        product.setName(name);
        product.setPrice(Double.parseDouble( price.replace(",",".") ));
  productRepo.save(product);
    }
}
