package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // === Query Methods (Spring สร้าง SQL ให้อัตโนมัติ) ===

    // SELECT * FROM products WHERE name = ?
    Optional<Product> findByName(String name);

    // SELECT * FROM products WHERE name LIKE '%keyword%'
    List<Product> findByNameContaining(String keyword);

    // SELECT * FROM products WHERE price < ?
    List<Product> findByPriceLessThan(BigDecimal price);

    // SELECT * FROM products WHERE price BETWEEN ? AND ?
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // SELECT * FROM products WHERE stock > 0 ORDER BY name
    List<Product> findByStockGreaterThanOrderByNameAsc(Integer stock);

    // SELECT * FROM products WHERE name LIKE ? AND price < ?
    List<Product> findByNameContainingAndPriceLessThan(String name, BigDecimal price);

    // === Custom JPQL Query ===
    @Query("SELECT p FROM Product p WHERE p.stock <= :threshold")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);

    // === Native SQL Query ===
    @Query(value = "SELECT * FROM products WHERE stock = 0", nativeQuery = true)
    List<Product> findOutOfStockProducts();

    // === Count & Exists ===
    long countByStockGreaterThan(Integer stock);
    boolean existsByName(String name);
}
