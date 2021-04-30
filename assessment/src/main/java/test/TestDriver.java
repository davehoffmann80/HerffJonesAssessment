///**
// * Author: David Hoffmann
// * Created: 4/29/2020
// * Purpose: This file is a test driver to test and demonstrate CRUD operations
// * through the custom JDBC DB Connection utility. This whole file will be commented
// * out when built into the JEE web app. If used the methods need to be updated to the
// * proper methods from the updated DBConnection.java file.
// */
//
//package testDriver;
//
//import java.util.List;
//
//import beanObjects.Order;
//import dataConnection.DBConnection;
//
//public class TestDriver {
//
//	public static void main(String[] args) {
//		// getOrders();
//
//		// getOneOrder(1);
//		// getOneOrder(2);
//		// getOneOrder(3);
//		
//		// executeInsertOrder();
//		
//		// executeRemoveOrder(1);
//		
//		// executeUpdateOrder();
//	}
//
//	@SuppressWarnings("unused")
//	private static void executeUpdateOrder() {
//		Order order = new Order();
//		order.setCustFName("Sarah");
//		order.setCustLName("NoTest");
//		order.setGrade("8");
//		order.setProduct("YearBook");
//		order.setQuantity(1);
//		order.setAddLineOne("100 Huckabee Ave.");
//		order.setAddLineTwo(null);
//		order.setCity("RockVille");
//		order.setState("TN");
//		
//		updateOrder(order);
//		
//	}
//	
//	private static void updateOrder(Order order) {
//		DBConnection.updateOrder(order);
//	}
//
//	@SuppressWarnings("unused")
//	private static void executeRemoveOrder(int id) {
//		Order order = new Order();
//		
//		order.setId(id);
//		
//		removeOrder(order);
//	}
//
//	private static void removeOrder(Order order) {
//		DBConnection.removeOrderById(order);
//	}
//
//	
//
//	@SuppressWarnings("unused")
//	private static void getOrders() {
//		List<Order> orders = DBConnection.getAllOrders();
//
//		for (Order o : orders) {
//			System.out.println(o.toString());
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private static void getOneOrder(int id) {
//		Order order = DBConnection.getOrderById(id);
//
//		if (order.getId() == null) {
//			System.out.println("No customer by that ID exists! Try again.");
//		} else {
//			System.out.println(order.toString());
//		}
//
//	}
//	
//	@SuppressWarnings("unused")
//	private static void executeInsertOrder() {
//		Order order = new Order();
//		order.setCustFName("Sarah");
//		order.setCustLName("NoTest");
//		order.setGrade("8");
//		order.setProduct("YearBook");
//		order.setQuantity(1);
//		order.setAddLineOne("837 Colorado Ave.");
//		order.setAddLineTwo(null);
//		order.setCity("Indianapolis");
//		order.setState("IN");
//		
//		setOrder(order);
//	}
//	
//	private static void setOrder (Order order) {
//		DBConnection.setOrder(order);
//	}
//
//}
