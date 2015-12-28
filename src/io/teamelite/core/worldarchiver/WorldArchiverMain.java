package io.teamelite.core.worldarchiver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import io.teamelite.core.utilities.Utils;

public class WorldArchiverMain{
	
	//keeps track of all the files.
	public static HashMap<String, File> files = new HashMap<String,File>();
	
	//save all the set keys
	public static void writekeys(){
		File folder = this.getDataFolder();
		File keys = new File(folder,"keys.txt");
		if(!(keys.exists())){
			try {
				keys.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else{
			BufferedWriter bw = null;
			try{
				bw = new BufferedWriter(new FileWriter(keys));
				for(String key : files.keySet()){
					String save = key+" "+files.get(key).getName();
					bw.write(save);
					bw.newLine();
				}
			} catch(IOException e){
				e.printStackTrace();
				System.out.println("[TE-Core: World-Archiver] An error occured while writing out the keys. Could not finish saving the keys.");
			} finally{
				if(bw!=null){
					try{
						bw.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//load all the set keys
	public static void readkeys(){
		File folder = this.getDataFolder();
		File keys = new File(folder,"keys.txt");
		if(!(keys.exists())){
			try {
				keys.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else{
			BufferedReader br = null;
			try{
				br = new BufferedReader(new FileReader(keys));
				String s = br.readLine();
				while(s!=null){
					String[] splits = s.split(" ");
					File archivedfile = new File(folder,splits[1]);
					if(!(archivedfile.exists())){
						System.out.println("[TE-Core: World-Archiver] File could not be found. File: "+splits[1]);
					} else{
						files.put(splits[0], archivedfile);
					}
					s = br.readLine();
				}
			} catch(IOException e){
				e.printStackTrace();
			} finally{
				if(br!=null){
					try{
						br.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
