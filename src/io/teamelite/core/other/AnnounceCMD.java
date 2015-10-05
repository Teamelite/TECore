package io.teamelite.core.other;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.MessageManager;
import io.teamelite.core.utilities.Utils;

public class AnnounceCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("announce")) {
			if(!sender.hasPermission("teamelite.announce")) {
				sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " You do not have the sufficient permissions to send an announcement!");
			} else {	
				if(args.length == 0) {
					sender.sendMessage(Utils.prefix() + ChatColor.LIGHT_PURPLE + " Announcement is missing! Correct Usage: /announce <slack|ingame|both> <message>");
				}
				if(args.length >= 2) {
					if(args[0].equalsIgnoreCase("both")) {
						StringBuilder sb = new StringBuilder();
						for(int i=1; i<args.length; i++) {
						    sb.append(args[i]).append(" ");
						}
						String s = sb.toString();
						MessageManager.sendSlackMessage("<!channel> " + s, "https://hooks.slack.com/services/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", "teamelite-announcementbot", "https://s3-us-west-2.amazonaws.com/slack-files2/avatars/2015-07-20/7931814832_e6ba14fceed622191886_48.jpg");
						MessageManager.sendServerBroadcast("&5&lAnnouncement &8&l> " + "&d&l" + s);
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Announcement Sent: " + ChatColor.ITALIC.toString() + s);
						}
					if(args[0].equalsIgnoreCase("slack")) {
						StringBuilder sb = new StringBuilder();
						for(int i=1; i<args.length; i++) {
						    sb.append(args[i]).append(" ");
						}
						String s = sb.toString();
						MessageManager.sendSlackMessage("<!channel> " + s, "https://hooks.slack.com/services/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", "teamelite-announcementbot", "https://s3-us-west-2.amazonaws.com/slack-files2/avatars/2015-07-20/7931814832_e6ba14fceed622191886_48.jpg");
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Announcement Sent: " + ChatColor.ITALIC.toString() + s);
						}
					if(args[0].equalsIgnoreCase("ingame")) {
						StringBuilder sb = new StringBuilder();
						for(int i=1; i<args.length; i++) {
						    sb.append(args[i]).append(" ");
						}
						String s = sb.toString();
						MessageManager.sendServerBroadcast("&5&lAnnouncement &8&l> " + "&d&l" + s);
						MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Announcement Sent: " + ChatColor.ITALIC.toString() + s);
						}
					}
				}
		}
		return true;
	}
}