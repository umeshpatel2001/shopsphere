package com.shopsphere.productservice.repository;

import com.shopsphere.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);

}