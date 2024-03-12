package com.phu.springsecurity.controller;

import com.phu.springsecurity.entity.Products;
import com.phu.springsecurity.model.ProductModel;
import com.phu.springsecurity.service.JwtService;
import com.phu.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Products !!";
    }

    @PostMapping("/addProduct")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public String addProduct(@RequestBody Products products){
        return productService.addProduct(products);

    }

    @PutMapping("/updateProduct/{id}")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public String updateProduct(@PathVariable Integer id,
                                @RequestBody ProductModel productM){
        return productService.updateProduct(id, productM);

    }

    @DeleteMapping("/deleteProduct/{id}")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public String deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/getAllProducts")
    @PreAuthorize("hasAuthority('ADMIN_ROLES, USER_ROLES')")
    public List<Products> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/getProducts/{id}")
    @PreAuthorize("hasAuthority('USER_ROLES')")
    public Products getAllProducts(@PathVariable Integer id){
        return productService.getProduct(id);
    }
}