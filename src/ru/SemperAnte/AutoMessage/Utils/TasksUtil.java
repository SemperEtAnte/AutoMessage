package ru.SemperAnte.AutoMessage.Utils;

import org.bukkit.Bukkit;
import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.AutoMessage.Task.MessageTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TasksUtil
{
	 private static Map<String, Integer> ids = new HashMap<>();
	 private static AutoMessage plugin;

	 public TasksUtil(AutoMessage pl)
	 {
		  plugin = pl;
	 }

	 public static void runAllTasks()
	 {
		  Set<String> names = AutoMessage.getConfigUtils().getConfigurationSection("lists").getKeys(true);
		  for (String name : names)
				if (AutoMessage.getConfigUtils().getBoolean("lists." + name + ".enabled"))
					 startTask(name);
	 }

	 public static void stopAllTasks()
	 {
		  for (String taskName : ids.keySet())
				Bukkit.getScheduler().cancelTask(ids.get(taskName));
		  ids.clear();
	 }

	 public static boolean isTaskRunned(String listname)
	 {
		  return ids.containsKey(listname);
	 }

	 public static void stopTask(String name)
	 {
		  if (ids.get(name) != null)
		  {
				Bukkit.getScheduler().cancelTask(ids.get(name));
				ids.remove(name);
				AutoMessage.getConfigUtils().set("lists." + name + ".enabled", false);
		  }
	 }

	 public static void startTask(String name)
	 {
		  if (ids.get(name) == null)
		  {
				int interval = AutoMessage.getConfigUtils().getInt("lists." + name + ".interval") * 20;
				int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new MessageTask(name), interval, interval);
				ids.put(name, id);
				AutoMessage.getConfigUtils().set("lists." + name + ".enabled", true);
		  }
	 }
}
