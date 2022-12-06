package com.shop.myapp.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.myapp.dto.MemberDTO;
import com.shop.myapp.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    HttpSession session;

    @RequestMapping(value="list", method = RequestMethod.GET)
    public String memberList(Model model) throws Exception {
        List<MemberDTO> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
        return "member/memberList";
    }

    /* 관리자 회원 정보 보기 */
    @RequestMapping(value="getMember", method = RequestMethod.GET)
    public String getMember(@RequestParam String id, Model model) throws Exception {
        MemberDTO member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "member/memberDetail";
    }

    /* 일반회원 정보보기 */
    @RequestMapping(value="read", method = RequestMethod.GET)
    public String memberRead(Model model, HttpServletRequest request) throws Exception {
        String id = (String) session.getAttribute("sid");
        MemberDTO member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "member/memberRead";
    }


    //회원 가입 - 약관 동의 페이지 로딩
    @GetMapping("agree")
    public String getAgree(Model model) throws Exception {
        return "member/agree";
    }
    //회원 가입 - 회원가입폼 페이지 로딩
    @GetMapping("join")
    public String getJoin(Model model) throws Exception {
        return "member/memberInsert";
    }
    //회원 가입 - Ajax로 아이디 중복 체크
    @RequestMapping(value="idCheck", method=RequestMethod.POST)
    public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        boolean result = false;
        MemberDTO dto = new MemberDTO();
        dto = memberService.getMember(id);

        if(dto!=null){	//이미 있는 아이디임
            result = false;
        } else {
            result = true;
        }
        JSONObject json = new JSONObject();
        json.put("result", result);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
    }

    //로그인 폼 로딩
    @RequestMapping("loginForm")
    public String memberLoginForm(Model model) throws Exception {
        return "member/loginForm";
    }

    //회원 탈퇴
    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String memberDelete(@RequestParam String id, Model model, HttpSession session) throws Exception {
        memberService.memberDelete(id);
        session.invalidate();
        return "redirect:/";
    }

    //로그아웃
    @RequestMapping("logout")
    public String memberLogout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}