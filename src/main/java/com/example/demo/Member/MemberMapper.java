package com.example.demo.Member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	@Insert("INSERT INTO member (email, password, nick_name) VALUES (#{email}, #{password}, #{nickName})")
	void insert(Member member);
}
