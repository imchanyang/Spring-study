package org.hello.hello.repository;

import org.hello.hello.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring Data JPA가 자송으로 스프링 빈으로 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 이거는 비즈니스가 달라서 JPA에서 공통으로 제공하는 메서드가 아니다.
    // select m from Member m where m.name = ? : JPQL
    // And, Or 이런 것도 있음
    // 이렇게하면 개발 끝.ㅓ
    @Override
    Optional<Member> findByName(String name);
}
