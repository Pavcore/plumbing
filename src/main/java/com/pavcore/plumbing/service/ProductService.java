package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.requestTo.ProductRequestTO;
import com.pavcore.plumbing.dto.responseTo.ProductResponseTO;
import com.pavcore.plumbing.dao.postgres.entity.Product;
import com.pavcore.plumbing.mapper.ProductMapper;
import com.pavcore.plumbing.dao.postgres.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public ProductResponseTO getProductById(long id) {
        return productMapper.mapResp(productRepo.getReferenceById(id));
    }

    public List<ProductResponseTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductResponseTO> productResponseTOs = new ArrayList<>();
        for (Product product : products) {
            productResponseTOs.add(productMapper.mapResp(product));
        }
        return productResponseTOs;
    }

    public ProductResponseTO createProduct(ProductRequestTO productRequestTO) {
        Product product = productMapper.mapReq(productRequestTO);
        productRepo.save(product);
        return productMapper.mapResp(product);
    }

    public void updateProductTitle(long id, String title) {
        Product product = productRepo.getReferenceById(id);
        product.setTitle(title);
        productRepo.save(product);
    }

    public void updateProductPrice(long id, double price) {
        Product product = productRepo.getReferenceById(id);
        product.setPrice(price);
        productRepo.save(product);
    }

    public void updateProductWeight(long id, double weight) {
        Product product = productRepo.getReferenceById(id);
        product.setWeight(weight);
        productRepo.save(product);
    }

    public void updateProductMaterial(long id, String material) {
        Product product = productRepo.getReferenceById(id);
        product.setMaterial(material);
        productRepo.save(product);
    }

    public void updateProductColor(long id, String color) {
        Product product = productRepo.getReferenceById(id);
        product.setColor(color);
        productRepo.save(product);
    }

    public void updateProductArticleNumber(long id, long articleNumber) {
        Product product = productRepo.getReferenceById(id);
        product.setArticleNumber(articleNumber);
        productRepo.save(product);
    }

    public void updateProductDescription(long id, String description) {
        Product product = productRepo.getReferenceById(id);
        product.setDescription(description);
        productRepo.save(product);
    }

    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }
}
