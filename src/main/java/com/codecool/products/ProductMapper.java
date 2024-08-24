package com.codecool.products;

import com.codecool.contracts.Contract;
import com.codecool.supplier.Supplier;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO mapEntityToDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                (Supplier) entity.getSupplierList(),
                (Contract) entity.getContractList()
        );
    }
    public Product mapDTOToEntity(@Valid ProductRequestDTO dto){
        return new Product(
                dto.name(),
                dto.Price(),
                dto.supplierList(),
                dto.contractList()
        );
    }
}
