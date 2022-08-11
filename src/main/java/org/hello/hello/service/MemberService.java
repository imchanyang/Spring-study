package org.hello.hello.service;

import org.hello.hello.domain.Member;
import org.hello.hello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// 이거해줘야 Controller에서 컨테이녀 언결 할 수 있음

// 커맨드 쉬프트 T : 테스트 코드 작성

// JPA쓰려면 필요
// 데이터를 저장 혹은 변경할 때 필요
@Transactional
public class MemberService {
    // 바꾸자!
    private final MemberRepository memberRepository;

    // DI : Dependency Injection

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join (Member member) {
        // 같은 이름이 있는 중복 회원이 있으면 안된다
        // 커맨드 옵션 v
        // 컨트롤 T
        validataeDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validataeDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());

        result.ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 단일 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
