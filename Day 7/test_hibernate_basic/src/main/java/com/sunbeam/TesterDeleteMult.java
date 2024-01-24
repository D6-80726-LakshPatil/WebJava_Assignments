package com.sunbeam;

import java.util.Scanner;
import static Utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

public class TesterDeleteMult {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc=new Scanner(System.in)){
				TeamDao dao = new PlayerDaoImpl();
				System.out.println("Enter wicks: ");
				System.out.println(dao.deleteBulkByWicks(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
