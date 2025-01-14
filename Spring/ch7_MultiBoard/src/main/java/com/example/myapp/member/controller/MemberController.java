package com.example.myapp.member.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.member.model.Member;
import com.example.myapp.member.service.IMemberService;

@Controller
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IMemberService memberService;
	
	@GetMapping("/member/insert")
	public String insertMember(HttpSession session, Model model) {
		String csrfToken = UUID.randomUUID().toString();
		session.setAttribute("csrfToken", csrfToken);
		logger.info("/member/insert, GET", csrfToken);
		model.addAttribute("member", new Member());
		return "member/form";
	}
	
	@PostMapping("/member/insert")
	public String insertMember(Member member, String csrfToken, HttpSession session, Model model) {
		String sessionToken = (String) session.getAttribute("csrfToken");
		if (csrfToken == null || !csrfToken.equals(sessionToken)) {
			throw new RuntimeException("CSRF Token Error");
		}
		try {
			if (!member.getPassword().equals(member.getPassword2())) {
				model.addAttribute("member", member);
				model.addAttribute("message", "MEMBER_PW_RE");
				return "member/form";
			}
			memberService.insertMember(member);
		} catch (DuplicateKeyException e) {
			member.setUserid(null);
			model.addAttribute("member", member);
			model.addAttribute("message", "ID_ALREADY_EXIST");
			return "member/form";
		}
		session.invalidate();
		return "redirect:/board/cat/1/";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(String userid, String password, HttpSession session, Model model) {
		Member member = memberService.selectMember(userid);
		if (member != null) {
			logger.info(member.toString());
			String dbpw = member.getPassword();
			if (dbpw.equals(password)) {
				session.setMaxInactiveInterval(600);
				session.setAttribute("userid", userid);
				session.setAttribute("name", member.getName());
				session.setAttribute("email", member.getEmail());
			} else {
				session.invalidate();
				model.addAttribute("message", "WRONG_PASSWORD");
			}
		} else {
			session.invalidate();
			model.addAttribute("message", "USER_NOT_FOUND");
		}
		return "member/login";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/cat/1/";
	}
	
}
