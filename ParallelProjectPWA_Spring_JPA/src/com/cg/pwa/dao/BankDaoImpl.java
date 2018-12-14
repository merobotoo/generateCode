 package com.cg.pwa.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transactions;

@Repository("bankDao")
public class BankDaoImpl implements BankDaoInterface 
{

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@PersistenceContext
	EntityManager entitymanager;
	@Override
	public String createAccount(Customer customer) 
	{
		Transactions t1 = new Transactions();
		entitymanager.persist(customer);
		t1.setCustMobile(customer.getCustMobile());
		t1.setTransactionamount(0);
		t1.setCreditdebit("credit");
		t1.setBalance(customer.getCustInitialBalance());
		Date date = new Date();
		t1.setDate(String.valueOf(dateFormat.format(date)));
		
		
		entitymanager.persist(t1);
		entitymanager.flush();
		return customer.getCustMobile();
	}

	@Override
	public double deposit(String custMobile, double custamount)
	{
		System.out.println("depositDaoImpl()");
		Transactions t4 = new Transactions();
		Customer customer = entitymanager.find(Customer.class, custMobile);
		double iniBal=customer.getCustInitialBalance();
		iniBal+=custamount;
		customer.setCustInitialBalance(iniBal);
		t4.setCustMobile(custMobile);
		t4.setBalance(iniBal);
		t4.setTransactionamount(custamount);
		t4.setCreditdebit("Credit");
		Date date = new Date();
		t4.setDate(String.valueOf(dateFormat.format(date)));
		entitymanager.persist(t4);
		entitymanager.flush();
		return iniBal;
	}
	
	@Override
	public double withdraw(String custMobile, double custamount) 
	{
		Transactions t5 = new Transactions();
		Customer customer=entitymanager.find(Customer.class, custMobile);
		double iniBal=customer.getCustInitialBalance();
		iniBal-=custamount;
		customer.setCustInitialBalance(iniBal);
		t5.setCustMobile(custMobile);
		t5.setCreditdebit("Debit");
		t5.setBalance(iniBal);
		t5.setTransactionamount(custamount);
		Date date = new Date();
		t5.setDate(String.valueOf(dateFormat.format(date)));
		entitymanager.persist(t5);
		entitymanager.flush();
		return iniBal;
		
	}

	@Override
	public double checkBalance(String custMobile) 
	{
		Customer customer=entitymanager.find(Customer.class, custMobile);
		double amount=customer.getCustInitialBalance();
		System.out.println(amount);
		return amount;
	}
	

	@Override
	public double fundTransfer(String sender, String reciever, double custamount) 
	{
		Transactions t3 = new Transactions();
		Transactions t4 = new Transactions();
		Customer cust1=entitymanager.find(Customer.class, sender);
		double amount1=cust1.getCustInitialBalance();
		Customer cust2=entitymanager.find(Customer.class, reciever);
		double amount2=cust2.getCustInitialBalance();
		amount1=amount1-custamount;
		amount2=amount2+custamount;
		cust1.setCustInitialBalance(amount1);
		cust2.setCustInitialBalance(amount2);
		t3.setCustMobile(sender);
		t3.setBalance(amount1);
		t3.setCreditdebit("Debit");
		t3.setTransactionamount(custamount);
		Date date = new Date();
		t3.setDate(String.valueOf(dateFormat.format(date)));
		entitymanager.persist(t3);
		t4.setCustMobile(reciever);
		t4.setCreditdebit("Credit");
		t4.setBalance(amount2);
		t4.setTransactionamount(custamount);
		Date date2 = new Date();
		t4.setDate(String.valueOf(dateFormat.format(date2)));
		entitymanager.persist(t4);
		entitymanager.flush();
		return amount2;
	}

	@Override
	public boolean accountExist(String custMobileNo) 
	{
		Customer cust = entitymanager.find(Customer.class,custMobileNo);
		if(cust==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Transactions> getTransList(String mobileNo) 
	{
		String qr = "select trans from Transactions trans where mobileNo ="+mobileNo;
		TypedQuery<Transactions> query = entitymanager.createQuery(qr, Transactions.class);
		List<Transactions> list = query.getResultList();
		return list;
	}

}
