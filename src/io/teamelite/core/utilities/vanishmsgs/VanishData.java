package io.teamelite.core.utilities.vanishmsgs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import io.teamelite.core.utilities.Utils;

public class VanishData {
	static File vdF;
	static FileConfiguration vdD;
	
	public static void setup(Plugin pl) {
		if(!Utils.instance().getDataFolder().exists()) {
			try {
				Utils.instance().getDataFolder().mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		vdF = new File(Utils.instance().getDataFolder(), "vanish.yml");
		if(!vdF.exists()) {
			try {
				vdF.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		vdD = YamlConfiguration.loadConfiguration(vdF);
	}
	
	public static FileConfiguration getData() {
		return vdD;
	}
	
	public static void saveData() {
		try { 
			vdD.save(vdF);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
