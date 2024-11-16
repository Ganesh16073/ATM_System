package com.Database;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import com.ATMModel.RegisterUser;


public class RegisterRepo implements RegisterInterface{

	Connection con;
	public RegisterRepo()
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
	public void RegisterUserDB(RegisterUser ru) {

		try {
			PreparedStatement sta=con.prepareStatement("insert into accountdetails value('0',?,?,?,?,?,?,?)");
			sta.setString(1,ru.getName() );
			sta.setString(2, ru.getAccountType());
			sta.setDouble(3, ru.getBalence());
			sta.setInt(4,ru.getPin());
			sta.setLong(5, ru.getMobileNumber());
			sta.setLong(6, ru.getAdharNumber());
            sta.setString(7, ru.getPanNumber());
            int rowsAffected = sta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed.");
            }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
