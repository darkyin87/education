package com.ak.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.PaymentDetail;
import com.ak.repository.PaymentDetailRepository;
@Service

public class PaymentServiceImpl implements PaymentService{
	
	@Resource
    private PaymentDetailRepository paymentDetailRepository;

	@Override
	public void savePayment(PaymentDetail payment) {
		// TODO Auto-generated method stub
		PaymentDetail payments = paymentDetailRepository.save(payment);
		
	}

	@Override
	public PaymentDetail checkChildrenPresent(int childrenId) {
		// TODO Auto-generated method stub
		PaymentDetail payment = paymentDetailRepository.findByChildrenId(childrenId);
		return payment;
		
	}

	@Override
	public void updatePayment(PaymentDetail payment) {
		// TODO Auto-generated method stub
		PaymentDetail payments = paymentDetailRepository.save(payment);
		System.out.println(" done updating");
	}
	

}
