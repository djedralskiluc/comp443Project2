package com.company.ecomerce.dal;

public final class DBConfig {
	private String username;
	private String password;
	private String databaseURL;
	private String databaseName;
	
	public DBConfig(){
		username="admin";
		password="password1!";
		databaseURL="comp433.cba9y4ccno8d.us-east-2.rds.amazonaws.com:3306";
		databaseName="Comp433Project";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseURL() {
		return databaseURL+"/"+getDatabaseName();
	}
	
	public String getDatabaseName() {
		return databaseName;
	}

}
