package com.phu.springsecurity.service;

import com.phu.springsecurity.entity.Products;
import com.phu.springsecurity.entity.UserInfo;
import com.phu.springsecurity.model.ProductModel;
import com.phu.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Products products){

        productRepository.save(products);
        return "Product Added successfully";
    }

    public String updateProduct(Integer id, ProductModel productM){
        Products products = productRepository.findById(id).get();

        products.setProductName(productM.getProductName());
        products.setProductCategory(productM.getProductCategory());
        products.setPrice(productM.getPrice());

        productRepository.save(products);
        return "Product Update successfully";
    }

    public String deleteProduct(Integer id) {
        Optional<Products> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Products products = optionalProduct.get();
            productRepository.delete(products);
            return "Product deleted successfully";
        } else {
            return "Product with ID " + id + " not found";
        }
    }
    public List<Products> getAllProduct(){
        return productRepository.findAll();
    }

    public Products getProduct(Integer id){
        return productRepository.findById(id).get();
    }
}
