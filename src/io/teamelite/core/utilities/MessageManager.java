package io.teamelite.core.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import io.teamelite.core.utilities.slack.SlackApi;
import io.teamelite.core.utilities.slack.SlackMessage;
import net.md_5.bungee.api.ChatColor;

public class MessageManager {
	public static void sendPlayerMessage(Player reciever, String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		reciever.sendMessage(msg);
	}
	
	public static void sendServerBroadcast(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		Bukkit.getServer().broadcastMessage(msg);
	}
	
	public static void sendSlackMessage(String message, String webhook, String botname, String avatar_url) {
		SlackApi api = new SlackApi(webhook);
		SlackMessage msg = new SlackMessage();
		msg.setIcon(avatar_url);
		msg.setText(message);
		msg.setUsername(botname);
		msg.setUnfurlLinks(true);
		msg.setUnfurlMedia(true);
		api.call(msg);
	}
}
