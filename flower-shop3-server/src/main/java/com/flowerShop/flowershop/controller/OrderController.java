package com.flowerShop.flowershop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flowerShop.flowershop.model.Orders;
import com.flowerShop.flowershop.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Orders addOrder(@RequestBody Orders order) throws ValidationException {
		return orderRepository.save(order);

	}

	@GetMapping("/{id_order}")
	public Orders getOrderById(@PathVariable("id_order") int idOrder) {
		return orderRepository.getOne(idOrder);
	}

	@GetMapping("/user/{email}")
	public List<Orders> getOrderByUser(@PathVariable("email") String clientEmail) {
		List<Orders> orders = getAllOrders();
		List<Orders> userOrders = new ArrayList<>();
		for (Orders order : orders) {
			if (order.getUserEmail().equals(clientEmail)) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}

	@DeleteMapping("/delete/{id_order}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id_order") Integer id_order) {
		Orders order = orderRepository.getOne(id_order);
		orderRepository.delete(order);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/product/{id_product}")
	public List<Orders> getOrderByProduct(@PathVariable("id_product") int idProduct) {
		List<Orders> orders = getAllOrders();
		List<Orders> productOrders = new ArrayList<>();
		for (Orders order : orders) {
			if (order.getProductId() == idProduct) {
				productOrders.add(order);
			}
		}
		return productOrders;
	}

}
