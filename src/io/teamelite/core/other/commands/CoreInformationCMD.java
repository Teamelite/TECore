package src.io.teamelite.core.other.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.CoreInformation;
import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class CoreInformationCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("information")) {	
			MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " TECore version: " + ChatColor.DARK_PURPLE + CoreInformation.getVersion());
			MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Version Push Date: " + ChatColor.DARK_PURPLE + CoreInformation.getPushDate());
			MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Found a bug? Please use " + ChatColor.DARK_PURPLE + "/bug" + ChatColor.LIGHT_PURPLE + " to report it.");
		}
		return true;
	}
}
