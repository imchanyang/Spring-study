//package org.battles.battles;
//
//import org.battles.battles.repository.MemberRepository;
//import org.battles.battles.repository.MemoryMemberRepository;
//import org.battles.battles.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    //수동으로 스프링 빈에 등록
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//}
