package com.ak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.PaymentDetail;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {

 public PaymentDetail findByChildrenId(int childrenId);
  
}
