package com.example.demo.Member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MemberMapper {

	@Insert("INSERT INTO member (profile, email, password, nick_name) VALUES (#{profile}, #{email}, #{password}, #{nickName})")
	void insert(Member member);

	@Select("SELECT * FROM member")
	List<Member> selectMemberAll();
}
