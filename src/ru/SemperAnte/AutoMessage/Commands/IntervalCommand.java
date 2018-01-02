package ru.SemperAnte.AutoMessage.Commands;

import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.AutoMessage.Utils.Utils;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

public class IntervalCommand extends ManageCommands
{
	 public IntervalCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  try
		  {
				String name = String.valueOf(args[1]);
				int interval = Integer.valueOf(args[2]);
				if (!Utils.hasListWithName(name))
					 sender.sendPrefixedMessage(" &clist with this name not found.");
				else
				{
					 AutoMessage.getConfigUtils().set("lists." + name + ".interval", interval);
					 sender.sendPrefixedMessage("Done.");
				}
				return true;
		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("&6/am interval <listname> <seconds>");
		  }
		  catch (NumberFormatException e)
		  {
				sender.sendPrefixedMessage("&6interval must be a number.");
		  }
		  return false;
	 }

}
