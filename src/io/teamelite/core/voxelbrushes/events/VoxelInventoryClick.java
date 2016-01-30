package src.io.teamelite.core.voxelbrushes.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import src.io.teamelite.core.utilities.Utils;
import src.io.teamelite.core.utilities.voxelbrushes.TitleManager;

public class VoxelInventoryClick implements Listener {
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (!(e.getInventory().getTitle().contains("TeamElite Brushes"))) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
            p.performCommand("b over d3");
            p.performCommand("v clay");
            p.performCommand("b 8");
            p.sendMessage(Utils.prefix() + ChatColor.RESET + "" + ChatColor.RED + " Brush Set To Overlay Brush 1.");
            TitleManager.createTitle(p, " ", 40, 20, 40, ChatColor.DARK_RED);
            TitleManager.createSubTitle(p, "Brush Selected", 20, 40, 20, ChatColor.DARK_RED);
        }
        if (e.getCurrentItem().getType() == Material.GRASS) {
            p.performCommand("b over d2");
            p.performCommand("v grass");
            p.performCommand("b 8");
            p.sendMessage(Utils.prefix() + ChatColor.RESET + "" + ChatColor.RED + " Brush Set To Overlay Brush 2.");
            TitleManager.createTitle(p, " ", 40, 20, 40, ChatColor.DARK_RED);
            TitleManager.createSubTitle(p, "Brush Selected", 20, 40, 20, ChatColor.DARK_RED);
        }
        if (e.getCurrentItem().getType() == Material.INK_SACK) {
            p.performCommand("b b");
            p.performCommand("b 5");
            p.performCommand("v sand");
            p.sendMessage(Utils.prefix() + ChatColor.RESET + "" + ChatColor.RED + " Brush Set To Mountain Brush.");
            TitleManager.createTitle(p, " ", 40, 20, 40, ChatColor.DARK_RED);
            TitleManager.createSubTitle(p, "Brush Selected", 20, 40, 20, ChatColor.DARK_RED);
        }
        if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
            p.performCommand("b b");
            p.performCommand("b 4");
            p.performCommand("v air");
            p.sendMessage(Utils.prefix() + ChatColor.RESET + "" + ChatColor.RED + " Brush Set To River Brush.");
            TitleManager.createTitle(p, " ", 40, 20, 40, ChatColor.DARK_RED);
            TitleManager.createSubTitle(p, "Brush Selected", 20, 40, 20, ChatColor.DARK_RED);
        }
        p.closeInventory();
        e.setCancelled(true);
    }
	}