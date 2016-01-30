package src.io.teamelite.core.other.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class RestartServerCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("restartserver")) {
			if(!(sender.hasPermission("teamelite.restartserver"))) { // If the player does not have the 'teamelite.restartserver' permission.
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to restart the server!");
			} else { // If player is OP or has the permission.
				//MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " The server will be restarting in 15 seconds.");
				new BukkitRunnable() {
					int count = 16;
					public void run() {
						if(count == 1) {
							cancel();
							MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.LIGHT_PURPLE + " The server is restarting NOW.");
							p.performCommand("save-all");
							for(Player ply : Bukkit.getServer().getOnlinePlayers()) {
								ply.kickPlayer(ChatColor.RED + "Please be patient while the server restarts. \nAll work has been saved that was done prior to restart.");
							}
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
						} else {
							count--;
							MessageManager.sendServerBroadcast(Utils.prefix() + ChatColor.LIGHT_PURPLE + " The server will be restarting in " + count + " seconds");
						}
					}
				}.runTaskTimer(Utils.instance(), 0, 20);
			}
		}
	return true;
	}
}