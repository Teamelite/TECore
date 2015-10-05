package io.teamelite.core;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.teamelite.core.other.AnnounceCMD;
import io.teamelite.core.other.DoneCMD;
import io.teamelite.core.other.ListAliasCMD;
import io.teamelite.core.other.PingCMD;
import io.teamelite.core.other.StaffChatCMD;
import io.teamelite.core.stafflist.StaffList;
import io.teamelite.core.stafflist.events.StaffListInventoryClick;
import io.teamelite.core.stafflist.events.StaffListInventoryCreative;
import io.teamelite.core.tablist.events.PlayerJoinTabListChange;
import io.teamelite.core.tablist.utils.TabListChanger;
import io.teamelite.core.trialmanagement.BeginTrial;
import io.teamelite.core.trialmanagement.EndTrial;
import io.teamelite.core.utilities.trialmanagement.TrialData;
import io.teamelite.core.voxelbrushes.Voxel;
import io.teamelite.core.voxelbrushes.events.VoxelInventoryClick;

public class Core extends JavaPlugin {
	/* 
	 * TO-DO:
	 * - Import alert, autoflower
	 * - Once everything is tested and working, change the webhooks for announce & trial management back to the TeamElite Slack.
	 */
	public void onEnable() {
		//Event Registering
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinTabListChange(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VoxelInventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffListInventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffListInventoryCreative(), this);
		
		//Command Registering
		getCommand("done").setExecutor(new DoneCMD());
		getCommand("l").setExecutor(new ListAliasCMD());
		getCommand("announce").setExecutor(new AnnounceCMD());
		getCommand("begintrial").setExecutor(new BeginTrial());
		getCommand("endtrial").setExecutor(new EndTrial());
		getCommand("stafflist").setExecutor(new StaffList());
		getCommand("voxel").setExecutor(new Voxel());
		getCommand("ping").setExecutor(new PingCMD());
		getCommand("staffchat").setExecutor(new StaffChatCMD());
		
		//Miscellaneous
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			TabListChanger.setHeaderAndFooter(p, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Team" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Elite" + ChatColor.RED + ChatColor.BOLD.toString() + " Build Server", ChatColor.GOLD + ChatColor.BOLD.toString() + "    http://www.mcteamelite.com");
		}
		
		TrialData.setup(this);
		
		if(Bukkit.getServer().getPluginManager().getPlugin("VoxelSniper") == null) {
			getLogger().log(Level.SEVERE, "VoxelSniper was not found; disabling TECore!");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
	}
}
