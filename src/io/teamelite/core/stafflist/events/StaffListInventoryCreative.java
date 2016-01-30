package src.io.teamelite.core.stafflist.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;

public class StaffListInventoryCreative implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryCreativeClick(InventoryCreativeEvent e) {
		if(!e.getInventory().getName().equals(ChatColor.DARK_RED + "Team" + ChatColor.GOLD + "Elite" + ChatColor.RED + " Staff List")) {
			return;
		}
	}
}
