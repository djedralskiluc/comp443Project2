package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.customer.Customer;
import com.company.ecomerce.partner.Partner;

public class PartnerDAO {

	public Set<Partner> getAllPartners() {
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Partner> Partners = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Partner";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int CustomerID = resultSet.getInt("PartnerId");
				Partner emp = getPartner(CustomerID);
				if(emp != null) {
					Partners.add(emp);
				}
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
		
		return Partners;
	}

	public Partner getPartner(int id) {
		Partner Partner = new Partner();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Partner where PartnerId='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			Partner.set(resultSet.getInt(""));
			Partner.setName(resultSet.getString(""));
			Partner.setName(resultSet.getString(""));


			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}

		
		return Partner;
	}

	public Partner addPartner(String name, int type) {
		Partner partner = new Partner();
		partner.setName(name);
		partner.setPartnerType(type);
	
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO  Partner (PartnerType,Name)"
					+ "VALUES('"+type+"','"+name+"')";
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
		
		return partner;
	}

	public void updatePartner(int id,  int type) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Partner SET phone='"+type+"' WHERE PartnerId='"+id+"')";
			updateStatement.executeUpdate(updateQuery);		
			
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

	public void deletePartner(int id) {

		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Partner WHERE PartnerId='"+id+"')";
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
