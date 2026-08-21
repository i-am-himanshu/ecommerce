package com.himanshu.ecommerce.service;

import com.himanshu.ecommerce.dto.ProductRequest;
import com.himanshu.ecommerce.dto.ProductResponse;
import com.himanshu.ecommerce.model.Product;
import com.himanshu.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = new Product();

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());

        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(savedProduct.getId());
        productResponse.setName(savedProduct.getName());
        productResponse.setDescription(savedProduct.getDescription());
        productResponse.setPrice(savedProduct.getPrice());
        productResponse.setStockQuantity(savedProduct.getStockQuantity());

        return productResponse;
    }
}
