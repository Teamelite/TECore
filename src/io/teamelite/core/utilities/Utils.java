package io.teamelite.core.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

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
}
