package com.example.servingwebcontent.controller.admin;

import com.example.servingwebcontent.Repos.CategoryRepo;
import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.controller.ControllerUtils;
import com.example.servingwebcontent.domain.Category;
import com.example.servingwebcontent.domain.Product;
import com.example.servingwebcontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/adminproducteditormenu")
public class AdminProductEditorMenu {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${defaultJpg}")
    private String defaultImg;

    @GetMapping
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories",categoryRepo.findAll());
        return "productList";
    }

    @GetMapping("{id}")
    public String productEdit(@PathVariable (value = "id") Long id, Model model) {
        Product product=productRepo.findById(id).get();
        model.addAttribute("product",product);
        model.addAttribute("categories",categoryRepo.findAll());
        return "productEdit";
    }

    @PostMapping("{id}")
    public String updateProduct( @PathVariable (value = "id") Long id,
                                 @RequestParam String name,
                                 @RequestParam String price,
                                 @RequestParam String category,
                                 @RequestParam String description,
                                 @RequestParam("file") MultipartFile file) throws IOException {

productService.updateProduct(id,name,price,category,description,file);
        return "redirect:/adminproducteditormenu";
    }

    @PostMapping("/addcategory")
    public String addCategory(@Valid Category category
                              ){
        if (!category.getName().equals("")){
            categoryRepo.save(category);}
        return "redirect:/adminproducteditormenu";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") Long id
                             ){
        Product product= productRepo.findById(id).get();
        if (!product.getFilename().equals(defaultImg)){
        File oldFile=new File(uploadPath+ "/" +product.getFilename());
        oldFile.delete();}
       productRepo.deleteById(id);

        return "redirect:/adminproducteditormenu";
    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable (value = "id") Long id
    ){
        categoryRepo.deleteById(id);
        return "redirect:/adminproducteditormenu";
    }

    @PostMapping
    public String addProduct(
            @RequestParam("file") MultipartFile file,
            @Valid Product product,
            BindingResult bindingResult,
            Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("product", product);
        } else {
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                product.setFilename(resultFilename);
            }else {product.setFilename(defaultImg);}
            model.addAttribute("message",null);
            productRepo.save(product);
        }
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "redirect:/adminproducteditormenu";
    }
}
