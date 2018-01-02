package ru.SemperAnte.AutoMessage.Utils;

import ru.SemperAnte.AutoMessage.AutoMessage;

public class Utils
{
	 public static boolean hasListWithName(String name)
	 {
		  return AutoMessage.getConfigUtils().getConfigurationSection("lists").getKeys(true).contains(name);
	 }
}
