package bachtuanhop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bachtuanhop.connect.DBConnect;
import bachtuanhop.entity.CustomerEntity;

public class T002DAO {

	public void update(CustomerEntity customer) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sql = new StringBuilder("EXEC updateCustomer ?, ?, ?, ?, ?, ? ");
		try {
			connection = DBConnect.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql.toString());
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getSex());
			statement.setString(3, customer.getBirthDay());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getAddress());
			statement.setInt(6, customer.getId());
			statement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void insert(CustomerEntity customer) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sql = new StringBuilder("EXEC insertCustomer ?, ?, ?, ?, ?, ?");
		try {
			connection = DBConnect.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, customer.getId());
			statement.setString(2, customer.getName());
			statement.setString(3, customer.getSex());
			statement.setString(4, customer.getBirthDay());
			statement.setString(5, customer.getEmail());
			statement.setString(6, customer.getAddress());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC deleteCustomer ?";
		try {
			connection = DBConnect.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<CustomerEntity> find(String userName, String sex, String birthDayFrom, String birthDayTo, int offset,
			int limit) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String sql = "EXEC search ?, ?, ?, ?, ?, ?";
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, sex);
			statement.setString(3, birthDayTo);
			statement.setString(4, birthDayFrom);
			statement.setInt(5, offset);
			statement.setInt(6, limit);
			resultSet = statement.executeQuery();
			List<CustomerEntity> list = new ArrayList<CustomerEntity>();
			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("CUSTOMER_ID"));
				String name = resultSet.getString("CUSTOMER_NAME");
				String sex1 = resultSet.getString("SEX");
				String birthDay = resultSet.getString("BIRTHDAY");
				String address = resultSet.getString("ADDRESS");
				CustomerEntity customerDto = new CustomerEntity(id, name, sex1, birthDay, null, address, null, null, 0, null,
						0);
				list.add(customerDto);
			}
			return list;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	public List<CustomerEntity> viewPage(int offset, int limit) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<CustomerEntity> list = new ArrayList<CustomerEntity>();
		String sql = "EXEC viewPage ?, ?";
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, offset);
			statement.setInt(2, limit);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("CUSTOMER_ID"));
				String name = resultSet.getString("CUSTOMER_NAME");
				String sex = resultSet.getString("SEX");
				String birthDay = resultSet.getString("BIRTHDAY");
				String address = resultSet.getString("ADDRESS");
				CustomerEntity customerDto = new CustomerEntity(id, name, sex, birthDay, null, address, null, null, 0, null,
						0);
				list.add(customerDto);
			}
			return list;

		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	public int totalItem() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC getTotalItem";
		int count = 0;
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;

		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}

	}

	public CustomerEntity getCustomerById(int customerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC getCustomerById ? ";
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, customerId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CustomerEntity customerDto = new CustomerEntity();
				customerDto.setId(Integer.parseInt(resultSet.getString("CUSTOMER_ID")));
				customerDto.setName(resultSet.getString("CUSTOMER_NAME"));
				customerDto.setSex(resultSet.getString("SEX"));
				customerDto.setBirthDay(resultSet.getString("BIRTHDAY"));
				customerDto.setAddress(resultSet.getString("ADDRESS"));
				return customerDto;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;

	}

	public static void main(String[] args) {
		T002DAO t002Dao = new T002DAO();
		// System.out.println(t002Dao.viewAll());
		/*
		 * CustomerDTO customer = new CustomerDTO(10010008, "Tran Van Dung", "0",
		 * "2000/12/11", "tvc@gmail.com", "KTX Khu B",null, null, 0, null, 0);
		 */

//		t002Dao.insert(customer);
		// t002Dao.update(customer);
		// t002Dao.delete(10010009);
		// System.out.println(t002Dao.viewPage(0, 2));
		// System.out.println(t002Dao.totalItem());
		System.out.println(t002Dao.find("", "", "1990/01/14", "2020/05/14", 0, 15).size());
	 System.out.println(t002Dao.getCustomerById(10001002));

	}

}
