package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.SampleDTO;

public interface SampleService {
	List<SampleDTO> getSample();
	List<SampleDTO> findAll();
}
