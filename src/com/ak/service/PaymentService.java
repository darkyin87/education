package com.ak.service;

import org.springframework.stereotype.Service;

import com.ak.model.PaymentDetail;

@Service
public interface PaymentService {
	
	public void savePayment(PaymentDetail payment);
	public PaymentDetail checkChildrenPresent(int childrenId);
	public void updatePayment(PaymentDetail payment);	

}
