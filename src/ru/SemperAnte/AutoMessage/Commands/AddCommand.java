package ru.SemperAnte.AutoMessage.Commands;

import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends ManageCommands
{
	 public AddCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute() throws SemperAPIException
	 {
		  try
		  {
				String listname = args[1];
				if (args.length == 2)
				{

					 if (AutoMessage.getConfigUtils().getConfigurationSection("lists").getKeys(true).contains(listname))
					 {
						  sender.sendMessage(AutoMessage.Prefix + " list already created.");
					 }
					 else
					 {
						  AutoMessage.getConfigUtils().set("lists." + listname + ".interval", 150);
						  AutoMessage.getConfigUtils().set("lists." + listname + ".messages", new ArrayList<String>());
						  AutoMessage.getConfigUtils().set("lists." + listname + ".enabled", true);
						  sender.sendMessage(AutoMessage.Prefix + " list created with default params.");
					 }
				}
				else
				{

					 if (!AutoMessage.getConfigUtils().getConfigurationSection("lists").getKeys(true).contains(listname))
					 {
						  sender.sendMessage(AutoMessage.Prefix + " list not exists.");
					 }
					 List<String> messages = AutoMessage.getConfigUtils().getStringList("lists." + listname + ".messages");
					 StringBuilder sb = new StringBuilder(args[2]);
					 for (int i = 3; i < args.length; ++i)
						  sb.append(" ").append(args[i]);
					 String message = sb.toString();
					 messages.add(message);
					 AutoMessage.getConfigUtils().set("lists." + listname + ".messages", messages);
					 sender.sendPrefixedMessage("Done.");
				}
				return true;
		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("/am add <listname> [message]");
		  }
		  return false;
	 }
}
