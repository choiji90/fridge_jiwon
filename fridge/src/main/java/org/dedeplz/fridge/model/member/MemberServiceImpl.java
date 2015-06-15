package org.dedeplz.fridge.model.member;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	/*@Resource
	private String uploadPath;*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dedeplz.fridge.model.MemberService#allMember()
	 */
	/**
	 * redirect를 통해 받아와 회원 아이디 중복 등록 불가능하게 함
	 */
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		return memberDAO.findById(id);
	}

	/**
	 * 회원등록
	 */
	@Override
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);
		/*File file=new File(uploadPath+vo.getId());
		file.mkdir();*/
	}

	/**
	 * 아이디 중복체크
	 */
	@Override
	public String idCheck(String id) {
		return memberDAO.idCheck(id);
	}

	/**
	 * 로그인
	 */
	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	/**
	 * 내정보보기
	 */
	@Override
	public MemberVO myPage() {
		return memberDAO.myPage();
	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	/**
	 * 회원정보수정
	 */
	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("updateServiceImpl");
		memberDAO.updateMember(vo);
	}

	/**
	 * 닉네임중복체크
	 */
	@Override
	public String nickCheck(String nick) {
		return memberDAO.nickCheck(nick);
	}

	/**
	 * 아이디찾기
	 */
	@Override
	public String findMyId(MemberVO vo) {
		return memberDAO.findMyId(vo);
	}

	/**
	 * 비밀번호찾기
	 */
	@Override
	public String findMyPassword(MemberVO vo) {
		return memberDAO.findMyPassword(vo);
	}
	
	/**
	 * 모든 회원 리스트뽑기
	 */
	 @Override
	   public ListVO getMemberList(String pageNo) {
	      if(pageNo==null||pageNo=="") 
	         pageNo="1";
	      List<MemberVO> list=memberDAO.getMemberList(pageNo);
	      int total=memberDAO.totalMember();
	  	System.out.println("total: "+total );
	      PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
	      ListVO lvo=new ListVO(list,paging);
	      return lvo;
	   }

	 /**
	  * 좋아요 수
	  */
	@Override
	public int loveCount(MemberVO vo) {
		System.out.println("좋아요수(service) : "+memberDAO.loveCount(vo));
		return memberDAO.loveCount(vo);
	}
	
	/** 좋아요 수에따른
	 * 자동 렙업
	 */
	@Override
	public void updateMemberGrade(MemberVO vo){
		memberDAO.updateMemberGrade(vo);
	}
}
