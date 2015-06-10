package org.dedeplz.fridge.model;

import java.util.List;

public interface MemberService {

	public  MemberVO findById(String id);
	public void registerMember(MemberVO vo);
	public String idCheck(String id);
	public MemberVO login(MemberVO vo);
	public MemberVO myPage();
	public void deleteMember(MemberVO vo);
}