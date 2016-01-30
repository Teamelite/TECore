package src.io.teamelite.core.other.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
	
	public class ListAliasCMD implements CommandExecutor {
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				Player p = (Player) sender;
				if(cmd.getName().equalsIgnoreCase("l")) {
					p.performCommand("list");
				}
					return true;
				}
			}
