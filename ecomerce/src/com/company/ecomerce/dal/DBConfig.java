package com.company.ecomerce.dal;

public final class DBConfig {
	private String username;
	private String password;
	private String databaseURL;
	private String databaseName;
	
	public DBConfig(){
		username="admin";
		password="password2";
		databaseURL="jdbc:mysql://proj433.cba9y4ccno8d.us-east-2.rds.amazonaws.com:3306";
		databaseName="comp433";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseURL() {
		return databaseURL+"/"+getDatabaseName()+"?autoReconnect=true&useSSL=false";
	}
	
	public String getDatabaseName() {
		return databaseName;
	}

}
