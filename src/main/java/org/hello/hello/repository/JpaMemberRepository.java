package org.hello.hello.repository;

import org.hello.hello.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // Jpa는 EntityManager로 동작
    private final EntityManager em;

    // Injection
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // pk기반이 아니라서..
    @Override
    public Optional<Member> findByName(String name) {
        //JPQL
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //JPQL
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
