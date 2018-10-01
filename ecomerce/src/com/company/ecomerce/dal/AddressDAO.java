package com.company.ecomerce.dal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.company.ecomerce.customer.*;
public class AddressDAO {
	public AddressDAO() {
		
	}
	
	public Address getAddress(String id){

		Connection connection = DBConnect.getDatabaseConnection();
		Address addr = new Address();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Address WHERE Id='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				addr.setAttn(resultSet.getString("Attn"));
				addr.setAddr1(resultSet.getString("Addr1"));
				addr.setAddr2(resultSet.getString("Addr2"));
				addr.setCity(resultSet.getString("City"));
				addr.setState(resultSet.getString("State"));
				addr.setZip(resultSet.getString("Zip"));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return addr;
	}
	
	public void insertAddress(Address addr) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			

				String insertQuery = "INSERT INTO  Address (Attn,Addr1,Addr2,City,State,Zip)"
						+ "VALUES('"+addr.getAttn()+"','"+addr.getAddr1()+"','"+addr.getAddr2()+"','"+addr.getCity()+"','"+addr.getState()+"','"+addr.getZip()+"')";
				insertStatement.executeUpdate(insertQuery);
				
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
				
	}
	
	public void deleteAddress(int id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM employee_privilege WHERE Id='"+id+"')";
			deleteStatement.executeUpdate(deleteQuery);	
						
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
	}
}
