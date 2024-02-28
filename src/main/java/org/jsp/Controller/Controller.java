package org.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.Dao.MerchantDao;
import org.jsp.Dao.ProductDao;
import org.jsp.Dto.Merchant;
import org.jsp.Dto.Product;

public class Controller {
private static Scanner sc=new Scanner(System.in);
private static ProductDao productDao=new ProductDao();
private static MerchantDao merchantDao=new MerchantDao();
public static void main(String[] args) {
	while(true) {
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find By Merchant id");
		System.out.println("4.Verify phone and password");
		System.out.println("5.Verify email and password");
		System.out.println("6.Save Product");
		System.out.println("7.Update Product");
		System.out.println("8.Find Product By Merchant Id");
		System.out.println("9.Find By Brand");
		System.out.println("10.Find By Category");
       switch(sc.nextInt()) {
       case 1:merchantDao.saveMerchant();break;
       case 2:merchantDao.updateMerchant();break;
       case 3:merchantDao.findByMerchantId();;break;
       case 4:merchantDao.verifyPhoneAndPasswordMerchant();break;
       case 5:merchantDao.verifyEmailAndPasswordMerchant();break;
       case 6:productDao.saveProduct();break;
       case 7:productDao.updateProduct();break;
       case 8:productDao.findByMerchantId();break;
       case 9:productDao.findByBrand();break;
       case 10:productDao.findByCategory();break;
       default:System.err.println("Invalid option......");break;
       }
	}}
}
