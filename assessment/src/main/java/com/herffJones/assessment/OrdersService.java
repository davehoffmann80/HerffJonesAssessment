package com.herffJones.assessment;

import java.util.List;

import org.springframework.stereotype.Service;

import beanobjects.Order;

@Service
public interface OrdersService {
	
	List<Order> allOrders(String lName, Integer orderId);

}
