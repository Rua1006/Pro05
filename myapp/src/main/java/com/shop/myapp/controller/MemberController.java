package com.shop.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.myapp.dto.MemberDTO;
import com.shop.myapp.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private final MemberService memberService;
	
	@GetMapping
    public String root() {
        return "redirect:/login";
    }
	
    //로그인 폼 @return
    @GetMapping("/login")
    public String login(MemberDTO member, Model model){
    	model.addAttribute("member", member);
        return "member/login";
    }

    //로그인 성공 페이지 @param model @param authentication @return
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        MemberDTO member = (MemberDTO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", member.getUserId() +"의 "+ member.getUserName()+ "님");      //유저 아이디
        return "member/user_access";
    }
    
    //로그인 실패 폼 @return
    @GetMapping("/login_denied")
    public String loginDenied() {
        return "member/login_denied";
    }

    //회원가입 폼 @return
    @GetMapping("/signUp")
    public String signUpForm(MemberDTO member, Model model) {
    	model.addAttribute("member", member);
        return "member/join";
    }
    
    //회원가입 진행 @param MemberDTO @return
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("member") MemberDTO member) {
        memberService.joinUser(member);
        return "redirect:/member/login";
    }
    
    //회원정보 폼 @return
    @GetMapping("/info")
    public String infoForm(Authentication authentication, Principal principal, Model model) {
    	UserDetails user = (UserDetails) authentication.getPrincipal();
    	String userId = user.getUsername();
    	MemberDTO member = memberService.getUserAccount(userId);
    	model.addAttribute("member", member);
        return "member/info";
    }
    
    //회원정보 수정 진행 @param MemberDTO @return
    @PostMapping("/update")
    public String update(@ModelAttribute("member") MemberDTO member) {
        memberService.updateUser(member);
        return "redirect:/";
    }
}