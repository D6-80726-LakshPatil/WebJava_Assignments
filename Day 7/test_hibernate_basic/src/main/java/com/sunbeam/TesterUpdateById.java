package com.sunbeam;

import org.hibernate.SessionFactory;

import Dao.TeamDao;
import Dao.PlayerDaoImpl;

import static Utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class TesterUpdateById {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
				TeamDao dao =new PlayerDaoImpl();
				
				System.out.println(dao.updateById(2, 33));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
