package src.io.teamelite.core.other.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class DoneCMD implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("done")) { // If /done is run
			if(!sender.hasPermission("teamelite.done")) { // If player does not have permission
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to make a player rage-quit!");
			} else {
				if(args.length == 0) { // /done (kicks themselves)
					p.kickPlayer(ChatColor.DARK_RED + "UMAD" + ChatColor.GOLD + "BRO?");
					MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.LIGHT_PURPLE.toString() + " " + p.getName() + " rage-quit the server!");
				}
				if(args.length == 1) { // /done <name>
					Player target = Bukkit.getServer().getPlayer(args[0]); // Gets player from first argument
					if(target == null) { // If player could not be found
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " The target player could not be found/is offline!");
						return true;
					}
					if(target.getName() == "Life855") {
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You are not allowed to make Dave rage-quit!");
						return true;
					}
					target.kickPlayer(ChatColor.DARK_RED + "UMAD" + ChatColor.GOLD + "BRO?");
					MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.LIGHT_PURPLE.toString() + " " + target.getName() + " rage-quit the server thanks to " + sender.getName() + "!");
				}
			}
		}
		return true;
	}
}
