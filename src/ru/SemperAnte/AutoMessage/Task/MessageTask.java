package ru.SemperAnte.AutoMessage.Task;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ru.SemperAnte.AutoMessage.AutoMessage;

import java.util.List;
import java.util.Random;

public class MessageTask implements Runnable
{

	 private String name;

	 public MessageTask(String name)
	 {
		  this.name = name;
	 }

	 @Override
	 public void run()
	 {
		  List<String> messages = AutoMessage.getConfigUtils().getStringList("lists." + name + ".messages");
		  int rand = new Random().nextInt(messages.size());
		  Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', messages.get(rand)), "automessage.receive." + name);
		  for (String s : AutoMessage.getConfigUtils().getStringList("lists." + name + ".commands"))
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s.substring(1));
	 }
}
