package org.proxidev.productservice.product;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long>{
    Page<Product> findProductByCategory_Id(long id, Pageable pageable);
}
