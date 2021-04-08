package com.inflearn;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// === 문제점 예시 ===
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team); // 영속 컨텍스트에 올라가면서 1차 캐시가 ID를 기억한다.
			
			Member member = new Member();
			member.setUsername("member1");
			
			// member를 team에 소속시키고 싶을 때
			member.setTeamId(team.getId()); // 객체지향적이지가 않다. (setTeam()으로 해야될 것 같은데.)
			em.persist(member);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
