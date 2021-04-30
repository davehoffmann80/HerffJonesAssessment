package com.herffJones.assessment;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import beanobjects.Order;
import dataconnection.DBConnection;

@RestController
public class OrderController implements OrdersService {
	
	private static Order confOrder = new Order();
	
	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public Model getOrder(@RequestParam(value = "lname", required = false) String lname, @RequestParam(value = "orderid", required = false) Integer orderid, Model model) {
		
		if (orderid == null) {
			orderid = 0;
		}
		
		model.addAttribute("orders", allOrders(lname, orderid));

		return model;

	}

	@Override
	public List<Order> allOrders(String lName, Integer orderId){

		Order order = new Order(lName, orderId);

		List<Order> orders = DBConnection.getOrderByLastNameOrderId(order);

		return orders;
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public Model getCreateOrder( Model model) {
		
		return model;

	}
	
	@RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
	public RedirectView createOrder(@ModelAttribute Order order, @RequestParam(value = "lname", required = false) String lname, @RequestParam(value = "orderid", required = false) Integer orderid, Model model) {
		
		
		
		DBConnection.insertOrder(order);
		
		Order order1 = DBConnection.getOrderByFirstLastName(order);
		
		returnConfirmOrder(order1);

		return new RedirectView("/confirmation");

	}
	
	
	public Order returnConfirmOrder(Order order) {

		confOrder = order;
		
		return confOrder;

	}
	
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public Model confirmOrder(Model model) {
		
		model.addAttribute("order", allOrders(confOrder.getCustLName(), confOrder.getOrderId()));
		
		return model;
		
	}
	
}
