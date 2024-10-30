package com.product_management.service;

import java.util.List;

import com.product_management.dto.ProductRequestDto;
import com.product_management.dto.ProductResponseDto;

public interface IProductService {

	List<ProductResponseDto> getAllProducts();

	ProductResponseDto getProductById(Long id);

	ProductResponseDto createProduct(ProductRequestDto productRequestDto);

	ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

	void deleteProduct(Long id);

	ProductResponseDto updateStock(Long id, int quantity);
}
