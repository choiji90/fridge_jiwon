package org.dedeplz.fridge.model;

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
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		return memberDAO.findById(id);
	}

	@Override
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);
		/*File file=new File(uploadPath+vo.getId());
		file.mkdir();*/
	}

	@Override
	public String idCheck(String id) {
		return memberDAO.idCheck(id);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	@Override
	public MemberVO myPage() {
		return memberDAO.myPage();
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("updateServiceImpl");
		memberDAO.updateMember(vo);
	}

	@Override
	public String nickCheck(String nick) {
		return memberDAO.nickCheck(nick);
	}

	@Override
	public String findMyId(MemberVO vo) {
		return memberDAO.findMyId(vo);
	}

	@Override
	public String findMyPassword(MemberVO vo) {
		return memberDAO.findMyPassword(vo);
	}
	
	 @Override
	   public ListVO getMemberList(String pageNo) {
	      if(pageNo==null||pageNo=="") 
	         pageNo="1";
	      List<MemberVO> list=memberDAO.getMemberList(pageNo);
	      int total=memberDAO.totalContent();
	      PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
	      ListVO lvo=new ListVO(list,paging);
	      return lvo;
	   }

	@Override
	public int loveCount(MemberVO vo) {
		System.out.println("좋아요수(service) : "+memberDAO.loveCount(vo));
		return memberDAO.loveCount(vo);
	}
	@Override
	public void updateMemberGrade(MemberVO vo){
		memberDAO.updateMemberGrade(vo);
	}
}
