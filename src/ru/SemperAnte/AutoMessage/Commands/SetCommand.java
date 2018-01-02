package ru.SemperAnte.AutoMessage.Commands;

import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

import java.util.List;

public class SetCommand extends ManageCommands
{

	 public SetCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  try
		  {
				String listname = args[1];
				int messagesNumber = Integer.valueOf(args[2]);
				StringBuilder sb = new StringBuilder(args[3]);
				for (int i = 4; i < args.length; ++i)
					 sb.append(" ").append(args[i]);
				String message = sb.toString();
				List<String> messages = AutoMessage.getConfigUtils().getStringList("lists." + listname + ".messages");
				if (messages.size() <= messagesNumber)
				{
					 sender.sendPrefixedMessage("Index out of List. /am add, to add the new message.");
				}
				else
				{
					 messages.set(messagesNumber, message);
					 AutoMessage.getConfigUtils().set("lists." + listname + ".messages", messages);
				}
		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("/am set <listname> <messageIndex> <message>");
		  }
		  catch (NumberFormatException e)
		  {
				sender.sendPrefixedMessage("Index must be a number.");
		  }
		  return false;
	 }

}
