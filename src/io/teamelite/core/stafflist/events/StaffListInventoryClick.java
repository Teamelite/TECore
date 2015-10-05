package io.teamelite.core.stafflist.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import io.teamelite.core.stafflist.information.AlpakaWhacker;
import io.teamelite.core.stafflist.information.Axanite;
import io.teamelite.core.stafflist.information.BeMyZelf;
import io.teamelite.core.stafflist.information.Bowser;
import io.teamelite.core.stafflist.information.Creper_face;
import io.teamelite.core.stafflist.information.ImCeline;
import io.teamelite.core.stafflist.information.KellieBreanne;
import io.teamelite.core.stafflist.information.KraZ__;
import io.teamelite.core.stafflist.information.Life855;
import io.teamelite.core.stafflist.information.MrBestDeni;
import io.teamelite.core.stafflist.information.Nathan;
import io.teamelite.core.stafflist.information.PleaseTeamIFan;
import io.teamelite.core.stafflist.information.Tumblrr;
import io.teamelite.core.stafflist.information.Violetheart17;
import io.teamelite.core.stafflist.information.Wolf1278;
import io.teamelite.core.stafflist.information.Zarx_;
import io.teamelite.core.stafflist.information._Jimmer;
import io.teamelite.core.stafflist.information.mfunGamer;

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
       if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "_Jimmer")) {
        	_Jimmer.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "KellieBreanne")) {
        	KellieBreanne.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "Bowser")) {
        	Bowser.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "Creper_face")) {
        	Creper_face.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.AQUA + "KraZ__")) {
        	KraZ__.sendInformation(p);
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
        if(dN.equals(ChatColor.RED + "ImCeline")) {
        	ImCeline.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "Tumblrr")) {
        	Tumblrr.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "Violetheart17")) {
        	Violetheart17.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "PleaseTeamIFan")) {
        	PleaseTeamIFan.sendInformation(p);
   	   	}
        if(dN.equals(ChatColor.RED + "Zarx_")) {
        	Zarx_.sendInformation(p);
   	   	}
	}
}