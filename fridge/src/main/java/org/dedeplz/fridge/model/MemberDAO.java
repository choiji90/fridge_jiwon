package org.dedeplz.fridge.model;

public interface MemberDAO {
	public MemberVO findById(String id);
	public void registerMember(MemberVO vo);
	public String idCheck(String id);
	public MemberVO login(MemberVO vo);
	public MemberVO myPage();
	public void deleteMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public String nickCheck(String nick);
	public String findMyId(MemberVO vo);
	public String findMyPassword(MemberVO vo);
}