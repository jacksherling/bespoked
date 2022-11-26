package com.jack.bespoked.repository;

import com.jack.bespoked.entity.Salesperson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalespersonRepository extends CrudRepository<Salesperson, Integer> {

    @Query(value = "SELECT * FROM salesperson s WHERE NOT (s.start_date > ?2 OR s.termination_date <  ?1)",
        nativeQuery = true)
    List<Salesperson> getSalespeopleByQuarter(String date1, String date2);

    Salesperson findByFirstNameAndLastName(String firstName, String lastName);


}