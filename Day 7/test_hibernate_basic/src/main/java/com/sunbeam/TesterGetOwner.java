package com.sunbeam;
import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.OwnerDao;
import Dao.OwnerDaoImpl;
import Entity.Owner;

public class TesterGetOwner {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc =new Scanner(System.in)){
			OwnerDao dao =new OwnerDaoImpl();
			System.out.println("enter id:");
			Owner o=dao.getOwnerDetails(sc.nextInt());
			System.out.println(o);
			o.getList().forEach(System.out::println);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
