package com.codecool.service;

import com.codecool.dto.ProductDTO;
import com.codecool.entity.Product;
import com.codecool.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Convert Entity to DTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setSupplierId(product.getSupplierId());
        dto.setContractId(product.getContractId());
        return dto;
    }

    // Convert DTO to Entity
    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setSupplierId(dto.getSupplierId());
        product.setContractId(dto.getContractId());
        return product;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).toList();
    }

    public ProductDTO getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::convertToDTO).orElse(null);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        if (productRepository.existsById(id)) {
            Product product = convertToEntity(productDTO);
            product.setId(id); // Ensure the ID is set correctly
            Product updatedProduct = productRepository.save(product);
            return convertToDTO(updatedProduct);
        }
        return null; // Or throw an exception if preferred
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
