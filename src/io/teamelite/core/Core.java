package src.io.teamelite.core;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import src.io.teamelite.core.autoflower.commands.AutoFlower;
import src.io.teamelite.core.autoflower.commands.AutoSnow;
import src.io.teamelite.core.autoflower.commands.ClearFlower;
import src.io.teamelite.core.autoflower.commands.ClearSnow;
import src.io.teamelite.core.other.commands.AnnounceCMD;
import src.io.teamelite.core.other.commands.BugReportCMD;
import src.io.teamelite.core.other.commands.CoreInformationCMD;
import src.io.teamelite.core.other.commands.DoneCMD;
import src.io.teamelite.core.other.commands.ListAliasCMD;
import src.io.teamelite.core.other.commands.RestartServerCMD;
import src.io.teamelite.core.other.commands.SayCMD;
import src.io.teamelite.core.other.commands.StaffChatCMD;
import src.io.teamelite.core.stafflist.StaffList;
import src.io.teamelite.core.stafflist.events.StaffListInventoryClick;
import src.io.teamelite.core.stafflist.events.StaffListInventoryCreative;
import src.io.teamelite.core.tablist.events.PlayerJoinTabListChange;
import src.io.teamelite.core.tablist.utils.TabListChanger;
import src.io.teamelite.core.trialmanagement.BeginTrial;
import src.io.teamelite.core.trialmanagement.EndTrial;
import src.io.teamelite.core.utilities.trialmanagement.TrialData;
import src.io.teamelite.core.utilities.vanishmsgs.VanishData;
import src.io.teamelite.core.vanishmsgs.commands.CustomVanishMessageCMD;
import src.io.teamelite.core.vanishmsgs.events.VanishPlayerJoinEVENT;
import src.io.teamelite.core.vanishmsgs.events.VanishPreProcessEVENT;
import src.io.teamelite.core.voxelbrushes.Voxel;
import src.io.teamelite.core.voxelbrushes.events.VoxelInventoryClick;

public class Core extends JavaPlugin {
	public void onEnable() {
		//Event Registering
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinTabListChange(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VoxelInventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffListInventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffListInventoryCreative(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VanishPreProcessEVENT(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VanishPlayerJoinEVENT(), this);
		
		//Command Registering
		getCommand("done").setExecutor(new DoneCMD());
		getCommand("l").setExecutor(new ListAliasCMD());
		getCommand("announce").setExecutor(new AnnounceCMD());
		getCommand("begintrial").setExecutor(new BeginTrial());
		getCommand("endtrial").setExecutor(new EndTrial());
		getCommand("stafflist").setExecutor(new StaffList());
		getCommand("voxel").setExecutor(new Voxel());
		getCommand("staffchat").setExecutor(new StaffChatCMD());
		getCommand("autoflower").setExecutor(new AutoFlower());
		getCommand("clearflower").setExecutor(new ClearFlower());
		getCommand("autosnow").setExecutor(new AutoSnow());
		getCommand("clearsnow").setExecutor(new ClearSnow());
		getCommand("say").setExecutor(new SayCMD());
		getCommand("restartserver").setExecutor(new RestartServerCMD());
		getCommand("vanishmessage").setExecutor(new CustomVanishMessageCMD());
		getCommand("information").setExecutor(new CoreInformationCMD());
		getCommand("bug").setExecutor(new BugReportCMD());
		
		//Miscellaneous
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			TabListChanger.setHeaderAndFooter(p, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Team" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Elite" + ChatColor.RED + ChatColor.BOLD.toString() + " Build Server", ChatColor.GOLD + ChatColor.BOLD.toString() + "    http://www.mcteamelite.com");
		}
		
		TrialData.setup(this);
		VanishData.setup(this);

		if(Bukkit.getServer().getPluginManager().getPlugin("VoxelSniper") == null) {
			getLogger().log(Level.SEVERE, "VoxelSniper was not found; disabling TECore!");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
	}
}