package com.example.demo.Member;

import java.nio.file.Path;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRes {
	private int id;
	private String profile;
	private String email;
	private String password;
	private String nickName;
	private LocalDateTime inserted;
	
}
