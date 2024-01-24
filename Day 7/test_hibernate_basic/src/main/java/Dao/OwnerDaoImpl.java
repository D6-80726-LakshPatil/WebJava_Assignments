package Dao;
import static Utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.Owner;

public class OwnerDaoImpl implements OwnerDao {
	@Override
	public String addOwner(Owner owner) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String msg="Insert failed";
		try {
			session.persist(owner);
			
			tx.commit();
			msg="Insert success "+owner.getId();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	@Override
	public Owner getOwnerDetails(Integer id) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Owner o=null;
		try {
			o=session.get(Owner.class,id);
			
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return o;
	}
}
