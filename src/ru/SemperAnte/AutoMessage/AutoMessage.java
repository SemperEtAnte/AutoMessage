package ru.SemperAnte.AutoMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.SemperAnte.AutoMessage.Commands.ManageCommands;
import ru.SemperAnte.AutoMessage.Utils.TasksUtil;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.MainAPI;
import ru.SemperAnte.plugins.API.Utils.ConfigUtils;

public class AutoMessage extends JavaPlugin
{
	 private static ConfigUtils CU;
	 public static String Prefix = ChatColor.translateAlternateColorCodes('&', "&e[AutoMessage]");

	 @Override
	 public void onEnable()
	 {
		  if (!MainAPI.isMustEnable(this))
				return;
		  CU = new ConfigUtils(this);
		  new TasksUtil(this).runAllTasks();
	 }

	 @Override
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	 {
		  try
		  {
				return new ManageCommands(new AutoMessageSender(sender), args).isDone();
		  }
		  catch (SemperAPIException e)
		  {
				sender.sendMessage("Command not executed =(");
				e.printStackTrace();
		  }
		  return false;
	 }

	 public static ConfigUtils getConfigUtils()
	 {
		  return CU;
	 }

}
