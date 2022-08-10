package org.battles.battles.repository;

import org.battles.battles.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//이것도 해줘야함
@Repository
public interface MemberRepository {
    Member save(Member member);
    // null 때문에
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();



}
