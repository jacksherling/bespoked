package com.jack.bespoked.repository;

import com.jack.bespoked.entity.Discount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Integer> {

    @Query(value = "SELECT * FROM discount d WHERE d.product_foreign_key = ?1 AND d.begin_date <= ?2 AND d.end_date >= ?2",
            nativeQuery = true)
    List<Discount> findDiscounts(Integer pid, String date);

}