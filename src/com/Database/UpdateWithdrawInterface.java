package com.Database;

import java.sql.SQLException;

import com.ATMModel.AccountsData;

public interface UpdateWithdrawInterface {
	
	void updateWithdrawBalence(AccountsData ad) throws SQLException;

}
