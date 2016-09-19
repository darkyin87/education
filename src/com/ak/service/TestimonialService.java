package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import com.ak.model.Testimonial;




public interface TestimonialService {
	public void save(Testimonial children);

	public List<Testimonial> getAll();
}
