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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    List<Cart> userCart = cartRepo.findByUserId(Long.parseLong(userId));
    boolean isInCart=false;
    for (int i=0;i<userCart.size();i++) {
        if (Objects.equals(userCart.get(i).getProductId(), Long.parseLong(productId) )){
            isInCart=true;
        }
    }
    if (!isInCart){cartRepo.save(cart);}
        return "redirect:/main";
}

@GetMapping("/cart")
    public String viewCart(Model model, @AuthenticationPrincipal User user){
    List<Product> products = productService.findProductsInCart(user);
    model.addAttribute("products",products);
    return "cart";
}

@GetMapping("/cart/deleteproduct/{id}")
    public String deleteProductFromCart(@PathVariable(value = "id") Long id,
                                        @AuthenticationPrincipal User user){
    List<Cart> byUserId = cartRepo.findByUserId(user.getId());
    Cart cart=new Cart();
    for (int i=0;i<byUserId.size();i++){
        if (Objects.equals(byUserId.get(i).getProductId(),id)){
            cart=byUserId.get(i);
        }
    }
    cartRepo.delete(cart);
    return "redirect:/cart";
}



}
