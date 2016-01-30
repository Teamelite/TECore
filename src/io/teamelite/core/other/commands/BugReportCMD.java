package src.io.teamelite.core.other.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.MessageManager;
import src.io.teamelite.core.utilities.Utils;

public class BugReportCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("bug")) {
			if(args.length == 0) {
				MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Please provide some information in regards to the bug you are reporting. Correct Usage: /bug <information>");
			} else {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<args.length; i++) {
					sb.append(args[i]).append(" ");
				}
				String msg = sb.toString();
				Date now = new Date();
				SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyy");
				String date = f.format(now);
				MessageManager.sendSlackMessage("*New Bug Report Submitted*\n_Username_: " + p.getName() + "\n_Message_: " + msg + "\n_Date Reported_: " + date, "https://hooks.slack.com/services/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", "TeamElite Bug Report Bot", null);
		        MessageManager.sendPlayerMessage(p, Utils.prefix() + ChatColor.LIGHT_PURPLE + " Your report has been sent to the Developers!");
			}
		}
		return true;
	}
}
