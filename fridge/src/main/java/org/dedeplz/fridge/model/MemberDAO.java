package org.dedeplz.fridge.model;

public interface MemberDAO {
	public MemberVO findById(String id);

	public void registerMember(MemberVO vo);

	public String idCheck(String id);

}