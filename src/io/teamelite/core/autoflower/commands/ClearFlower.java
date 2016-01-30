package src.io.teamelite.core.autoflower.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.autoflower.utils.FlowerProducer;
import src.io.teamelite.core.utilities.Utils;

public class ClearFlower implements CommandExecutor {
	public FlowerProducer flowerProducer = new FlowerProducer();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clearflower")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Only an online player can use AutoFlower!");
			}
			Player p = (Player) sender;
			if(!sender.hasPermission("teamelite.autoflower.clearflower")) {
				sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to use AutoFlower!");
			} else {
				if(args.length == 0) {
					sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: /clearflower [radius]");
				} else {
					if(args.length > 0) {
						int radius = -1;
						try {
							radius = Integer.valueOf(args[0]);
						} catch (NumberFormatException e) {
							p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Incorrect Usage: Argument must be an integer! /clearflower [radius]");
							return true;
						}

						radius = Math.abs(radius);
						flowerProducer.clearFlowers(radius, p);
						p.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Flower removal has been completed!");
					}
				}
			}
		}
		return true;
	}
}
