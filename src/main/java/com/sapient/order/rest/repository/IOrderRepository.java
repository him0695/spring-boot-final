package com.sapient.order.rest.repository;

import java.util.List;

import com.sapient.order.rest.dto.Order;

public interface IOrderRepository {

	void save(Order order) throws Exception;
	void delete(int id);
	Order get(int id);
	List<Order> getAll();

}