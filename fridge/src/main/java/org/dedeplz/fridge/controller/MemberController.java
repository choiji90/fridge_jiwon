package org.dedeplz.fridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
   
   @RequestMapping("member_registerForm.do")
   public ModelAndView registerForm(){	
		return new ModelAndView("member_register_form","memberVO",new MemberVO());
   }

   @RequestMapping(value="member_register.do",method=RequestMethod.POST)
	public ModelAndView register(@Valid MemberVO vo,BindingResult result){
		if(result.hasErrors()){
			return new ModelAndView("member_register_form"); 
		}
		  memberService.registerMember(vo);
		   return new ModelAndView("redirect:regiResult.do?id="+vo.getId());
	}
   @RequestMapping("regiResult.do")
   public ModelAndView regiResult(HttpServletRequest request, 
			HttpServletResponse response,MemberVO vo){
		MemberVO mvo = memberService.findById(vo.getId());
		return new ModelAndView("member_register_result","mvo",mvo);
	}

	@RequestMapping("member_memberIdCheck.do")
	@ResponseBody
	public String idcheckAjax(HttpServletRequest request) {		
		String id=request.getParameter("id");
		return memberService.idCheck(id);
	}
   
}