package io.teamelite.core.autoflower.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.autoflower.utils.FlowerProducer;
import io.teamelite.core.utilities.Utils;

public class AutoFlower implements CommandExecutor {
	public FlowerProducer flowerProducer = new FlowerProducer();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("autoflower")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Only an online player can use AutoFlower!");
			}
			if(!sender.hasPermission("teamelite.autoflower")) {
				sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to use AutoFlower!");
			} else {
				Player p = (Player) sender;
				double chance = 0.7;
				double flowerChance = 0.003;
				if(args.length == 0) {
					sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: /autoflower [radius] <chance 0-100> <flowerChance 0-100>");
				} else {
					if(args.length > 0) {
						int radius = -1;
						try {
							radius = Integer.valueOf(args[0]);
							if(args.length > 1) {
								double in = (double)Math.abs(Integer.valueOf(args[1]));
								if(in > 100) in = 100;
								chance = in/100;
							}
							if(args.length > 2) {
								double in = (double)Math.abs(Integer.valueOf(args[2]));
								if(in > 10) in = 100;
								flowerChance = in/2200;
							}
						} catch (NumberFormatException e) {
							if(args.length > 2) {
								p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: All arguments must be an integer! /autoflower [radius] <chance 0-100> <flowerChance 0-100>");
							} else if(args.length > 1) {
								p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: Both arguments must be an integer! /autoflower [radius] <chance 0-100>");
							} else {
								p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: Argument must be an integer! /autoflower [radius]");
							}
							return true;
						}

						radius = Math.abs(radius);
						flowerProducer.createFlowers(radius, p, chance, flowerChance);
						p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Flower generation has been completed!");
						return true;
					}
				}
			}
		}
		return true;
	}
}
