package io.teamelite.core.utilities.stafflist;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class InventorySetup {
	public static Inventory inv() {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, ChatColor.DARK_RED + "Team" + ChatColor.GOLD + "Elite" + ChatColor.RED + " Staff List");
		
		ItemStack daveHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta daveHeadMeta = (SkullMeta) daveHead.getItemMeta();
		daveHeadMeta.setOwner("Life855");
		daveHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Life855");
		daveHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		daveHead.setItemMeta(daveHeadMeta);
		inv.setItem(0, daveHead);
		
		ItemStack deniHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta deniHeadMeta = (SkullMeta) deniHead.getItemMeta();
		deniHeadMeta.setOwner("MrBestDeni");
		deniHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "MrBestDeni");
		deniHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		deniHead.setItemMeta(deniHeadMeta);
		inv.setItem(1, deniHead);
		
		ItemStack jamieHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta jamieHeadMeta = (SkullMeta) jamieHead.getItemMeta();
		jamieHeadMeta.setOwner("AlpakaWhacker");
		jamieHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "AlpakaWhacker");
		jamieHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		jamieHead.setItemMeta(jamieHeadMeta);
		inv.setItem(2, jamieHead);
		
		ItemStack benHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta benHeadMeta = (SkullMeta) benHead.getItemMeta();
		benHeadMeta.setOwner("Benji");
		benHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Benji");
		benHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		benHead.setItemMeta(benHeadMeta);
		inv.setItem(3, benHead);
		
		ItemStack jimmerHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta jimmerHeadMeta = (SkullMeta) jimmerHead.getItemMeta();
		jimmerHeadMeta.setOwner("_Jimmer");
		jimmerHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "_Jimmer");
		jimmerHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		jimmerHead.setItemMeta(jimmerHeadMeta);
		inv.setItem(4, jimmerHead);
		
		ItemStack kellieHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta kellieHeadMeta = (SkullMeta) kellieHead.getItemMeta();
		kellieHeadMeta.setOwner("KellieBreanne");
		kellieHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "KellieBreanne");
		kellieHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		kellieHead.setItemMeta(kellieHeadMeta);
		inv.setItem(5, kellieHead);
		
		ItemStack bennyHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta bennyHeadMeta = (SkullMeta) bennyHead.getItemMeta();
		bennyHeadMeta.setOwner("Bowser");
		bennyHeadMeta.setDisplayName(ChatColor.AQUA + "Bowser");
		bennyHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		bennyHead.setItemMeta(bennyHeadMeta);
		inv.setItem(6, bennyHead);
		
		ItemStack krazHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta krazHeadMeta = (SkullMeta) krazHead.getItemMeta();
		krazHeadMeta.setOwner("KraZ__");
		krazHeadMeta.setDisplayName(ChatColor.AQUA + "KraZ__");
		krazHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		krazHead.setItemMeta(krazHeadMeta);
		inv.setItem(7, krazHead);
		
		ItemStack mfunHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta mfunHeadMeta = (SkullMeta) mfunHead.getItemMeta();
		mfunHeadMeta.setOwner("mfunGamer");
		mfunHeadMeta.setDisplayName(ChatColor.AQUA + "mfunGamer");
		mfunHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		mfunHead.setItemMeta(mfunHeadMeta);
		inv.setItem(8, mfunHead);
		
		ItemStack wolfHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta wolfHeadMeta = (SkullMeta) wolfHead.getItemMeta();
		wolfHeadMeta.setOwner("wolf1278");
		wolfHeadMeta.setDisplayName(ChatColor.AQUA + "Wolf1278");
		wolfHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		wolfHead.setItemMeta(wolfHeadMeta);
		inv.setItem(9, wolfHead);
		
		ItemStack axaniteHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta axaniteHeadMeta = (SkullMeta) axaniteHead.getItemMeta();
		axaniteHeadMeta.setOwner("Axanite");
		axaniteHeadMeta.setDisplayName(ChatColor.AQUA + "Axanite");
		axaniteHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		axaniteHead.setItemMeta(axaniteHeadMeta);
		inv.setItem(10, axaniteHead);
		
		ItemStack nathanHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta nathanHeadMeta = (SkullMeta) nathanHead.getItemMeta();
		nathanHeadMeta.setOwner("001nathan100");
		nathanHeadMeta.setDisplayName(ChatColor.RED + "001nathan100");
		nathanHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		nathanHead.setItemMeta(nathanHeadMeta);
		inv.setItem(11, nathanHead);
		
		ItemStack zelfHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta zelfHeadMeta = (SkullMeta) zelfHead.getItemMeta();
		zelfHeadMeta.setOwner("BeMyZelf");
		zelfHeadMeta.setDisplayName(ChatColor.RED + "BeMyZelf");
		zelfHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		zelfHead.setItemMeta(zelfHeadMeta);
		inv.setItem(12, zelfHead);
		
		ItemStack zachHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta zachHeadMeta = (SkullMeta) zachHead.getItemMeta();
		zachHeadMeta.setOwner("PleaseTeamIFan");
		zachHeadMeta.setDisplayName(ChatColor.RED + "PleaseTeamIFan");
		zachHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		zachHead.setItemMeta(zachHeadMeta);
		inv.setItem(13, zachHead);
		
		return inv;
	}
}
