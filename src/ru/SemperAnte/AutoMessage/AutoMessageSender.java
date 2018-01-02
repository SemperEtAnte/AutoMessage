package ru.SemperAnte.AutoMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import ru.SemperAnte.plugins.API.Interface.Classes.Sender;

public class AutoMessageSender extends Sender
{
	 public AutoMessageSender(CommandSender sender)
	 {
		  super(sender);
	 }

	 @Override
	 public void sendPrefixedMessage(String message)
	 {
		  base.sendMessage(ChatColor.translateAlternateColorCodes('&', AutoMessage.Prefix + ChatColor.GOLD + message));
	 }
}
