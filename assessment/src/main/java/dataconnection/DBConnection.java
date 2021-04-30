/**
 * Author: David Hoffmann
 * Created: 4/29/2020
 * Purpose: This file handles the connection to an azure cloud 
 * database and performs the CRUD operations for creating, replacing, 
 * updating, and deleting order data
 */
package dataconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beanobjects.Order;

public class DBConnection {

	// Declare the connection to the azure database
	static String connectionString = "jdbc:sqlserver://hjassess.database.windows.net:1433;database=HJAssessment;user=dhoff80@hjassess;password=80#newdave80;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

	// Declare the JDBC objects.
	static Connection conn = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	static PreparedStatement preparedStmnt = null;

	// Returns all orders by the last name and order id of the customer by passing the order object
	public static List<Order> getOrderByLastNameOrderId(Order order1) {
		List<Order> orders = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(connectionString);

			preparedStmnt = conn
					.prepareStatement("SELECT * FROM [Order] WHERE OrderId = ? AND CustomerLastName = ?");

			preparedStmnt.setInt(1, order1.getOrderId());
			preparedStmnt.setString(2, order1.getCustLName());

			ResultSet rs = preparedStmnt.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("OrderId"));
				order.setCustFName(rs.getString("CustomerFirstName"));
				order.setCustLName(rs.getString("CustomerLastName"));
				order.setGrade(rs.getString("Grade"));
				order.setAddLineOne(rs.getString("Address1"));
				order.setAddLineTwo(rs.getString("Address2"));
				order.setCity(rs.getString("City"));
				order.setState(rs.getString("State"));

				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connections after the data has been handled.
			if (preparedStmnt != null)
				try {
					preparedStmnt.close();
				} catch (Exception e) {
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}

		return orders;
	}
	
	// Returns all orders by the last name and order id of the customer by passing the order object
		public static Order getOrderByFirstLastName(Order order1) {
			List<Order> orders = new ArrayList<>();

			try {
				conn = DriverManager.getConnection(connectionString);

				preparedStmnt = conn
						.prepareStatement("SELECT * FROM [Order] WHERE CustomerFirstName = ? AND CustomerLastName = ?");

				preparedStmnt.setString(1, order1.getCustFName());
				preparedStmnt.setString(2, order1.getCustLName());

				ResultSet rs = preparedStmnt.executeQuery();

				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("OrderId"));
					order.setCustFName(rs.getString("CustomerFirstName"));
					order.setCustLName(rs.getString("CustomerLastName"));
					order.setGrade(rs.getString("Grade"));
					order.setAddLineOne(rs.getString("Address1"));
					order.setAddLineTwo(rs.getString("Address2"));
					order.setCity(rs.getString("City"));
					order.setState(rs.getString("State"));

					orders.add(order);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// Close the connections after the data has been handled.
				if (preparedStmnt != null)
					try {
						preparedStmnt.close();
					} catch (Exception e) {
					}
				if (resultSet != null)
					try {
						resultSet.close();
					} catch (Exception e) {
					}
				if (statement != null)
					try {
						statement.close();
					} catch (Exception e) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e) {
					}
			}
				
			Order order = orders.get(orders.size()-1);
		
			return order;
		}
		
		// Returns all orders by the last name and order id of the customer by passing the order object
				public static List<Order> getOrderByLastName(Order order1) {
					List<Order> orders = new ArrayList<>();

					try {
						conn = DriverManager.getConnection(connectionString);

						preparedStmnt = conn
								.prepareStatement("SELECT * FROM [Order] WHERE CustomerLastName = ?");

						preparedStmnt.setString(1, order1.getCustFName());
						preparedStmnt.setString(2, order1.getCustLName());

						ResultSet rs = preparedStmnt.executeQuery();

						while (rs.next()) {
							Order order = new Order();
							order.setOrderId(rs.getInt("OrderId"));
							order.setCustFName(rs.getString("CustomerFirstName"));
							order.setCustLName(rs.getString("CustomerLastName"));
							order.setGrade(rs.getString("Grade"));
							order.setAddLineOne(rs.getString("Address1"));
							order.setAddLineTwo(rs.getString("Address2"));
							order.setCity(rs.getString("City"));
							order.setState(rs.getString("State"));

							orders.add(order);
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						// Close the connections after the data has been handled.
						if (preparedStmnt != null)
							try {
								preparedStmnt.close();
							} catch (Exception e) {
							}
						if (resultSet != null)
							try {
								resultSet.close();
							} catch (Exception e) {
							}
						if (statement != null)
							try {
								statement.close();
							} catch (Exception e) {
							}
						if (conn != null)
							try {
								conn.close();
							} catch (Exception e) {
							}
					}
				
					return orders;
				}

	// Insert an order by passing the order object
	public static void insertOrder(Order order) {

		try {
			conn = DriverManager.getConnection(connectionString);

			preparedStmnt = conn.prepareStatement("INSERT INTO [Order] VALUES (?, ?, ?, ?, ?, ?, ?)");

			preparedStmnt.setString(1, order.getCustFName());
			preparedStmnt.setString(2, order.getCustLName());
			preparedStmnt.setString(3, order.getGrade());
			preparedStmnt.setString(4, order.getAddLineOne());
			preparedStmnt.setString(5, order.getAddLineTwo());
			preparedStmnt.setString(6, order.getCity());
			preparedStmnt.setString(7, order.getState());

			int i = preparedStmnt.executeUpdate();

			if (i == 0) {
				System.out.println("No records were inserted!");
			} else {
				System.out.println(i + " record(s) were inserted successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connections after the data has been handled.
			if (preparedStmnt != null)
				try {
					preparedStmnt.close();
				} catch (Exception e) {
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	// Delete an order by ID
	public static void removeOrderById(int id) {
		try {
			conn = DriverManager.getConnection(connectionString);

			preparedStmnt = conn
					.prepareStatement("DELETE FROM [Order] WHERE Id = ?");

			preparedStmnt.setInt(1, id);

			int i = preparedStmnt.executeUpdate();

			if (i == 0) {
				System.out.println("No records were deleted!");
			} else {
				System.out.println(i + " record(s) were deleted successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connections after the data has been handled.
			if (preparedStmnt != null)
				try {
					preparedStmnt.close();
				} catch (Exception e) {
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	// Update an order by first and last name from passing the order object
	public static void updateOrderByFirstLastName(Order order) {

		try {
			conn = DriverManager.getConnection(connectionString);

			preparedStmnt = conn.prepareStatement(
					"UPDATE [Order] SET CustomerFirstName = ?, CustomerLastName = ?, Grade = ?, Address1 = ?, Address2 = ?, City = ?, State = ?, ZipCode = ? WHERE CustomerFirstName = ? AND CustomerLastName = ?");

			preparedStmnt.setString(1, order.getCustFName());
			preparedStmnt.setString(2, order.getCustLName());
			preparedStmnt.setString(3, order.getGrade());
			preparedStmnt.setString(4, order.getAddLineOne());
			preparedStmnt.setString(5, order.getAddLineTwo());
			preparedStmnt.setString(6, order.getCity());
			preparedStmnt.setString(7, order.getState());
			preparedStmnt.setString(8, order.getCustFName());
			preparedStmnt.setString(9, order.getCustLName());

			int i = preparedStmnt.executeUpdate();

			if (i == 0) {
				System.out.println("No records were updated!");
			} else {
				System.out.println(i + " record(s) were updated successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connections after the data has been handled.
			if (preparedStmnt != null)
				try {
					preparedStmnt.close();
				} catch (Exception e) {
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}
}
