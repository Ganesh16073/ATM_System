package com.Database;

import java.sql.SQLException;

import com.ATMModel.AccountsData;
import com.ATMModel.LoginUser;

public interface LoginInterface {
	boolean checkValidUser(LoginUser lu) throws SQLException;
	AccountsData getValidUserData();

}
