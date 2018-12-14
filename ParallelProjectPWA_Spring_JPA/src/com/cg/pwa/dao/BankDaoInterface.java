package com.cg.pwa.dao;

import java.util.List;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transactions;

public interface BankDaoInterface {
	
	public String createAccount(Customer customer);
	public double deposit(String custMobile, double custamount);
	public double withdraw(String custMobile, double custamount);
	public double checkBalance(String custMobile);
	public double fundTransfer(String sender, String reciever, double custamount);
	public boolean accountExist(String custMobileNo);
	List<Transactions> getTransList(String mobileNo);
			

}
