package com.harry.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
	System.out.println(getClass() + "Adding and account to DB\n");
    }

    public String name() {
	System.out.println(getClass() + "\n");
	return "hello";
    }

    private int id;

    public int getId() {
	System.out.println("getID\n");
	return id;
    }

    public void setId(int id) {
	System.out.println("setId\n");
	this.id = id;
    }

}
