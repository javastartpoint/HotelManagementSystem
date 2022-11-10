package com.hotelmanagement.system.service;

import java.util.List;
import com.hotelmanagement.system.entity.Payment;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */
public interface PaymentService {

	List<Payment> findAll();

	Payment findById(long paymentId) throws DataNotFoundException;

	void save(Payment payment);
	
}
