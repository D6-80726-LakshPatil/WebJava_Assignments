package com.sunbeam;

import org.hibernate.SessionFactory;
import Entity.Player;
import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;

import java.util.List;
public class TesterSelectAll {

	public static void main(String[] args) {
		
		try(SessionFactory sf =getFactory()){
			
			
			
			
			TeamDao dao=new PlayerDaoImpl();
			
			dao.getTeams().forEach(System.out::println);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
