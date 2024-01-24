package com.app.beans;

import java.util.List;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;
import com.app.pojos.Team;

public class TeamBean {
//dependency : team dao
	private TeamDao teamDao;
	
	//def ctor
	public TeamBean() {
		//create team dao instance
		teamDao=new TeamDaoImpl();
		System.out.println("created team bean n dao");
	}
	//add B.L method to get team details
	public List<Team> getTeamDetails() 
	{
		System.out.println("in get team dtls");
		return teamDao.getTeamDetails();
	}
}
