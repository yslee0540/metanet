package com.example.myapp.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.myapp.controller.MemberController;

@Component
public class MemberModelAssembler implements RepresentationModelAssembler<Member, EntityModel<Member>> {

	@Override
	public EntityModel<Member> toModel(Member member) {
		return EntityModel.of(member,
				linkTo(methodOn(MemberController.class).getMemberById(member.getId())).withSelfRel(),
				linkTo(methodOn(MemberController.class).getAllMembers()).withRel("members"),
				linkTo(methodOn(MemberController.class).updateMember(member.getId(), member)).withRel("update"),
				linkTo(methodOn(MemberController.class).deleteMember(member.getId())).withRel("delete")
				);
	}
	
}
