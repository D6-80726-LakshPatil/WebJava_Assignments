package Dao;

import static Utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

import Entity.Owner;
import Entity.Player;

public class PlayerDaoImpl implements PlayerDao {
	
		@Override
		public String addPlayerToTeam(Player player, Integer owenrId) {
			Session session =getFactory().getCurrentSession();
			Transaction tx= session.beginTransaction();
			String msg="Player not added!!!";
			try {
				Owner o= session.get(Owner.class, owenrId);
				if(o!=null) {
				o.addPlayer(player);
				
				}
				tx.commit();
				msg="Player Added  "+player.getId();
			}catch (Exception e) {
				if(tx!=null)
					tx.rollback();
				throw e;
			}
			return msg;
		}
	
		@Override
		public String deletePlayerFromTeam(Integer playerId, Integer ownerId) {
			Session session =getFactory().getCurrentSession();
			Transaction tx= session.beginTransaction();
			String msg="not deleted!!";
			try {
				
				Owner o=session.get(Owner.class, ownerId);
				Player p=session.get(Player.class, playerId);
				if(o!=null&&p!=null) {
					o.removePlayer(p);
					msg="Removed player "+p.getName()+" from Owner "+o.getName();
					
				}
				
				tx.commit();
			}catch (Exception e) {
				if(tx!=null)
					tx.rollback();
				throw e;
			}
		return msg;
		}
		
//		@Override
//		public String addNewPlayer(Player newPlayer) {
//				String msg="Player cannot be added";
//				Session session =getFactory().getCurrentSession();
//				
//				Transaction tx= session.beginTransaction();
//				
//				try{
//					Serializable id=session.save(newPlayer);
//					tx.commit();
//					msg="Player added successfully";
//				}catch (Exception e) {
//					if(tx!=null) {
//						tx.rollback();
//						throw e;
//					}
//						
//				}finally{
//					if(session!=null)
//						session.close();
//				}
//			return msg;
//		}
//		
//		@Override
//		public List<Player> getPlayers() {
//		List<Player> list=null;
//		String jpql="select e from Player e";
//		Session session =getFactory().getCurrentSession();
//		
//		Transaction tx=session.beginTransaction();
//		
//		try {
//			list=session.createQuery(jpql, Player.class).getResultList();
//			tx.commit();
//		}catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			
//			throw e;
//		}
//		
//		return list;
//		}
//		
//		@Override
//		public Player getPlayerById(Integer id) {
//		Player t= null;
//		Session session=getFactory().getCurrentSession();
//		Transaction tx=session.beginTransaction();
//		
//		try {
//			t=session.get(Player.class,id);
//			tx.commit();
//		}catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			
//			throw e;
//		}
//		return t;
//		}
//		
//		@Override
//		public List<Player> getPlayerByName(String name) {
//			List<Player> list=null;
//			Session session = getFactory().getCurrentSession();
//			Transaction tx = session.beginTransaction();
//			String jpql="select e from Player e where e.name=:nm";
//			try {
//				list=session.createQuery(jpql, Player.class).setParameter("nm", name).getResultList();
//				tx.commit();
//			}catch (Exception e) {
//				if(tx!=null)
//					tx.rollback();
//				
//				throw e;
//			}
//		return list;
//		}
//		
//		@Override
//		public String updateById(Integer id,Integer wicks) {
//			String msg="row Update failed!!";
//			
//			Player t=null;
//			Session session=getFactory().getCurrentSession();
//			Transaction tx =session.beginTransaction();
//			
//			try {
//				t=session.get(Player.class, id);
//				t.setWicketsTaken(wicks);
//				tx.commit();
//				msg="Updated row at id:"+id;
//			}catch (Exception e) {
//				if(tx!=null)
//					tx.rollback();
//				
//				throw e;
//			}
//		return msg;
//		}
//		
//		@Override
//		public String updateByBulkWicks(Integer wicks, Integer batAvg) {
//		String jpql="update Player e set e.wicketsTaken=:w where e.battingAvg<:ba";
//		
//		String msg="Update failed!!";
//		System.out.println(msg);
//		int cnt=0;
//		
//		Session session = getFactory().getCurrentSession();
//		
//		Transaction tx=session.beginTransaction();
//		
//		try {
//			cnt=session.createQuery(jpql).setParameter("ba", batAvg).setParameter("w", wicks).executeUpdate();
//			tx.commit();
//			msg="Updated rows : "+cnt;
//		}catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			throw e;
//		}
//		return msg;
//		}
//		
//		@Override
//		public String deleteById(Integer id) {
//			String msg="delete failed";
//			Session session = getFactory().getCurrentSession();
//			
//			Transaction tx =session.beginTransaction();
//			Player Player=null;
//			try {
//				Player = session.get(Player.class,id);
//				if(Player!=null) {
//					session.delete(Player);
//					msg="Player deleted";
//				}
//				tx.commit();
//			}catch (Exception e) {
//				if(tx!=null)
//					tx.rollback();
//				
//				throw e;
//			}
//		return msg;
//		}
//		
//		@Override
//		public String deleteBulkByWicks(Integer wicks) {
//			String msg ="Delete failed";
//			int cnt=0;
//			Session session = getFactory().getCurrentSession();
//			Transaction tx = session.beginTransaction();
//			String jpql="select e Player e where e.wicketsTaken<:wi";
//			List<Player> l=null;
//			try {
//				l=session.createQuery(jpql,Player.class).setParameter("wi", wicks).getResultList();
//				if(l!=null) {
//					for(Player t:l) {
//						session.delete(t);
//					}
//					
//				
//					msg="Players deleted";
//				}
//				tx.commit();
//			}catch (Exception e) {
//				if(tx!=null)
//					tx.rollback();
//				
//				throw e;
//			}
//		return msg;
//		}
}
