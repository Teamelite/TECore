package io.teamelite.core.worldarchiver.commands;

import io.teamelite.core.utilities.Utils;
import io.teamelite.core.worldarchiver.WorldArchiverMain;

public class KeyRemoveCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("key-remove")){
			if(sender.hasPermission("worldarchive.remove")){
				if(args.length>=1){
					String key = args[0];
					if(WorldArchiverMain.files.get(key)==null){
						sender.sendMessage("[TE-Core: World-Archiver] The key does not exist!");
						return false;
					} else{
						Utils.deleteDirectory(WorldArchiverMain.files.get(key));
						WorldArchiverMain.files.remove(key);
						WorldArchiverMain.writekeys();
						sender.sendMessage("[TE-Core: World-Archiver] Successfully removed the key.");
						return true;
					}
				}
			} else{
				sender.sendMessage("[TE-Core: World-Archiver] You do not have the permission to use this command!");
				return true;
			}
		}
		return false;
	}
	
}
