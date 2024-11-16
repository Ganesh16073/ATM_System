package com.atmInterface;

import java.sql.SQLException;

import com.ATMModel.*;

public interface ATMMethods {

	double checkBalence(AccountsData ad);
	double DeposityMoney(AccountsData ad,double depositMoney) throws SQLException;
	double withDrawMoney(AccountsData ad,double withdrawMoney) throws SQLException;
	void showDetails(AccountsData ad);
	
}
