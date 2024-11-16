package com.Database;

import java.sql.SQLException;

import com.ATMModel.AccountsData;

public interface DepositMoneyInterface {
	
	public void UpdateDepositMoney(AccountsData ad) throws SQLException;

}
