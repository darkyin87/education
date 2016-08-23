package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ak.model.Children;

public interface ChildrenRepository extends JpaRepository<Children, Long> {
	
	
	public List<Children> findAll();
	
	 @Query(value = "select  c.childrenId,c.picture ,sum(p.DonationAmt) as donationAmount from children c" +
	" inner join PAYMENTDETAIL p on c.childrenId = p.childrenId group by p.childrenId",nativeQuery=true)
	public List<Object[]> findWithDonation();
	 

	
	

}
