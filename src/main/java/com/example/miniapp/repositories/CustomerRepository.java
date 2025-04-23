package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.miniapp.models.Customer;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /*@Query(value="SELECT email FROM \"customer\" WHERE email LIKE domain",nativeQuery=true)
    public List<Customer> findByEmailEndingWith(@Param(value="email")String domain);

    @Query (value="SELECT phonenumber FROM \"customer\" WHERE phonenumber LIKE prefix")
    List<Customer> findByPhoneNumberStartingWith(@Param(value="phonenumber")String prefix);*/

    List<Customer> findByEmailEndingWith(String domain);

    List<Customer> findByPhoneNumberStartingWith(String prefix);

}
