package src.io.teamelite.core.tablist.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import src.io.teamelite.core.tablist.utils.TabListChanger;

public class PlayerJoinTabListChange implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
    	TabListChanger.setHeaderAndFooter(e.getPlayer(), ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Team" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Elite" + ChatColor.RED + ChatColor.BOLD.toString() + " Build Server", ChatColor.GOLD + ChatColor.BOLD.toString() + "    http://www.mcteamelite.com");
	}
}
