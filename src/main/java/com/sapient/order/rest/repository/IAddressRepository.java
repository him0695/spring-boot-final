package com.sapient.order.rest.repository;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;

public interface IAddressRepository {
	void save(Address address);
	void delete(int id);
}