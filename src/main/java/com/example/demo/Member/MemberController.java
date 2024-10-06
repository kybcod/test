package com.example.demo.Member;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join")
	public String joinMember(Member member, @RequestParam("file") MultipartFile profile) throws IOException {
		memberService.insert(member, profile);
		return "redirect:/";
	}
	
	@GetMapping("/member/list")
	public String memberList(Member member, Model model) {
		model.addAttribute("memberList", memberService.list());
		return "list";
	};
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		member = memberService.getSelectOne(member);
		if (member != null) {
			session.setAttribute("member", member);
		}
		return "redirect:/";
	}
	
}

