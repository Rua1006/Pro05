package com.shop.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.myapp.dto.SampleDTO;
import com.shop.myapp.service.SampleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SampleController {

	SampleService sampleService;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello Spring Boot Test1";
	}
	
	@GetMapping("/sample")
	@ResponseBody
	public List<SampleDTO> getSample() {
		return sampleService.getSample();
	}

	@GetMapping("/test4")
	public String getThy2(Model model){
		SampleDTO sample = new SampleDTO("KBS", "888");
		model.addAttribute("sample", sample);
		return "test4";
	}

	@GetMapping("/test7")
	public String getThy5(Model model){
		List<SampleDTO> sampleList = sampleService.findAll();
		model.addAttribute("sampleList", sampleList);
		return "test7";
	}

	@GetMapping("/test8")
	public String getThy6(Model model){
		SampleDTO sample = new SampleDTO("KBS", "555");
		List<String> genderList = new ArrayList<String>();
		genderList.add("M");
		genderList.add("F");
		model.addAttribute("gender", "F");
		model.addAttribute("genderList",genderList);
		model.addAttribute("sample", sample);
		return "test8";
	}
}
