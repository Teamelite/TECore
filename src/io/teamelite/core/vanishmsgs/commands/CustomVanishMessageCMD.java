package io.teamelite.core.vanishmsgs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;
import io.teamelite.core.utilities.vanishmsgs.VanishData;

public class CustomVanishMessageCMD implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("vanishmessage")) {
			if(!sender.hasPermission("teamelite.vanishcustommessage")) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to set a custom vanish message!");
			} else {
				if(args.length == 0) {
					MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You need to define a message you wish to set as your vanish message. Correct usage: /vanishmessage <message>");
					return true;
				} else {
					StringBuilder sb = new StringBuilder();
					for(int i=0; i<args.length; i++){
						sb.append(args[i]).append(" ");
					}
					String msg = sb.toString();
					if(VanishData.getData().getBoolean(p.getName() + ".vanished") == true) {
						VanishData.getData().set(p.getName() + ".custommessage", msg);
						VanishData.getData().set(p.getName() + ".vanished", true);
						VanishData.saveData();
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Your vanish message has been set to: " + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + msg);
					} else {
						VanishData.getData().set(p.getName() + ".custommessage", msg);
						VanishData.getData().set(p.getName() + ".vanished", false);
						VanishData.saveData();
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Your vanish message has been set to: " + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + msg);
					}
				}
			}
		}
		return true;
	}
 }