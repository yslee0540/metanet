package com.example.myapp.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.hr.model.Emp;
import com.example.myapp.hr.service.IEmpService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping("/hr/list")
	public List<Emp> getAllEmps() {
		return empService.getEmpList();
	}
	
	@GetMapping("/hr/{employeeId}")
	public ResponseEntity<Emp> getEmpInfo(@PathVariable int employeeId) {
		try {
			Emp emp = empService.getEmpInfo(employeeId);
			return ResponseEntity
				.ok()
				.eTag("\"" + emp.hashCode() + "\"")
				.body(emp);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/hr/insert")
	public void insertEmp(@RequestBody Emp emp) {
		empService.insertEmp(emp);
	}
	
	@PutMapping("/hr/update/{employeeId}")
	public void updateEmp(@PathVariable int employeeId, @RequestBody Emp emp) {
		try {
			emp.setEmployeeId(employeeId);
			empService.updateEmp(emp);
		} catch (RuntimeException e) {
		}
	}
	
	@DeleteMapping("/hr/delete")
	public ResponseEntity<Void> deleteEmp(@RequestBody Emp emp) {
		try {
			int deleteRow = empService.deleteEmp(emp.getEmployeeId(), emp.getEmail());
			if (deleteRow > 0) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ExceptionHandler({RuntimeException.class})
	public String runtimeException(HttpServletRequest request, Exception ex, Model model) {
		model.addAttribute("exception", ex);
		model.addAttribute("url", request.getRequestURL());
		return "error/runtime";
	}
}
