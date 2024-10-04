package com.example.demo.Member;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;


@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper memberMapper;

	@Value("${file.upload-dir}")
	private String profileDir;
	
	public void insert(Member member, MultipartFile profile) throws IOException {
		if(!profile.isEmpty()) {
			String fileName = profile.getOriginalFilename();
			Path filePath = Paths.get(profileDir, fileName);
			Files.copy(profile.getInputStream(), filePath);
			member.setProfile(fileName);
		}
		memberMapper.insert(member);
	}

}
