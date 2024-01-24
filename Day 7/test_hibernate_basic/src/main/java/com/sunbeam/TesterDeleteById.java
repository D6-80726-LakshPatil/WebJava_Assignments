package com.sunbeam;

import java.util.Scanner;
import static Utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

public class TesterDeleteById {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc=new Scanner(System.in)){
			TeamDao dao = new PlayerDaoImpl();
			System.out.println("Enter Id: ");
			System.out.println(dao.deleteById(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
