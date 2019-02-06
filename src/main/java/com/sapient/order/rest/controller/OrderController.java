package com.sapient.order.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.order.rest.dto.Order;
import com.sapient.order.rest.services.IOrderService;

@RestController("/orders")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IOrderService orderService;

//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public void createOrder(@RequestBody Order order) {
		logger.info("creating order...{}", order);

		try {
			orderService.processOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@DeleteMapping("/orders/{id}")
//	public ResponseEntity delete(@PathVariable int id) {
//		ResponseEntity responseEntity;
//		logger.info("deleting order..." + id);
//		try {
//			orderService.deleteOrder(id);
//			responseEntity = new ResponseEntity(HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
//
//		}
//		return responseEntity;
//	}
//
	@GetMapping("/orders/{id}")
	public ResponseEntity<Optional<Order>> get(@PathVariable int id) {
		// return orderService.get(id);
//		ResponseEntity<String> responseEntity=new ResponseEntity<>();
//		return responseEntity;
		
		Optional<Order> order=orderService.get(id);
		if(order==null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok().header("himanshu", "jkfh").body(order);
	}
//
	@GetMapping("/orders")
	public List<Order> getAllOrder() {
		return orderService.getAll();

	}
}
