/**
 * Author: David Hoffmann
 * Created: 4/29/2020
 * Purpose: Bean object for orders that contain
 * all of the information for a customer order
 * to be persisted in the database.
 */
package beanobjects;

import beanobjects.Order;

public class Order {
	
	private Integer orderId;
	private String custFName;
	private String custLName;
	private String grade;
	private String addLineOne;
	private String addLineTwo;
	private String city;
	private String state;
	
	public Order() {
		super();
	}
	
	public Order(String custLName, Integer orderId) {
		super();
		this.custLName = custLName;
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getCustFName() {
		return custFName;
	}
	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}
	public String getCustLName() {
		return custLName;
	}
	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddLineOne() {
		return addLineOne;
	}
	public void setAddLineOne(String addLineOne) {
		this.addLineOne = addLineOne;
	}
	public String getAddLineTwo() {
		return addLineTwo;
	}
	public void setAddLineTwo(String addLineTwo) {
		this.addLineTwo = addLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
