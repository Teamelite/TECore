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
	
	
	//to copy a file to another place
	public static void copyFile(File source, File dest) throws IOException{
		//to make sure this file is not used by the server atm (important for worlds)
		ArrayList<String> skip = new ArrayList<String>(Arrays.asList("uid.dat","session.dat"));
		if(!(skip.contains(source.getName()))){
			if(source.isDirectory()){
				if(!(dest.exists())){
					dest.mkdirs();
				}
				String[] files = source.list();
				for(String file : files){
					File sourceFile = new File(source, file);
					File destFile = new File(dest, file);
					copyFile(sourceFile, destFile);	
				}
			} else{
				InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int len;
				while((len = in.read(buffer))>0){
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
			}
		}
	}
	
	public static void deleteDirectory(File directory){
		for(File file : directory.listFiles()){
			if(file.isDirectory()){
				deleteDirectory(file);
			} else{
				file.delete();
			}
		}
		directory.delete();
	}
}
