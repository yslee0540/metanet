package com.example.myapp.hr.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.myapp.hr.controller.EmpController;

@Component
public class EmpAssembler implements RepresentationModelAssembler<Emp, EntityModel<Emp>> {

	@Override
	public EntityModel<Emp> toModel(Emp emp) {
		return EntityModel.of(emp,
				linkTo(methodOn(EmpController.class).getEmpInfo(emp.getEmployeeId())).withSelfRel(),
				linkTo(methodOn(EmpController.class).getAllEmps()).withRel("emps")
				);
	}
	
}
