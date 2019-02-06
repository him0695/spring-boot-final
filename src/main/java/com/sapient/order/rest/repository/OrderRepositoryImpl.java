package com.sapient.order.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.Response;

import org.springframework.stereotype.Component;

import com.sapient.order.rest.dto.Order;

@Component
public class OrderRepositoryImpl implements IOrderRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(Order order) {
		entityManager.persist(order);

	}

	public void delete(int id) {
		// entityManager.remove(order);
		Order order = new Order();
		order.setId(id);
		entityManager.remove(entityManager.merge(order));

	}

	@Override
	public Order get(int id) {
		return entityManager.find(Order.class, id);
		
	}

	@Override
	public List<Order> getAll() {
		Query query=entityManager.createQuery("from orders");
		List<Order> orders=query.getResultList();
		return orders;
	}
}
