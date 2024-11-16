package com.Database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.ATMModel.AccountsData;
import com.ATMModel.LoginUser;

public class LoginRepo implements LoginInterface{

	Connection con;
	PreparedStatement sta;
	ResultSet rs;
	AccountsData adl=new AccountsData();
	public LoginRepo()
	{
		try
		{
			InputStream is=new FileInputStream("D:\\java_pratices\\ATM_System\\src\\ATMControler\\Tests.properties");
			Properties p=new Properties();
			p.load(is);
			
			String DriverClassName=p.getProperty("driver");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			
			Class.forName(DriverClassName);
			con=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean checkValidUser(LoginUser lu) throws SQLException {
		
		sta=con.prepareStatement("select * from accountdetails where accountNumber=? and pin=?");
		sta.setLong(1, lu.getAccountNumber());
		sta.setInt(2, lu.getPin());
		rs=sta.executeQuery();
		if(rs.next())
		{
			adl.setAccountNumber(rs.getLong(1));
			adl.setName(rs.getString(2));
			adl.setAccountType(rs.getString(3));
			adl.setBalence(rs.getDouble(4));
			adl.setPin(rs.getInt(5));
			adl.setMobileNumber(rs.getLong(6));
			adl.setAdharNumber(rs.getLong(7));
			adl.setPanNumber(rs.getString(8));
			
			
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public AccountsData getValidUserData() {
		
		
		return this.adl;
	}


}
