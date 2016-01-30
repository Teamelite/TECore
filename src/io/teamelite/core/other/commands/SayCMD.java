package src.io.teamelite.core.other.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class SayCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("say")) {
			if(!(p.hasPermission("teamelite.say"))) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to make an announcement.");
			} else {
				if(args.length == 0) {
					MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage. Correct Usage: /say <msg>.");
				} else {
					StringBuilder sb = new StringBuilder();
					for(int i=0; i<args.length; i++) {
						sb.append(args[i]).append(" ");
					}
					String msg = sb.toString();
					p.performCommand("announce ingame " + msg);
				}
			}
		}
		return true;
	}
}
