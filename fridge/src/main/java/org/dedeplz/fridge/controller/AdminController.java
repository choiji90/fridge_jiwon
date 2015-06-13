package org.dedeplz.fridge.controller;

import javax.annotation.Resource;

import org.dedeplz.fridge.model.MemberService;
import org.dedeplz.fridge.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Resource
	private MemberService memberService;
	/**
	 * 관리자 페이지 폼으로 
	 */
	 @RequestMapping("admin_adminpage.do")
     public ModelAndView showAdminPage(String pageNo){
        System.out.println("관리자 페이지");
        return new ModelAndView ("admin_adminpage","lvo",memberService.getMemberList(pageNo));
     }

	 /**
	  * 강퇴 확인
	  *//*
	 @RequestMapping("admin_outMember.do")
	 public String outMember_check(){
		 return "admin_outMember";
	 }*/
	 

	 /**
	  * 강퇴
	  * @param vo
	  * @return
	  */
	  @RequestMapping("admin_outMember.do")
	     public String outMemeber(MemberVO vo ){
//	        System.out.println("admin_delete"+vo);
	        memberService.deleteMember(vo);
	        return "redirect:admin_adminpage.do";
	     }
}