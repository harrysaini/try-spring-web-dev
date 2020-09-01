package com.harry.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harry.springaop.Account;

@Component
public class AccountDAO {

    public void addAccount() {
	System.out.println(getClass() + "Adding and account to DB\n");
    }

    public void name(String abc) {
	System.out.println(getClass() + "name()" + abc + "\n");
    }

    public List<Account> findAccounts(boolean throwError) {

	if (throwError) {
	    throw new RuntimeException("error in findAccounts");
	}

	List<Account> accounts = new ArrayList<Account>();

	accounts.add(new Account("ram", "gold"));
	accounts.add(new Account("shyam", "silver"));

	return accounts;
    }
}
