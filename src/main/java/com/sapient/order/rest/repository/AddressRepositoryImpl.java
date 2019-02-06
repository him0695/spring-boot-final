package com.sapient.order.rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;

@Repository
public class AddressRepositoryImpl implements IAddressRepository {

	@PersistenceContext
	EntityManager entityManager; // synonymous to session in hibernate

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(Address address) {
		entityManager.persist(address);

	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(id);

	}

}
