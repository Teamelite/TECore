package io.teamelite.core.vanishmsgs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import io.teamelite.core.utilities.vanishmsgs.VanishData;

public class VanishPlayerJoinEVENT implements Listener {
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("vanish.standard")) { 
			VanishData.getData().set(e.getPlayer().getName() + ".vanished", true); // sets vanish state to true
			VanishData.saveData();
		}
	}
}
