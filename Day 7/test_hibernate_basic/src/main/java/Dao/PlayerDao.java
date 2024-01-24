package Dao;

import java.util.List;

import Entity.Player;

public interface PlayerDao {
	
		public String addPlayerToTeam(Player player,Integer owenrId);
		public String deletePlayerFromTeam(Integer playerId,Integer ownerId);
	
//		String addNewPlayer(Player newPlayer);
//		
//		List<Player> getPlayers();
//		
//		Player getPlayerById(Integer id);
//		
//		List<Player> getPlayerByName(String name);
//		
//		String updateById(Integer id,Integer wicks);
//		
//		String updateByBulkWicks(Integer wicks,Integer batAvg);
//		
//		String deleteById(Integer id);
//		
//		String deleteBulkByWicks(Integer wicks );
}
