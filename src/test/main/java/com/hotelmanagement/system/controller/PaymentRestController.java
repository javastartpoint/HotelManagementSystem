/**
 * 
 */
package com.hotelmanagement.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.system.entity.Payment;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.PaymentService;

/**
 * @author Premala
 *
 */

@RestController
@RequestMapping("/api")
public class PaymentRestController {
	
	PaymentService  paymentService;
	
	@Autowired
	public PaymentRestController(PaymentService  paymentService) {
		super();
		this.paymentService=paymentService;
	}
	
	@GetMapping("/payments")
	public List<Payment> findAll(){
		return paymentService.findAll();
	}
	
	@GetMapping("/payments/{paymentId}")
	public Payment getPaymentById(@PathVariable long paymentId) throws DataNotFoundException {
		Payment payment=paymentService.findById(paymentId);
		return payment;
	}
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment payment) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		payment.setPaymentId(0);
		paymentService.save(payment);
		return payment;
	}
	
}
