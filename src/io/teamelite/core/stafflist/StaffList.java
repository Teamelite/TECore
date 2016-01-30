package src.io.teamelite.core.stafflist;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.Utils;
import src.io.teamelite.core.utilities.stafflist.InventorySetup;

public class StaffList implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("stafflist")) {
			if(!sender.hasPermission("teamelite.stafflist.view")) {
				sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have the sufficient permissions to view the staff list!");
			} else {
				p.openInventory(InventorySetup.inv());
			}
		}
	return true;
	}
}
