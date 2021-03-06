package src.io.teamelite.core.stafflist.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import src.io.teamelite.core.stafflist.information.AlpakaWhacker;
import src.io.teamelite.core.stafflist.information.Axanite;
import src.io.teamelite.core.stafflist.information.BeMyZelf;
import src.io.teamelite.core.stafflist.information.Benji;
import src.io.teamelite.core.stafflist.information.Bowser;
import src.io.teamelite.core.stafflist.information.KellieBreanne;
import src.io.teamelite.core.stafflist.information.Life855;
import src.io.teamelite.core.stafflist.information.MrBestDeni;
import src.io.teamelite.core.stafflist.information.Nathan;
import src.io.teamelite.core.stafflist.information.PleaseTeamIFan;
import src.io.teamelite.core.stafflist.information.Wolf1278;
import src.io.teamelite.core.stafflist.information._Jimmer;
import src.io.teamelite.core.stafflist.information.mfunGamer;

public class StaffListInventoryClick implements Listener {
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(!(e.getInventory().getName().equals(ChatColor.DARK_RED + "Team" + ChatColor.GOLD + "Elite" + ChatColor.RED + " Staff List"))) {
			return;
		}
		
		if(e.getCurrentItem().getType() != Material.SKULL_ITEM) {
			e.setCancelled(true);
			p.closeInventory();
    		return;
    	}
		
		String dN = e.getCurrentItem().getItemMeta().getDisplayName();
        e.setCancelled(true);
        p.closeInventory();
        		
        if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Life855")) {
        	Life855.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "MrBestDeni")) {
        	MrBestDeni.sendInformation(p);
   	   	}
       	if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "AlpakaWhacker")) {
        	AlpakaWhacker.sendInformation(p);
       	}
       	if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Benji")) {
        	Benji.sendInformation(p);
       	}
       	if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "_Jimmer")) {
        	_Jimmer.sendInformation(p);
       	}
       	if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "KellieBreanne")) {
    	   KellieBreanne.sendInformation(p);
       	}
        if(dN.equals(ChatColor.AQUA + "Bowser")) {
        	Bowser.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "mfunGamer")) {
        	mfunGamer.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "Wolf1278")) {
        	Wolf1278.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "Axanite")) {
        	Axanite.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "001nathan100")) {
        	Nathan.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "BeMyZelf")) {
        	BeMyZelf.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "PleaseTeamIFan")) {
        	PleaseTeamIFan.sendInformation(p);
   	   	}
	}
}