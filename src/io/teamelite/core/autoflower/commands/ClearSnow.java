package io.teamelite.core.autoflower.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.autoflower.utils.FlowerProducer;
import io.teamelite.core.utilities.Utils;

public class ClearSnow implements CommandExecutor {
	public FlowerProducer flowerProducer = new FlowerProducer();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clearsnow")) {
				if(!(sender instanceof Player)) {
					sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Only an online player can use AutoFlower!");
				}
				if(!sender.hasPermission("teamelite.autoflower.clearsnow")) {
					sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to use AutoFlower!");
				} else {
					Player p = (Player) sender;
					if(args.length == 0) {
						sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: /clearsnow [radius]");
					} else {
						if(args.length > 0) {
							int radius = -1;
							try {
								radius = Integer.valueOf(args[0]);
							} catch (NumberFormatException e) {
								p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: Argument must be an integer! /clearsnow [radius]");
								return true;
							}

							flowerProducer.snowRemove(radius, p);
							p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Snow removal has been completed!");
						}
					}
				}
			}
		return true;
	}
}