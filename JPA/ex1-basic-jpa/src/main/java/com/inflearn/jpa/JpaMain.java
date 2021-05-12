package com.inflearn.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.inflearn.jpa.domain.Member;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			// 영속
			Member findMember1 = em.find(Member.class, 101L);
			Member findMember2 = em.find(Member.class, 101L);
			
			System.out.println("result = " + (findMember1 == findMember2));

			tx.commit(); // DB에 쿼리가 날라간다.
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();

	}
}