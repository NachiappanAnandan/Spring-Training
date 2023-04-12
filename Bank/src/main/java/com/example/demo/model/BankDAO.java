package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository for bank entity
 * @author Nachiappan
 *
 */
@Repository
public interface BankDAO extends JpaRepository<BankDTO, Integer>{
}
