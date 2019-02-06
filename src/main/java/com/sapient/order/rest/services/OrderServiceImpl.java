package com.sapient.order.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;
import com.sapient.order.rest.repository.IAddressRepository;
import com.sapient.order.rest.repository.IOrderJPARepository;
import com.sapient.order.rest.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IAddressRepository addressRepositoryImpl;
	@Autowired
	private IOrderJPARepository orderRepositoryImpl;
	


	public OrderServiceImpl() {
		System.out.println("OrderServiceImpl bean created");
	}

	/**
	 * 
	 * @param order
	 * @return order id
	 * @throws Exception
	 */
//	@Transactional(rollbackOn = Exception.class, dontRollbackOn = IllegalAccessException.class)
	@Transactional
	public int processOrder(Order order) throws Exception {

		orderRepositoryImpl.save(order);
		Address address = new Address();
		address.setHouseNumber("whitefield");
		address.setPin(22222);
		addressRepositoryImpl.save(address);

		return order.getId();
	}
//
//	@Transactional
//	public void deleteOrder(int id) {
//		orderRepositoryImpl.delete(id);
//
//	}
//
//
	@Override
	public Optional<Order> get(int id) {
		return orderRepositoryImpl.findById(id);
		
	}
//
	@Override
	public List<Order> getAll() {
		
		return orderRepositoryImpl.findAll();
	}
}
