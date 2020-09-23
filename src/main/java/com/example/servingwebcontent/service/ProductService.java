package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Repos.CartRepo;
import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.Repos.UserRepo;
import com.example.servingwebcontent.domain.Cart;
import com.example.servingwebcontent.domain.Product;
import com.example.servingwebcontent.domain.User;
import org.bouncycastle.util.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${defaultJpg}")
    private String defaultImg;


    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CartRepo cartRepo;

    public List findAll() {
        return productRepo.findAll();
    }

    public void updateProduct(Long id, String name, String price, String category,
                              String description, MultipartFile file) throws IOException {
  Product product= productRepo.findById(id).get();
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (product.getFilename()!=defaultImg){
            File oldFile=new File(uploadPath+ "/" +product.getFilename());
            oldFile.delete();}
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

    public List<Product> findProductsInCart(User user) {
        List<Cart> cartList = cartRepo.findByUserId(user.getId());
        List<Product> products=new ArrayList<>();
        for (int i=0;i<cartList.size();i++) {
          Product product= productRepo.findById(cartList.get(i).getProductId()).get();
          products.add(new Product(product.getId(),product.getName(),product.getPrice(),
                  product.getDescription(),product.getCategory(),product.getFilename()));
        }
        return  products;
    }
}
