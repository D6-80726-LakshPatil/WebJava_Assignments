package com.sunbeam;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;
public class TesterUpdateBulkWicks {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc =new Scanner(System.in)){
			TeamDao dao = new PlayerDaoImpl();
			System.out.println("enter wicks,batAvg : ");
			System.out.println(dao.updateByBulkWicks(sc.nextInt(), sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
