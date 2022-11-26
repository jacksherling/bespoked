package com.jack.bespoked.repository;

import com.jack.bespoked.entity.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

    @Query(value = "SELECT * FROM sale s WHERE s.sales_date BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<Sale> getSaleByQuarter(String date1, String date2);

}