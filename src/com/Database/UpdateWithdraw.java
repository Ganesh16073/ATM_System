package com.Database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.ATMModel.AccountsData;

public class UpdateWithdraw implements UpdateWithdrawInterface {

	Connection con;
	PreparedStatement sta;
	public UpdateWithdraw()
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
	public void updateWithdrawBalence(AccountsData ad) throws SQLException {
		
		long accountNumber=ad.getAccountNumber();
		 double finalAmount=ad.getBalence();
		 sta=con.prepareStatement("update accountdetails set balance=? where accountnumber=?");
		 sta.setDouble(1,finalAmount);
		 sta.setLong(2, accountNumber);
		 int vl=sta.executeUpdate();
		 if(vl>0)
		 {
			 System.out.println("Withdraw Amount Updated");
		 }
		 else
		 {
			 System.out.println("Something Problem is in database...............");
		 }
		
	}

}
