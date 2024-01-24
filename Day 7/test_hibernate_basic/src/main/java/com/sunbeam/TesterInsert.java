package com.sunbeam;

import org.hibernate.*;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;
import Entity.Player;
import Entity.PlayerType;

import java.util.Scanner;
public class TesterInsert {

	public static void main(String[] args) {
			
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
				System.out.println("Enter name,battingAvg,wicketsTaken,PlayerType: ");
				Player newTeam=new Player(sc.next(),sc.nextInt(),sc.nextInt(),PlayerType.valueOf(sc.next().toUpperCase()));
				
				TeamDao dao=new PlayerDaoImpl();
				
				System.out.println(dao.addNewTeam(newTeam));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
