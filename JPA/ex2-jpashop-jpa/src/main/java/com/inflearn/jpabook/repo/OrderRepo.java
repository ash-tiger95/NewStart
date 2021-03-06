package com.inflearn.jpabook.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.inflearn.jpabook.domain.Order;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepo {

	private final EntityManager em;
	
	public void save(Order order) {
		em.persist(order);
	}
	
	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}
	
	public List<Order> findAll(OrderSearch orderSearch){
		
		
		
		return em.createQuery("select o from Order o join o.member m" + 
					" where o.status = :status"+
					" and m.name like :name", Order.class)
						.setParameter("status", orderSearch.getOrderStatus())
						.setParameter("name", orderSearch.getMemberName())
						.setMaxResults(1000) // 최대 1000건
						.getResultList();
		// where문에 동적쿼리를 넣기가 어렵다. -> Qeurydsl를 사용하자
	}
	
}
