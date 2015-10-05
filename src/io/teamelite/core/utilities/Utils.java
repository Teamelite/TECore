package io.teamelite.core.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Utils {
	public static String prefix() {
		String p = "§4§lTeam§6§lElite §8§l>";
		ChatColor.translateAlternateColorCodes('§', p);
		return p;
	}
	
	public static Plugin instance() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("TECore");
		return p;
	}
}
