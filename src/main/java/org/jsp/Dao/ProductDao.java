package org.jsp.Dao;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Dto.Merchant;
import org.jsp.Dto.Product;
@SuppressWarnings("unchecked")
public class ProductDao {
private EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
Scanner sc=new Scanner(System.in);
public void saveProduct() {
	System.out.println("Enter your merchant id:");
	int merchant_id=sc.nextInt();
	Merchant a = manager.find(Merchant.class, merchant_id);
	if (a != null) {
		Product p=new Product();
		System.out.println("Enter the product name:");
		p.setName(sc.next());
		System.out.println("Enter the product brand:");
		p.setBrand(sc.next());
		System.out.println("Enter the product category:");
		p.setCategory(sc.next());
		System.out.println("Enter the product cost:");
		p.setCost(sc.nextDouble());
		System.out.println("Enter the product description:");
		p.setDescription(sc.next());
		System.out.println("Enter the product image url:");
		p.setImage_url(sc.next());
		a.getProduct().add(p);
		p.setMerchant(a);
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		System.out.println("Product added successfully with id:"+p.getId());
	}else {
		System.err.println("Merchant id is invalid......");
	}
}
public void updateProduct() {
	System.out.println("Enter the product id:");
	int id=sc.nextInt();
	Product p=manager.find(Product.class, id);
	if(p!=null) {
		System.out.println("Enter the product name:");
		p.setName(sc.next());
		System.out.println("Enter the product brand:");
		p.setBrand(sc.next());
		System.out.println("Enter the product category:");
		p.setCategory(sc.next());
		System.out.println("Enter the product cost:");
		p.setCost(sc.nextDouble());
		System.out.println("Enter the product description:");
		p.setDescription(sc.next());
		System.out.println("Enter the product imageurl:");
		p.setImage_url(sc.next());
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Successfully update the product......");
	}
}
public void findByMerchantId() {
	System.out.println("Enter the Merchant id:");
	int merchant_id=sc.nextInt();
	Query q=manager.createQuery("select m.product from Merchant m where m.id=?1");
	q.setParameter(1, merchant_id);
List<Product> li=q.getResultList();
if(li.size()>0) {
	for(Product p:li) {
		System.out.println("Product id:"+p.getId());
		System.out.println("Product name:"+p.getName());
		System.out.println("Product brand:"+p.getBrand());
		System.out.println("Product category:"+p.getCategory());
		System.out.println("Product cost:"+p.getCost());
		System.out.println("Product description:"+p.getDescription());
		System.out.println("--------------------------------------------");
	}
}else {
	System.err.println("Merchant id is invalid.......");
}
}
public void findByBrand() {
	System.out.println("Enter the product brand:");
	String brand=sc.next();
	Query q=manager.createQuery("select p from Product p where p.brand=?1");
	q.setParameter(1, brand);
	List<Product> l1=q.getResultList();
	if(l1.size()>0) {
		for(Product p:l1) {
			System.out.println("Product id:"+p.getId());
			System.out.println("Product name:"+p.getName());
			System.out.println("Product brand:"+p.getBrand());
			System.out.println("Product category:"+p.getCategory());
			System.out.println("Product cost:"+p.getCost());
			System.out.println("Product description:"+p.getDescription());
			System.out.println("--------------------------------------------");
		}
	}else {
		System.err.println("Invalid brand.......");
	}
}
public void findByCategory() {
	System.out.println("Enter the product category:");
	String category=sc.next();
	Query q=manager.createQuery("select p from Product p where p.category=?1");
	q.setParameter(1, category);
	List<Product> l1=q.getResultList();
	if(l1.size()>0) {
		for(Product p:l1) {
			System.out.println("Product id:"+p.getId());
			System.out.println("Product name:"+p.getName());
			System.out.println("Product brand:"+p.getBrand());
			System.out.println("Product category:"+p.getCategory());
			System.out.println("Product cost:"+p.getCost());
			System.out.println("Product description:"+p.getDescription());
			System.out.println("--------------------------------------------");
		}
	}else {
		System.err.println("Invalid category.......");
	}
}
}
