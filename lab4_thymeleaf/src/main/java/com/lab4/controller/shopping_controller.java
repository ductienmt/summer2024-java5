package com.lab4.controller;

import com.lab4.entity.CartItem;
import com.lab4.entity.Product;
import com.lab4.service.ParamService;
import com.lab4.service.ProductService;
import com.lab4.service.ProductServiceImpl;
import com.lab4.service.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping-cart")
public class shopping_controller {
    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ParamService paramService;


    @GetMapping("view")
    public String view(Model model) {
        model.addAttribute("items", shoppingCartService.getItems());
        model.addAttribute("count", shoppingCartService.getCount());

        model.addAttribute("amount", shoppingCartService.getAmount());
        return "shopping_cart/shopping_cart";
    }

    @GetMapping("add/{id}")
    public String add(@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        if (product != null) {
            shoppingCartService.add(new CartItem(product.getId(), product.getName(), product.getPrice(), 1, product.getImage()));
        }
//        System.out.println(shoppingCartService.getItems());
        return "redirect:/shopping-cart/view";
    }

    @GetMapping("clear-cart")
    public String clearCart() {
        shoppingCartService.clear();
        return "redirect:/shopping-cart/view";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        shoppingCartService.remove(id);
        return "redirect:/shopping-cart/view";
    }

    @GetMapping("update/plus/{id}/{quantity}")
    public String updatePlus(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) {
        shoppingCartService.update(id, quantity+1);
        return "redirect:/shopping-cart/view";
    }

    @GetMapping("update/minus/{id}/{quantity}")
    public String updateMinus(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) {
        shoppingCartService.update(id, quantity-1);
        return "redirect:/shopping-cart/view";
    }

}
