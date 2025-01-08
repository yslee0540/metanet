package com.example.myapp.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myapp.hr.service.IEmpService;

@Controller
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping("/hr/count")
	public String empCount(Model model) {
		int result = empService.getEmpCount(); //biz() 호출
		model.addAttribute("count", result);
		return "hr/count"; //뷰
	}
}
