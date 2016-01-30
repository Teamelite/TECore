package src.io.teamelite.core.stafflist.information;

import org.bukkit.entity.Player;

import src.io.teamelite.core.utilities.MessageManager;

public class Bowser {	
	public static String name() {
		String name = "Bowser";
		return name;
	}
	
	public static String ingamename() {
		String ingamename = "Bowser";
		return ingamename;
	}
	
	public static String rank() {
		String rank = "TeamSpeak Developer";
		return rank;
	}

	public static String roles() {
		String roles = "TeamSpeak Management";
		return roles;
	}
	
	public static String description() {
		String description = "Manages the official team TeamSpeak and fixes issues which arise.";
		return description;
	}
	
	public static String contact() {
		String contact = "TeamSpeak (teamelite.io)";
		return contact;
	}
	
	// Send this information.
	public static void sendInformation(Player p) {
		MessageManager.sendPlayerMessage(p, "&4&lName &8&l» &r&6" + name());
		MessageManager.sendPlayerMessage(p, "&4&lIGN &8&l» &r&6" + ingamename());
		MessageManager.sendPlayerMessage(p, "&4&lRank &8&l» &r&6" + rank());
		MessageManager.sendPlayerMessage(p, "&4&lRoles &8&l» &r&6" + roles());
		MessageManager.sendPlayerMessage(p, "&4&lDescription &8&l» &r&6" + description());
		MessageManager.sendPlayerMessage(p, "&4&lPreferred Contact Methods &8&l» &r&6" + contact());
	}
}