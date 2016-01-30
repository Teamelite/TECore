package src.io.teamelite.core.other.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class PluginPreProcessEVENT implements Listener {
	@EventHandler
	public void onPluginCommand(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().equals("/pl") || e.getMessage().equals("/plugins")) {
			if(e.getPlayer().hasPermission("teamelite.pluginview") || e.getPlayer().isOp()) {
				return;
			} else {
					e.setCancelled(true);
					MessageManager.sendPlayerMessage(e.getPlayer(), Utils.prefix() + ChatColor.LIGHT_PURPLE + " The plugins are not viewable from anybody apart from server operators & admins.");
			}
		}
	}
}
