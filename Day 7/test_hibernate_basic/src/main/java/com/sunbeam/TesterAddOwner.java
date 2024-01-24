package com.sunbeam;

import org.hibernate.SessionFactory;

import Dao.OwnerDao;
import Dao.OwnerDaoImpl;
import Entity.Owner;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class TesterAddOwner {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
				OwnerDao dao=new OwnerDaoImpl();
				System.out.println("Enter Name,Location:");
				Owner o=new Owner(sc.next(),sc.next());
				System.out.println(dao.addOwner(o));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
