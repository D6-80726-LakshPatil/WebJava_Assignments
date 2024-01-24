package com.sunbeam;

import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class TesterSelectByName {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in)){
				TeamDao dao = new PlayerDaoImpl();
				System.out.println("Enter Name: ");
				dao.getTeamByName(sc.next()).forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
