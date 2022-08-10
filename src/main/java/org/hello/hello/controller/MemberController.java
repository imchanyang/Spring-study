package org.hello.hello.controller;

import org.hello.hello.domain.Member;
import org.hello.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// @Controller @Service @Respository
// Controller -> Service -> Repository : 보통 이렇게 연결함

// 컴포넌트 스
@Controller
// Controller로 해놓으면 스프링 컨테이너에 넣어서 관리된다.
public class MemberController {
    // 하나만 등록
    private final MemberService memberService;

    // Autowired는 스프링 컨테이너와 연결시켜주는 것(컨테이너에서 가져오는 것)
    // DI : Dependency Injection
    // DI (의존성 주입)의 타입은 필드 주입, setter 주입, 생성자 주입이 있는데
    // 밑에 있는 생성자 주입이 가장 좋다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }


}
