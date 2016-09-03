package com.ak.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.Testimonial;
import com.ak.repository.TestimonialRepository;


@Service
public class TestimonialServiceImpl implements TestimonialService{
	
	@Resource
	private TestimonialRepository testminialRepository;

	@Override
	public void save(Testimonial testimonial) {
		testminialRepository.save(testimonial);
		
	}

}
