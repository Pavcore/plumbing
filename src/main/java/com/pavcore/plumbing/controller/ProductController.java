package com.pavcore.plumbing.controller;

import com.pavcore.plumbing.dto.requestTo.ProductRequestTO;
import com.pavcore.plumbing.dto.responseTo.ProductResponseTO;
import com.pavcore.plumbing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseTO> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseTO getProduct(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponseTO createProduct(@RequestBody ProductRequestTO productRequestTO) {
        return productService.createProduct(productRequestTO);
    }

    @PostMapping("/title")
    public ResponseEntity<String> updateProductTitle(@RequestParam String title) {
        productService.updateProductTitle(1, title);
        return new ResponseEntity<>("Title update", HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<String> updateProductPrice(@RequestParam double price) {
        productService.updateProductPrice(1, price);
        return new ResponseEntity<>("Price update", HttpStatus.OK);
    }

    @PostMapping("/weight")
    public ResponseEntity<String> updateProductWeight(@RequestParam double weight) {
        productService.updateProductWeight(1, weight);
        return new ResponseEntity<>("Weight update", HttpStatus.OK);
    }

    @PostMapping("/material")
    public ResponseEntity<String> updateProductMaterial(@RequestParam String material) {
        productService.updateProductMaterial(1, material);
        return new ResponseEntity<>("Material update", HttpStatus.OK);
    }

    @PostMapping("/color")
    public ResponseEntity<String> updateProductColor(@RequestParam String color) {
        productService.updateProductColor(1, color);
        return new ResponseEntity<>("Color update", HttpStatus.OK);
    }

    @PostMapping("/article_number")
    public ResponseEntity<String> updateProductArticleNumber(@RequestParam long articleNumber) {
        productService.updateProductArticleNumber(1, articleNumber);
        return new ResponseEntity<>("Article number update", HttpStatus.OK);
    }

    @PostMapping("/description")
    public ResponseEntity<String> updateProductDescription(@RequestParam String description) {
        productService.updateProductDescription(1, description);
        return new ResponseEntity<>("Description update", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestParam long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }
}
