package io.teamelite.core.vanishmsgs.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;
import io.teamelite.core.utilities.vanishmsgs.VanishData;

public class VanishPreProcessEVENT implements Listener {
	@EventHandler
	public void CommandPreProcess(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().equals("/vanish")) {
			if(VanishData.getData().getBoolean(e.getPlayer().getName() + ".vanished") == true) {
				VanishData.getData().set(e.getPlayer().getName() + ".vanished", false);
				VanishData.saveData();
				String msg = VanishData.getData().getString(e.getPlayer().getName() + ".custommessage");
				if(msg == null) {
					return;
				} else {
					MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.LIGHT_PURPLE + " " + msg);
				}
			} else {
				VanishData.getData().set(e.getPlayer().getName() + ".vanished", true);
				VanishData.saveData();
			}
		}
	}
}
