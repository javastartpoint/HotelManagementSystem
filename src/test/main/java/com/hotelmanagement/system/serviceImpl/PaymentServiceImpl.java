/**
 * 
 */
package com.hotelmanagement.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.PaymentRepository;
import com.hotelmanagement.system.entity.Payment;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.PaymentService;

/**
 * @author Premala
 *
 */

@Service
public class PaymentServiceImpl implements PaymentService {
	
	PaymentRepository paymentRepository;
	
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository=paymentRepository;
	}

	@Override
	public List<Payment> findAll() {
		
		return paymentRepository.findAll();
	}

	@Override
	public Payment findById(long paymentId) throws DataNotFoundException {
		Optional<Payment> result = paymentRepository.findById(paymentId);
		Payment payment = null;
		if (result.isPresent()) {
			payment = result.get();
		} else {
			throw new DataNotFoundException("Payment Id not found " + paymentId);
		}
		return payment;
	}

	@Override
	public void save(Payment payment) {
		try {
			if(null!=payment) {
				paymentRepository.save(payment);
			} else {
				System.out.println("Couldn't save transaction due to payment object is null..!!");
			}
			System.out.println("saved transaction successfully..!!");
		} catch (Exception e) {
			System.out.println("Exception occured while saving Transaction..!!"+e);
		}
	}
	
}
