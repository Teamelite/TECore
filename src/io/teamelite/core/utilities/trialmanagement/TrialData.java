package src.io.teamelite.core.utilities.trialmanagement;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import src.io.teamelite.core.utilities.Utils;

public class TrialData {
	static File tdF;
	static FileConfiguration tdD;
	
	public static void setup(Plugin pl) {
		if(!Utils.instance().getDataFolder().exists()) {
			try {
				Utils.instance().getDataFolder().mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		tdF = new File(Utils.instance().getDataFolder(), "trial-data.txt");
		if(!tdF.exists()) {
			try {
				tdF.createNewFile();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		
		tdD = YamlConfiguration.loadConfiguration(tdF);
	}
	
	public static FileConfiguration getData() {
		return tdD;
	}
	
	public static void saveData() {
		try {
			tdD.save(tdF);
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
