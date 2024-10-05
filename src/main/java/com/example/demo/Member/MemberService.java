package com.example.demo.Member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
	
	public void insert(Member member, MultipartFile profile) throws IOException {
		
		String profileDir = "C:\\upload_data\\temp";
		
		// 경로가 존재하지 않으면 생성
	    File directory = new File(profileDir);
	    if (!directory.exists()) {
	        directory.mkdirs(); // 모든 경로의 부모 디렉토리도 생성
	    }
		
		if(!profile.isEmpty()) {
			String fileName = profile.getOriginalFilename();
			File saveFile = new File(profileDir, fileName);
			profile.transferTo(saveFile);
			member.setProfile(fileName);
		}
		memberMapper.insert(member);
	}

	public List<Member> list() {
        List<Member> members = memberMapper.selectMemberAll();
        for (Member member : members) {
            String profileFileName = member.getProfile();
            if (profileFileName != null && !profileFileName.isEmpty()) {
                String profileUrl = "/profile/" + profileFileName; // 리소스 핸들러에서 설정한 경로에 맞게
                member.setProfile(profileUrl);
            }
        }
        return members;
    }

}
