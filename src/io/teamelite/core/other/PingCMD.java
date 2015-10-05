package io.teamelite.core.other;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;
import net.minecraft.server.v1_8_R2.EntityPlayer;

public class PingCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ping")) {
			if(!sender.hasPermission("teamelite.ping")) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to check your ping to the server!");
			} else {
				CraftPlayer cp = (CraftPlayer) p;
				EntityPlayer ep = cp.getHandle();
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Your current ping to the server is: " + ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + ep.ping);
			}
		}
		return true;
	}
}
