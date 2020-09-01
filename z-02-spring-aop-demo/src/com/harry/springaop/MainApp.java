package com.harry.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harry.springaop.dao.AccountDAO;
import com.harry.springaop.dao.MembershipDAO;

public class MainApp {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

	AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//	System.out.println(AccountDAO.class);

	accountDAO.addAccount();
	accountDAO.name("dsa");

	MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

	membershipDAO.addAccount();
	membershipDAO.name();

	membershipDAO.setId(12);

	membershipDAO.getId();

//	AccountDAO accountDAO2 = new AccountDAO();
//
//	accountDAO2.addAccount();

	context.close();
    }
}
