package com.product_management.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product_management.dto.ProductRequestDto;
import com.product_management.dto.ProductResponseDto;
import com.product_management.entites.Product;
import com.product_management.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductResponseDto> getAllProducts() {
		try {
			List<Product> getAllProducts = productRepository.findAll();
			List<ProductResponseDto> response = new ArrayList<>();
			for (Product product : getAllProducts) {

				ProductResponseDto productResponseDto = new ProductResponseDto();
				BeanUtils.copyProperties(product, productResponseDto, ProductResponseDto.class);

				response.add(productResponseDto);
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ProductResponseDto getProductById(Long id) {
		try {
			Product product = productRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Product not found"));
			ProductResponseDto productResponseDto = new ProductResponseDto();
			BeanUtils.copyProperties(product, productResponseDto, ProductResponseDto.class);

			return productResponseDto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
		try {

			Product product = new Product();
			product.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			BeanUtils.copyProperties(productRequestDto, product, Product.class);
			Product savedProduct = productRepository.save(product);

			ProductResponseDto productResponseDto = new ProductResponseDto();
			BeanUtils.copyProperties(savedProduct, productResponseDto, ProductResponseDto.class);
			return productResponseDto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {

		try {
			ProductResponseDto productResponseDto = new ProductResponseDto();
			if (productRepository.existsById(id)) {
				Product product = productRepository.findById(id)
						.orElseThrow(() -> new EntityNotFoundException("Product not found"));
				BeanUtils.copyProperties(productRequestDto, product, Product.class);

				product.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
				Product savedProduct = productRepository.save(product);

				productResponseDto = new ProductResponseDto();
				BeanUtils.copyProperties(savedProduct, productResponseDto, ProductResponseDto.class);

				return productResponseDto;
			} else {
				return productResponseDto;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Long deleteProduct(Long id) {
		try {
			if (productRepository.existsById(id)) {
				productRepository.deleteById(id);
				return id;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ProductResponseDto updateStock(Long id, int quantity) {
		try {
			ProductResponseDto productResponseDto = new ProductResponseDto();
			if (productRepository.existsById(id)) {
				Product product = productRepository.findById(id)
						.orElseThrow(() -> new EntityNotFoundException("Product not found"));
				product.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
				product.setStockQuantity(quantity);
				Product savedProduct = productRepository.save(product);

				productResponseDto = new ProductResponseDto();
				BeanUtils.copyProperties(savedProduct, productResponseDto, ProductResponseDto.class);
				return productResponseDto;
			} else {
				return productResponseDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
