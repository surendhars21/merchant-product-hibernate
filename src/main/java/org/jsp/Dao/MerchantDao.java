package org.jsp.Dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Dto.Merchant;

public class MerchantDao {
private EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
Scanner sc=new Scanner(System.in);
public void saveMerchant() {
	Merchant m=new Merchant();
	System.out.println("Enter the name:");
	m.setName(sc.next());
	System.out.println("Enter the email:");
	m.setEmail(sc.next());
	System.out.println("Enter the phone:");
	m.setPhone(sc.nextLong());
	System.out.println("Enter the gstNo:");
	m.setGst_no(sc.next());
	System.out.println("Enter the password:");
	m.setPassword(sc.next());
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(m);
	transaction.begin();
	transaction.commit();
	System.out.println("Merchant saved with id:"+m.getId());
}
public void updateMerchant() {
	System.out.println("Enter the Merchant id:");
	int id=sc.nextInt();
	Merchant merchantdb=manager.find(Merchant.class, id);
	if(merchantdb!=null) {
		System.out.println("Enter the name:");
		merchantdb.setName(sc.next());
		System.out.println("Enter the email:");
		merchantdb.setEmail(sc.next());
		System.out.println("Enter the gstNo:");
		merchantdb.setGst_no(sc.next());
		System.out.println("Enter the phone:");
		merchantdb.setPhone(sc.nextLong());
		System.out.println("Enter the password:");
		merchantdb.setPassword(sc.next());
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Updated successfully.....");
	}
}
public void findByMerchantId() {
	System.out.println("Enter the merchant id:");
	int id=sc.nextInt();
	 Merchant m=manager.find(Merchant.class, id);
	 if(m!=null) {
		 System.out.println("Merchant id:"+m.getId());
		 System.out.println("Merchant name:"+m.getName());
		 System.out.println("Merchant email:"+m.getEmail());
		 System.out.println("Merchant phone:"+m.getPhone());
		 System.out.println("Merchant gstNo:"+m.getGst_no());
	 }
	 else {
		 System.err.println("Invalid id.......");
	 }
}
public void verifyPhoneAndPasswordMerchant() {
	System.out.println("Enter the phone:");
	long phone=sc.nextLong();
	System.out.println("Enter the password:");
	String password=sc.next();
	Query q=manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
	q.setParameter(1, phone);
	q.setParameter(2, password);
try {
	Merchant m=(Merchant)q.getSingleResult();
	System.out.println("Verified Successfully......");
	System.out.println("Merchant id:"+m.getId());
	System.out.println("Merchant name:"+m.getName());
	System.out.println("Merchant email:"+m.getEmail());
	System.out.println("Merchant phone:"+m.getPhone());
	System.out.println("Merchant gstNo:"+m.getGst_no());
}
catch(NoResultException e) {
	System.err.println("Invalid phone and passowrd......");
}
}
public void verifyEmailAndPasswordMerchant() {
	System.out.println("Enter the email:");
    String email=sc.next();
	System.out.println("Enter the password:");
	String password=sc.next();
	Query q=manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
	q.setParameter(1,email);
	q.setParameter(2, password);
try {
	Merchant m=(Merchant)q.getSingleResult();
	System.out.println("Verified Successfully......");
	System.out.println("Merchant id:"+m.getId());
	System.out.println("Merchant name:"+m.getName());
	System.out.println("Merchant email:"+m.getEmail());
	System.out.println("Merchant phone:"+m.getPhone());
	System.out.println("Merchant gstNo:"+m.getGst_no());
}
catch(NoResultException e) {
	System.err.println("Invalid email and passowrd......");
}
}

}
