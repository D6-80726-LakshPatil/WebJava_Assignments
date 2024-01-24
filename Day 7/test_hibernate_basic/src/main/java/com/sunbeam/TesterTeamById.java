package com.sunbeam;

import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class TesterTeamById {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			System.out.println("Enter id: ");
			TeamDao dao = new PlayerDaoImpl();
			
			System.out.println(dao.getTeamById(sc.nextInt()));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
