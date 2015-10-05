package io.teamelite.core.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;

public class DoneCMD implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("done")) { // If /done is run
			if(!sender.hasPermission("teamelite.done")) { // If player does not have permission
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.RED + " You do not have the sufficient permissions to make a player rage-quit!");
			} else {
				if(args.length == 0) { // /done
					MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.RED + " You need to define a player you wish to make rage-quit!");
				}
				if(args.length == 1) { // /done <name>
					Player target = Bukkit.getServer().getPlayer(args[0]); // Gets player from first argument
					if(target == null) { // If player could not be found
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.RED + " The target player could not be found/is offline!");
					} else {
						target.kickPlayer(ChatColor.DARK_RED + "UMAD" + ChatColor.GOLD + "BRO?");
						MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.RED.toString() + " " + target.getName() + " rage-quit the server thanks to " + sender.getName() + "!");
					}
				}
			}
		}
		return true;
	}
}
