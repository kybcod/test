package com.example.demo.Member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MemberMapper {

	@Insert("INSERT INTO member (profile, email, password, nick_name) VALUES (#{profile}, #{email}, #{password}, #{nickName})")
	void insert(Member member);
}
