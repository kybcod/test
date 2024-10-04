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
}

