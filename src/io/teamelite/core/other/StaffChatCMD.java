package io.teamelite.core.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class StaffChatCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("staffchat")) {
			if(!sender.hasPermission("teamelite.staffchat.use")) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to read/send staff chat messages!");
			} else {
				if(args.length == 0) {
					MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You need to define a message! Correct Usage: /staffchat <message>");
				} else {
					if(args.length > 0) { // If a message was provided
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < args.length; i++) {
							sb.append(args[i]).append(" ");
						}
						String msg = sb.toString();
						for(Player staff : Bukkit.getServer().getOnlinePlayers()) {
							if(staff.hasPermission("teamelite.staffchat.recieve")) {
								PermissionUser pexUser = PermissionsEx.getUser(p);
								String userPrefix = pexUser.getPrefix();
								MessageManager.sendPlayerMessage(staff, "&4&lStaff &8&l» " + userPrefix + "&r" + " &c" + p.getName() + "&8&l: &d" + msg);
							}
						}
					}
				}
			}
		}
	return true;
	}
}
