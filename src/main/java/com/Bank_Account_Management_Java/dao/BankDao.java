package com.Bank_Account_Management_Java.dao;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Bank_Account_Management_Java.entity.BankAcc1;


public class BankDao {
	public EntityManager getEM() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank_pu");
    	EntityManager em = emf.createEntityManager();
    	return em;
	}
	
	public boolean addAccountRecord(BankAcc1 b)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		return true;
	}
	
	public BankAcc1 getAccountRecord(int AccNo)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b = em.find(BankAcc1.class, AccNo);
		em.getTransaction().commit();
		return b;
	}
	
	public BankAcc1 viewAccountRecord(int AccNo)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b = em.find(BankAcc1.class, AccNo);
		em.getTransaction().commit();
		return b;
	}
	
	public ArrayList<BankAcc1> viewAccountsRecord()
	{
		ArrayList<BankAcc1> al = new ArrayList<BankAcc1>();
		EntityManager em = getEM();
		em.getTransaction().begin();
		em.getTransaction().commit();
		return al;
	}
	
	public boolean updateAccountRecord(BankAcc1 b)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b1 = em.find(BankAcc1.class,b.getAccNo());
		b1.setName(b.getName());
		b1.setAccType(b.getAccType());
		b1.setBalance(b.getBalance());
		em.getTransaction().commit();
		return true;
	}
	
	public int decreaseAmount(int AccNo,double amt)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b=null;
		BankAcc1 b1 = em.find(BankAcc1.class,b.getAccNo());
		int n = 0;
		b1.setAccNo(1);
		double bal = b1.getBalance();
		b1.setBalance(bal-amt);
		b1.setAccNo(2);
		if (n > 0) {
			System.out.println("Amount withdrawed Successfully");
		}
		else {
			System.out.println("Transaction Unsccessfull");
		}
		em.getTransaction().commit();
		return n;
		
	}
	
	public int increaseAmount(int AccNo,double amt)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b=null;
		BankAcc1 b1 = em.find(BankAcc1.class,b.getAccNo());
		int n = 0;
		b1.setAccNo(1);
		double bal = b1.getBalance();
		b1.setBalance(bal+amt);
		b1.setAccNo(2);
		if (n > 0) {
			System.out.println("Amount deposited Successfully");
		}
		else {
			System.out.println("Transaction Unsccessfull");
		}
		em.getTransaction().commit();
		return n;
	}
	
	public boolean deleteAccountRecord(int AccNo)
	{
		EntityManager em = getEM();
		em.getTransaction().begin();
		BankAcc1 b = em.find(BankAcc1.class, AccNo);
		em.remove(b);
		em.getTransaction().commit();
		return true;
	}
}
