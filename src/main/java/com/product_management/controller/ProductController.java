package com.product_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product_management.dto.ProductRequestDto;
import com.product_management.dto.ProductResponseDto;
import com.product_management.service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
		List<ProductResponseDto> getAllProducts = productService.getAllProducts();

		if (getAllProducts.size() > 0) {
			return ResponseEntity.status(HttpStatus.FOUND).body(getAllProducts);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getProductById(@Valid @PathVariable Long id) {
		ProductResponseDto productResponseDto = productService.getProductById(id);
		if (productResponseDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(productResponseDto);
	}

	@PostMapping
	public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto product) {
		ProductResponseDto createdProduct = productService.createProduct(product);
		if (createdProduct != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(@Valid @PathVariable Long id,
			@RequestBody ProductRequestDto product) {
		
		ProductResponseDto productResponseDto =productService.updateProduct(id, product);
		if (productResponseDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productResponseDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@Valid @PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(null);
	}

	@PatchMapping("/{id}/update-stock")
	public ResponseEntity<ProductResponseDto> updateStock(@Valid @PathVariable Long id,
			@RequestParam Integer quantity) {
		ProductResponseDto productResponseDto = productService.updateStock(id, quantity);
		if (productResponseDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productResponseDto);
	}
}