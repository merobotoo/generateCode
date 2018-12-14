package com.cg.pwa.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transactions;
import com.cg.pwa.service.BankServiceInterface;

@Controller
public class MyController 
{
	@Autowired
	BankServiceInterface bankservice;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getAll()
	{
		return "home";
	}

	
	@RequestMapping(value="create",method=RequestMethod.GET)
	public String createAccount(@ModelAttribute("my") 
	Customer emp,Map<String,Object> model)
	{
		
		return "createaccount";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertAccount(@Valid@ModelAttribute("my") 
	Customer cust,BindingResult result, Map<String,Object> model)
	{
		if(result.hasErrors())
		{
			return new ModelAndView ("createaccount");
		}
		else
		{
			bankservice.createAccount(cust);
			
			return new ModelAndView("createsuccess","edata",cust.getCustMobile());
		}
	}
	
	@RequestMapping(value="deposit",method=RequestMethod.GET)
	public String deposit(@ModelAttribute("my") Customer emp,Map<String,Object> model)
	{
		
		return "depositamount";
	}
	
	@RequestMapping(value="dodeposit",method=RequestMethod.GET)
	public ModelAndView viewdeposit(@RequestParam("mobNo")String custMobile,@RequestParam("damount") double custamount)
	{
		if(bankservice.accountExist(custMobile))
			
			return new ModelAndView ("accountnotexist");
		
		else
		{
			double amount=bankservice.deposit(custMobile, custamount);
			
			return new ModelAndView("depositsuccess","ebalance",amount);
		}
	}
	
	@RequestMapping(value="withdraw",method=RequestMethod.GET)
	public String withdraw(@ModelAttribute("my") Customer emp,Map<String,Object> model)
	{
		
		return "withdrawmoney";
	}
	
	@RequestMapping(value="dowithdraw",method=RequestMethod.GET)
	public ModelAndView viewwithdraw(@RequestParam("mobNo")String custMobile,@RequestParam("wamount") double custamount)
	{
		if(bankservice.accountExist(custMobile))
			
			return new ModelAndView ("accountnotexist");
		
		else
		{
		
			double amount=bankservice.withdraw(custMobile, custamount);
			
			return new ModelAndView("withdrawsuccess","ebalance",amount);
		}
	}
	
	@RequestMapping(value="check",method=RequestMethod.GET)
	public String checkBalance(@ModelAttribute("my") Customer emp,Map<String,Object> model)
	{
		
		return "checkbalance";
	}
	
	@RequestMapping(value="docheck",method=RequestMethod.GET)
	public ModelAndView viewbalance(@RequestParam("mobNo")String custMobile)
	{
		if(bankservice.accountExist(custMobile))
			
			return new ModelAndView ("accountnotexist");
		
		else
		{
			double amount=bankservice.checkBalance(custMobile);
			
			return new ModelAndView("checksuccess","checkbalance",amount);
		}
	}
	
	@RequestMapping(value="fund",method=RequestMethod.GET)
	public String fundTransfer(@ModelAttribute("my") Customer emp,Map<String,Object> model)
	{
		
		return "fundtransfer";
	}
	
	@RequestMapping(value="dofundtransfer",method=RequestMethod.GET)
	public ModelAndView viewtransfer(@RequestParam("SmobNo")String sender,@RequestParam("RmobNo")String receiver,@RequestParam("amount")double custamount)
	{
		if(bankservice.accountExist(sender) || bankservice.accountExist(receiver))
			return new ModelAndView ("accountnotexist");
		else
		{
			double amount=bankservice.fundTransfer(sender,receiver,custamount);
			
			return new ModelAndView("fundtransfersuccess","newbalance",amount);
		}
	}
	
	@RequestMapping(value="printtransactions", method=RequestMethod.GET)
	public String transactionsData() {
		System.out.println("in trans");
		
		return "printtransaction";
		
	}
	
	@RequestMapping(value="doprinttransactions", method=RequestMethod.GET)
	public ModelAndView Ptrans(@RequestParam("mobno") String mobileNo)
	{
		if(bankservice.accountExist(mobileNo))
		{
			return new ModelAndView("accountnotexist");
		}
			
		else
		{
			List<Transactions> trans = bankservice.getTransList(mobileNo);
			
			return new ModelAndView("transactionsuccess","trans",trans);
		}
		
		
	}
	
}
