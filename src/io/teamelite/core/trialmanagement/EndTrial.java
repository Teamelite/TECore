package io.teamelite.core.trialmanagement;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.trialmanagement.TrialData;

public class EndTrial implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("endtrial")) {
			if(!sender.hasPermission("teamelite.endtrial")) {
				MessageManager.sendPlayerMessage(p, "&a&lTrial&8&l> &7&lYou do not have the sufficient permissions to end your trial!");
			} else {
				if(TrialData.getData().getBoolean("trial-begun." + p.getName()) == true) {
					MessageManager.sendSlackMessage("<!group> " + sender.getName() + " has finished their trial! Type /plotme home " + sender.getName() + " in the trial-plots world to begin your review!", "https://hooks.slack.com/services/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", "teamelite-trialbot", null);
					MessageManager.sendPlayerMessage(p, "&a&lTrial&8&l> &7&lYou have finished your trial! Please do not make any changes to your plot from now on without alerting a member of staff.");
					TrialData.getData().set("trial-begun." + p.getName(), null);
					TrialData.saveData();
				} else {
					MessageManager.sendPlayerMessage(p, "&a&lTrial &8&l> &7&lYou have no trial to end!");
				}
			}
		}
	return true;
	}				
}