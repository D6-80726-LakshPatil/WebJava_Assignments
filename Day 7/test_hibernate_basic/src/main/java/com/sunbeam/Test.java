package com.sunbeam;
import static Utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class Test {
public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
				System.out.println("running!!!!");
				
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
