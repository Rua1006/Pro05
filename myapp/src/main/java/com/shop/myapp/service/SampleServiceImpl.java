package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dto.SampleDTO;
import com.shop.myapp.dao.SampleDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	
	private final SampleDAO sampleMapper; 

	@Override
	public List<SampleDTO> getSample() {
		return sampleMapper.getSample();
	}

	@Override
	public List<SampleDTO> findAll() {
		return sampleMapper.findAll();
	}
}
