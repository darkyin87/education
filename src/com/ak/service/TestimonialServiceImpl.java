package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.Testimonial;
import com.ak.repository.TestimonialRepository;


@Service
public class TestimonialServiceImpl implements TestimonialService{
	
	@Resource
	private TestimonialRepository testmonialRepository;

	@Override
	public void save(Testimonial testimonial) {
	    testmonialRepository.save(testimonial);
		
	}

    @Override
    public List<Testimonial> getAll() {
        return testmonialRepository.findAll();
    }

}
