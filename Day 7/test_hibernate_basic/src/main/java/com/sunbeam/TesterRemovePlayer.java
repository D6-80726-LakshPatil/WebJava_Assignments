package com.sunbeam;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.PlayerDao;
import Dao.PlayerDaoImpl;
import Entity.Player;
import Entity.PlayerType;

public class TesterRemovePlayer {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			PlayerDao dao=new PlayerDaoImpl();
			System.out.println("Enter Owner Id: ");
			Integer oId=sc.nextInt();
			System.out.println("Enter PlayerId:");
			Integer pId=sc.nextInt();
			System.out.println(dao.deletePlayerFromTeam(pId,oId));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
