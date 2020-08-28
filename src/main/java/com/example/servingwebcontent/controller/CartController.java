package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Repos.CartRepo;
import com.example.servingwebcontent.domain.Cart;
import com.example.servingwebcontent.domain.Product;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductService productService;

@PostMapping("/cartadd")
public String addToCart( @RequestParam String userId,
                         @RequestParam String productId){
Cart cart=new Cart(Long.parseLong(userId), Long.parseLong(productId));
    List<Cart> all = cartRepo.findByUserId(Long.parseLong(userId));
    boolean isInCart=false;
    for (int i=0;i<all.size();i++) {
        if (all.get(i).getProductId() == cart.getProductId()){
            isInCart=true;
        }
    }
    if (!isInCart){cartRepo.save(cart);}
        return "redirect:/main";
}

@GetMapping("/cart")
    public String viewCart(Model model, @AuthenticationPrincipal User user){
    Iterable<Product> products = productService.findProductsInCart(user);
    model.addAttribute("products",products);
    return "cart";
}



}
