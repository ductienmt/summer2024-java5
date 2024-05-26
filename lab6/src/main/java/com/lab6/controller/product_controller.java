package com.lab6.controller;

import com.lab6.model.entity.Product;
import com.lab6.model.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class product_controller {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("")
    public String product(Model model,
                          @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                          @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                          @RequestParam(name = "sortField", defaultValue = "id") String sortField,
                          @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir) {

        Product product = new Product();
        model.addAttribute("product", product);

        Page<Product> products;
        if (keyword.isEmpty()) {
            products = productService.findAll(pageNo, sortField, sortDir);
        } else {
            products = productService.search(keyword, pageNo, sortField, sortDir);
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("products", products);
        model.addAttribute("totalPage", products.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "product/index";
    }


    @PostMapping("/add")
    public String add(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("product") Product product, @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                         @RequestParam(name = "sortField", defaultValue = "id") String sortField,
                         @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            // Thêm các trường khác cần cập nhật
            productService.save(existingProduct);
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Product not found");
        }
        return "redirect:/product?pageNo=" + pageNo + "&sortField=" + sortField + "&sortDir=" + sortDir;
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                       @RequestParam(name = "sortField", defaultValue = "id") String sortField,
                       @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("product", product);
            Page<Product> products = productService.findAll(pageNo, sortField, sortDir);
            model.addAttribute("products", products);
            model.addAttribute("totalPage", products.getTotalPages());
            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
            model.addAttribute("currentPage", pageNo);
        } else {
            return "redirect:/product";
        }
        return "product/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return "redirect:/product";
    }



}
