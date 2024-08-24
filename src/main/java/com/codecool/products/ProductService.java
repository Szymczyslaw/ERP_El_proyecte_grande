package com.codecool.products;

import com.codecool.customers.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }


    public List<ProductDTO> getAllProducts() {
    return productRepository.findAll().stream().map(productMapper::mapEntityToDTO).toList();
    }

    public ProductDTO getProductById(UUID id) {
        return productRepository.findById(id).map(productMapper::mapEntityToDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ProductDTO createProduct(ProductRequestDTO productDTO) {
        try {
            var newCustomer = productMapper.mapDTOToEntity(productDTO);
            var savedCustomer = productRepository.save(newCustomer);
            return productMapper.mapEntityToDTO(savedCustomer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to save customer", e);
        }
    }

    public ProductDTO updateProduct(UUID id, ProductRequestDTO productDTO) {
        Product productFromDB = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        productFromDB.setName(productDTO.name());
        productFromDB.setPrice(productDTO.Price());

        Product updatedProduct = productRepository.save(productFromDB);
        return productMapper.mapEntityToDTO(updatedProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
