package com.hotelmanagement.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.system.entity.Payment;
/**
 * 
 * @author Premala
 *
 */
public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
