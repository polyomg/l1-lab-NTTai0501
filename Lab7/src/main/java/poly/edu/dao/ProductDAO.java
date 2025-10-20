package poly.edu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.entity.Product;
import poly.edu.model.Report;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    // Bài 1: tìm theo khoảng giá (JPQL)
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    // Bài 2: tìm theo tên có phân trang
    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    // Bài 3: tổng hợp tồn kho theo loại
    @Query("SELECT p.category.name AS group, SUM(p.price) AS sum, COUNT(p) AS count "
            + "FROM Product p GROUP BY p.category.name ORDER BY SUM(p.price) DESC")
    List<Report> getInventoryByCategory();

    // Bài 4: DSL - tìm theo khoảng giá
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Bài 5: DSL - tìm theo tên có phân trang
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}
