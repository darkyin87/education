package com.ak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
	
	

}
