package com.sunbeam;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.OwnerDao;
import Dao.OwnerDaoImpl;
import Dao.PlayerDao;
import Dao.PlayerDaoImpl;
import Entity.Owner;
import Entity.Player;
import Entity.PlayerType;

public class TesterAddPlayerToTeam {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			PlayerDao dao=new PlayerDaoImpl();
			System.out.println("Enter Owner Id: ");
			Integer id=sc.nextInt();
			System.out.println("Enter Name,BattingAvg,Wicks,Type:");
			Player p=new Player(sc.next(),sc.nextInt(),sc.nextInt(),PlayerType.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.addPlayerToTeam(p,id));
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
