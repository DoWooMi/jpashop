package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository//스프링 빈으로 등록
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //JPA가 entity를 저장하는 로직
    public void save(Member member){
        em.persist(member);
    }

    //JPA가 제공하는 find메소드로 id값을 넘기면 member찾아서 반환
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //List 조회 (JPQL을 실행하기 위한 쿼리객체 생성 후 결과 반환)
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    //이름으로 회원을 검색하여 List 조회
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
