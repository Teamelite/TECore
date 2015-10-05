package io.teamelite.core.trialmanagement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;
import io.teamelite.core.utilities.trialmanagement.TrialData;

public class BeginTrial implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("begintrial")) {
			if(!sender.hasPermission("teamelite.begintrial")) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.DARK_PURPLE + " You do not have the sufficient permissions to begin your trial!");
			} else {
				if(!TrialData.getData().getBoolean("trial-begun." + p.getName()) == true) {
					MessageManager.sendPlayerMessage(p, "&a&lTrial &8&l> &7&lYou have now started your &a&ltrial&7&l! Your teleportation to the &a&ltrial&7&l world will now commence.");
					World w = Bukkit.getServer().getWorld("Trial-Plots");
					double x = w.getSpawnLocation().getX();
					double y = w.getSpawnLocation().getY();
					double z = w.getSpawnLocation().getZ();
					Location tpLoc = new Location(w, x, y, z);
					p.teleport(tpLoc);
					p.performCommand("plotme auto");
					MessageManager.sendPlayerMessage(p, "&a&lTrial &8&l> &7&lThis is now your plot. Once you feel you have completed your trial, please contact a staff member who will then review it.");
					MessageManager.sendSlackMessage("<!group> " + sender.getName() + " has begun their trial! Type /plotme home " + sender.getName() + " in the trial-plots world to view the progress.", "https://hooks.slack.com/services/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", "teamelite-trialbot", null);
					TrialData.getData().set("trial-begun." + p.getName(), true);
					TrialData.saveData();
				} else {
					MessageManager.sendPlayerMessage(p, "&a&lTrial &8&l> &7&lYou have already begun your trial! Please use /plotme home to return to your plot.");
				}
			}
		}
		return true;
	}
}
