package com.example.demo.Member;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Member {
	private int id;
	private String profile;
	private String email;
	private String password;
	private String nickName;
	private LocalDateTime inserted;
	
}
