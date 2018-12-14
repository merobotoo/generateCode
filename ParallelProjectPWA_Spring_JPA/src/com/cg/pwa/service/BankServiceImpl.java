package com.cg.pwa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pwa.dao.BankDaoInterface;
import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transactions;

@Service("bankservice")
@Transactional
public class BankServiceImpl implements BankServiceInterface 
{

	@Autowired
	BankDaoInterface bankDao;
	
	@Override
	public String createAccount(Customer customer) 
	{
		return bankDao.createAccount(customer);
	}

	@Override
	public double deposit(String custMobile, double custamount) 
	{
		return bankDao.deposit(custMobile, custamount);
	}

	@Override
	public double withdraw(String custMobile, double amount) 
	{
		return bankDao.withdraw(custMobile, amount);
	}

	@Override
	public double checkBalance(String custMobile) 
	{
		return bankDao.checkBalance(custMobile);
	}

	@Override
	public double fundTransfer(String sender, String reciever, double custamount) 
	{
		return bankDao.fundTransfer(sender, reciever, custamount);
	}

	@Override
	public boolean accountExist(String custMobileNo) {
		return bankDao.accountExist(custMobileNo);
	}

	@Override
	public List<Transactions> getTransList(String mobileNo) 
	{
		return bankDao.getTransList(mobileNo);
	}
	
}
