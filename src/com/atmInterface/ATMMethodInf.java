package com.atmInterface;

import java.sql.SQLException;

import com.ATMModel.*;
import com.Database.*;

public class ATMMethodInf implements ATMMethods{

	@Override
	public double checkBalence(AccountsData ad) {
		return ad.getBalence();
	}

	@Override
	public double DeposityMoney(AccountsData ad,double depositMoney) throws SQLException {
		
		double amount=ad.getBalence()+depositMoney;
		ad.setBalence(amount);
		DepositMoneyInterface dmi=new DepositMoneyUpdate();
		dmi.UpdateDepositMoney(ad);
		
		return ad.getBalence();
	}

	@Override
	public double withDrawMoney(AccountsData ad,double withdrawMoney) throws SQLException {
		
		if(withdrawMoney<=ad.getBalence())
		{
			double withdrawbal=ad.getBalence()-withdrawMoney;
			ad.setBalence(withdrawbal);
			UpdateWithdrawInterface uwi=new UpdateWithdraw();
			uwi.updateWithdrawBalence(ad);

			return ad.getBalence();
		}
		else 
		{
			return -1;
		}
	}

	@Override
	public void showDetails(AccountsData ad) {
		System.out.println();
		System.out.println("------------------- Your Account Details -------------------");
		System.out.println();
		System.out.println("Account Number => "+ad.getAccountNumber());
		System.out.println("Account Holder Name => "+ad.getName());
		System.out.println("Account Type => "+ad.getAccountType());
		System.out.println("Account Current Ballence => "+ad.getBalence());
		System.out.println("Account Holder Mobile Number => "+ad.getMobileNumber());
		System.out.println("Account Holder Adhar Number => "+ad.getAdharNumber());
		System.out.println("Account Holder Pan Number => "+ad.getPanNumber());
		
	}

	
	

}

