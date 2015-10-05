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
		
		ItemStack jimmerHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta jimmerHeadMeta = (SkullMeta) jimmerHead.getItemMeta();
		jimmerHeadMeta.setOwner("_Jimmer");
		jimmerHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "_Jimmer");
		jimmerHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		jimmerHead.setItemMeta(jimmerHeadMeta);
		inv.setItem(3, jimmerHead);
		
		ItemStack kellieHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta kellieHeadMeta = (SkullMeta) kellieHead.getItemMeta();
		kellieHeadMeta.setOwner("KellieBreanne");
		kellieHeadMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "KellieBreanne");
		kellieHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		kellieHead.setItemMeta(kellieHeadMeta);
		inv.setItem(4, kellieHead);
		
		ItemStack bennyHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta bennyHeadMeta = (SkullMeta) bennyHead.getItemMeta();
		bennyHeadMeta.setOwner("Bowser");
		bennyHeadMeta.setDisplayName(ChatColor.AQUA + "Bowser");
		bennyHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		bennyHead.setItemMeta(bennyHeadMeta);
		inv.setItem(5, bennyHead);
		
		ItemStack creperHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta creperHeadMeta = (SkullMeta) creperHead.getItemMeta();
		creperHeadMeta.setOwner("Creper_face");
		creperHeadMeta.setDisplayName(ChatColor.AQUA + "Creper_face");
		creperHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		creperHead.setItemMeta(creperHeadMeta);
		inv.setItem(6, creperHead);
		
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
		
		ItemStack celineHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta celineHeadMeta = (SkullMeta) celineHead.getItemMeta();
		celineHeadMeta.setOwner("ImCeline");
		celineHeadMeta.setDisplayName(ChatColor.RED + "ImCeline");
		celineHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		celineHead.setItemMeta(celineHeadMeta);
		inv.setItem(13, celineHead);
		
		ItemStack johnHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta johnHeadMeta = (SkullMeta) johnHead.getItemMeta();
		johnHeadMeta.setOwner("Tumblrr");
		johnHeadMeta.setDisplayName(ChatColor.RED + "Tumblrr");
		johnHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		johnHead.setItemMeta(johnHeadMeta);
		inv.setItem(14, johnHead);
		
		ItemStack violetHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta violetHeadMeta = (SkullMeta) violetHead.getItemMeta();
		violetHeadMeta.setOwner("Violetheart17");
		violetHeadMeta.setDisplayName(ChatColor.RED + "Violetheart17");
		violetHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		violetHead.setItemMeta(violetHeadMeta);
		inv.setItem(15, violetHead);
		
		ItemStack zachHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta zachHeadMeta = (SkullMeta) zachHead.getItemMeta();
		zachHeadMeta.setOwner("PleaseTeamIFan");
		zachHeadMeta.setDisplayName(ChatColor.RED + "PleaseTeamIFan");
		zachHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		zachHead.setItemMeta(zachHeadMeta);
		inv.setItem(16, zachHead);
		
		ItemStack zarxHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta zarxHeadMeta = (SkullMeta) zarxHead.getItemMeta();
		zarxHeadMeta.setOwner("Zarx_");
		zarxHeadMeta.setDisplayName(ChatColor.RED + "Zarx_");
		zarxHeadMeta.setLore(Arrays.asList(ChatColor.GOLD + "Left-Click to learn more about me!"));
		zarxHead.setItemMeta(zarxHeadMeta);
		inv.setItem(17, zarxHead);
		
		return inv;
	}
}
