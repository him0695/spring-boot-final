package com.sapient.order.rest.services;

import java.util.List;
import java.util.Optional;

import com.sapient.order.rest.dto.Order;

public interface IOrderService {
	int processOrder(Order order) throws Exception;
//	void deleteOrder(int id);
	Optional<Order> get(int id);
	List<Order> getAll();
}
