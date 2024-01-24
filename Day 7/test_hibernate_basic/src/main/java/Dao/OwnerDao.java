package Dao;

import Entity.Owner;

public interface OwnerDao {
		public String addOwner(Owner owner);
		
		public Owner getOwnerDetails(Integer id);
}
