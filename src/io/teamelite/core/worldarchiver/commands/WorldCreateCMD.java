package io.teamelite.core.worldarchiver.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.WorldCreator;
import org.bukkit.plugin.Plugin;

import io.teamelite.core.utilities.Utils;
import io.teamelite.core.worldarchiver.WorldArchiverMain;

public class WorldCreateCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("world-create")){
			if(sender.hasPermission(" worldarchive.create")){
				String name = null;
				String key = null;
				if(args.length==1){
					key = args[0];
				} else if(args.length>=2){
					name = args[1];
					key = args[0];
				}
				if(key==null){
					return false;
				}
				File archive = WorldArchiverMain.files.get(key);
				if(archive==null){
					sender.sendMessage("[TE-Core: 	World-Archiver] This key does not exist.");
					return false;
				}
				if(name==null){
					name=archive.getName();
				}
				if(this.getServer().getWorld(name)!=null){
					sender.sendMessage("[TE-Core: World-Archiver] A world with the give name: "+name+", does already exist.");
					return false;
				}
				File world = new File(name);
				try{
					Utils.copyFile(archive, world);
				} catch(IOException e){
					sender.sendMessage("[TE-Core: World-Archiver] An error occured. Please check the console for further information.");
					e.printStackTrace();
					return true;
				}
				this.getServer().createWorld(new WorldCreator(name));
				Plugin[] plugs = this.getServer().getPluginManager().getPlugins();
				for(Plugin plu : plugs){
					if(plu.getName().equals("Multiverse-Core")){
						plu.onDisable();
						plu.onEnable();
					}
				}
				sender.sendMessage("TE-Core: [World-Archiver] World successfully created!");
				return true;
			} else{
				sender.sendMessage("[TE-Core: World-Archiver] You do not have the permission to use this command!");
				return true;
			}
		}
		return false;
	}
	
}
