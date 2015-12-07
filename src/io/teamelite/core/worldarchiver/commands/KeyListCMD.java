package io.teamelite.core.worldarchiver.commands;

import io.teamelite.core.utilities.Utils;
import io.teamelite.core.worldarchiver.WorldArchiverMain;

public class KeyListCMD implements CommandExecutor{
	
	if(cmd.getName().equalsIgnoreCase("key-list")){
		if(sender.hasPermission("worldarchive.keys")){
			if(WorldArchiverMain.files.keySet().size()==0){
				sender.sendMessage("[TE-Core: World-Archiver] There are no keys set.");
				return true;
			}
			sender.sendMessage("[TE-Core: World-Archiver] Keys:");
			for(String s : WorldArchiverMain.files.keySet()){
				sender.sendMessage("- "+s);
			}
			return true;
		} else{
			sender.sendMessage("[TE-Core: World-Archiver] You do not have the permission to use this command!");
			return true;
		}
	}
	
}
