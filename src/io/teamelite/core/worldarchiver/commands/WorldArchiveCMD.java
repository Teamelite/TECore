package io.teamelite.core.worldarchiver.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.Utils;
import io.teamelite.core.worldarchiver.WorldArchiverMain;

public class WolrdArchiveCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("world-archive")){
			if(sender.hasPermission("worldarchive.archive")){
				String name = null;
				String key = null;
				if(args.length==0 && sender instanceof Player){
					name = ((Player)sender).getWorld().getName();
					key = name;
				} else if(args.length==1){
					name = args[0];
					key = name;
				} else if(args.length>=2){
					name = args[0];
					key = args[1];
				}
				if(name==null||key==null){
					return false;
				}
				File world = new File(name);
				if(!(world.exists())){
					sender.sendMessage("[TE-Core: World-Archiver] The world does not exist!");
					return false;
				}
				if(WorldArchiverMain.files.keySet().contains(key)){
					sender.sendMessage("[TE-Core: World-Archiver] Error: Duplication of a key!");
					return false;
				}
				for(String filekey : WorldArchiverMain.files.keySet()){
					if(WorldArchiverMain.files.get(filekey).getName().equals(world.getName())){
						sender.sendMessage("[TE-Core: World-Archiver] Error: There is already an archived world with the same name!");
						return false;
					}
				}
				World w = this.getServer().getWorld(name);
				World fallback = this.getServer().getWorld(this.getConfig().getString("WorldArchive.fallback"));
				if(fallback==null){
					sender.sendMessage("[TE-Core: World-Archiver] Error: The fallback world does not exist!");
					return true;
				}
				if(w.equals(fallback)){
					sender.sendMessage("[TE-Core: World-Archiver] You can not archive the fallback server.");
					return false;
				}
				List<Player> pl = w.getPlayers();
				ArrayList<Location> ll = new ArrayList<Location>();
				for(Player p : pl){
					p.sendMessage("[TE-Core: WorldArchive] This world has to be reloaded. You will be teleported back shortly!");
					ll.add(p.getLocation());
					p.teleport(fallback.getSpawnLocation());
				}
				w.save();
				this.getServer().unloadWorld(w, true);
				File worldarchive = new File(this.getDataFolder()+File.separator+name);
				try{
					Utils.copyFile(world, worldarchive);
				} catch(IOException e){
					sender.sendMessage("[TE-Core: World-Archiver] An error occured. Please check the console for further information.");
					e.printStackTrace();
					return true;
				}
				this.getServer().createWorld(new WorldCreator(name));
				int x = 0;
				for(Player p : pl){
					p.teleport(ll.get(x));
					x++;
				}
				WorldArchiverMain.files.put(key, worldarchive);
				WorldArchiverMain.writekeys();
				sender.sendMessage("[TE-Core: World-Archiver] Successfully archived the world. The key is: "+key);
				return true;
			} else{
				sender.sendMessage("[TE-Core: World-Archiver] You do not have the permission to use this command!");
				return true;
			}
		}
		return false;
	}
	
}
