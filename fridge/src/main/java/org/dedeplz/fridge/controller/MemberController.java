package org.dedeplz.fridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dedeplz.fridge.model.MemberService;
import org.dedeplz.fridge.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;

	//회원가입form.jsp로
	@RequestMapping("member_registerForm.do")
	public ModelAndView registerForm() {
		return new ModelAndView("member_register_form", "memberVO",
				new MemberVO());
	}


	@RequestMapping("member_loginForm.do")
	public String loginForm() {
		return "member_login_form";
	}

	@RequestMapping("member_joinclause_view.do")
	public String joinClause(){
		return "member_joinclause_view";
	}
	//회원가입 (redirect)
	@RequestMapping(value = "member_register.do", method = RequestMethod.POST)
	public ModelAndView register(@Valid MemberVO vo, BindingResult result) {
		System.out.println(vo);
		if (result.hasErrors()) {
			return new ModelAndView("member_register_form");
		}
		memberService.registerMember(vo);
		return new ModelAndView("redirect:regiResult.do?id=" + vo.getId());
	}

	//회원가입완료
	@RequestMapping("regiResult.do")
	public ModelAndView regiResult(HttpServletRequest request,
			HttpServletResponse response, MemberVO vo) {
		MemberVO mvo = memberService.findById(vo.getId());
		return new ModelAndView("member_register_result", "mvo", mvo);
	}

	@RequestMapping("member_memberIdCheck.do")
	@ResponseBody
	public String idcheckAjax(HttpServletRequest request) {
		String id = request.getParameter("id");
		return memberService.idCheck(id);
	}
	
	//로그인
	@RequestMapping("login.do")
	public String login(MemberVO vo, HttpServletRequest request) {
		MemberVO mvo = memberService.login(vo);
		//System.out.println(mvo);
		if (mvo == null)
			return "member_login_fail";
		else {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);
			return "member_login_ok";
		}
	}

	@RequestMapping("member_logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "home";
	}

	@RequestMapping("member_myPage.do")
	public String myPage() {
		return "member_myPage";
	}

	@RequestMapping("member_updateMemberForm.do")
	public String updateMemberForm() {
		return "member_update_check_form";
	}

	@RequestMapping("member_deleteMemberForm.do")
	public String deleteMemberForm() {
		return "member_delete_check_form";
	}

	@RequestMapping("member_passwordCheck_delete.do")
	public String passwordCheckDelete(MemberVO vo) {
		System.out.println(vo.getPassword());
		System.out.println(vo.getId());
		MemberVO mvo = memberService.login(vo);
		if (mvo == null) {
			return "member_password_check_fail";
		} else
			memberService.deleteMember(mvo);
			return "member_passwordCheck_delete";
	}
}