package com.example.servingwebcontent.controller.admin;

import com.example.servingwebcontent.Repos.CategoryRepo;
import com.example.servingwebcontent.Repos.ProductRepo;
import com.example.servingwebcontent.controller.ControllerUtils;
import com.example.servingwebcontent.domain.Category;
import com.example.servingwebcontent.domain.Product;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.ProductService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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

    @GetMapping
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories",categoryRepo.findAll());
        return "productList";
    }

    @PostMapping("/addcategory")
    public String addCategory(@Valid Category category,
                              BindingResult bindingResult,
                              Model model){
        if (category.getName()!=null){
        categoryRepo.save(category);}
        return "redirect:/adminproducteditormenu";
    }

    @PostMapping
    public String add(
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
            }
            model.addAttribute("message",null);
            productRepo.save(product);
        }
        Iterable<Product> products = productRepo.findAll();

        model.addAttribute("products", products);

        return "productList";
    }
}
