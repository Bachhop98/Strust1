package bachtuanhop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bachtuanhop.connect.EntityManagerFactory;
import bachtuanhop.entity.T002Entity;

public class T002DAO {

	public void update(T002Entity customer) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sql = new StringBuilder("EXEC updateCustomer ?, ?, ?, ?, ?, ? ");
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
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

	public void insert(T002Entity customer) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sql = new StringBuilder("EXEC insertCustomer ?, ?, ?, ?, ?, ?");
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
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
			connection = EntityManagerFactory.getInstance().getConnection();
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

	public List<T002Entity> find(String userName,String sex,String birthDayTo,String birthDayFrom , int offset, int limit) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		T002Entity customerEntity = new T002Entity();
		String sql = "EXEC search ?, ?, ?, ?, ?, ?";
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, sex);
			statement.setString(3, birthDayTo);
			statement.setString(4, birthDayFrom);
			statement.setInt(5, offset);
			statement.setInt(6, limit);
			resultSet = statement.executeQuery();
			List<T002Entity> list = new ArrayList<T002Entity>();
			while (resultSet.next()) {
				customerEntity.setId(Integer.parseInt(resultSet.getString("CUSTOMER_ID")));
				customerEntity.setName(resultSet.getString("CUSTOMER_NAME"));
				customerEntity.setSex(resultSet.getString("SEX"));
				customerEntity.setBirthDay(resultSet.getString("BIRTHDAY"));
				customerEntity.setAddress(resultSet.getString("ADDRESS"));
				list.add(customerEntity);
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

	public List<T002Entity> viewPage(int offset, int limit) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T002Entity> list = new ArrayList<T002Entity>();
		T002Entity customerEntity = new T002Entity();
		String sql = "EXEC viewPage ?, ?";
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, offset);
			statement.setInt(2, limit);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				customerEntity.setId(Integer.parseInt(resultSet.getString("CUSTOMER_ID")));
				customerEntity.setName(resultSet.getString("CUSTOMER_NAME"));
				customerEntity.setSex(resultSet.getString("SEX"));
				customerEntity.setBirthDay(resultSet.getString("BIRTHDAY"));
				customerEntity.setAddress(resultSet.getString("ADDRESS"));
				list.add(customerEntity);
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
			connection = EntityManagerFactory.getInstance().getConnection();
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

	public T002Entity getCustomerById(int customerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC getCustomerById ? ";
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, customerId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				T002Entity customerDto = new T002Entity();
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
}
