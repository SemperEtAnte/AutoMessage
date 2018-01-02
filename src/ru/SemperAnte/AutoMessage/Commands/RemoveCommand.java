package ru.SemperAnte.AutoMessage.Commands;

import org.bukkit.command.CommandSender;
import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.AutoMessage.Utils.Utils;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

import java.util.List;

public class RemoveCommand extends ManageCommands
{
	 public RemoveCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  try
		  {
				String listname = args[1];
				if (!Utils.hasListWithName(listname))
					 sender.sendPrefixedMessage("Лист с таким названием не найден.");
				if (args.length == 2)
					 AutoMessage.getConfigUtils().set("lists." + listname, null);
				else
				{
					 int number = Integer.valueOf(args[2]);
					 List<String> messages = AutoMessage.getConfigUtils().getStringList("lists." + listname + ".messages");

					 if (messages.size() > number)
					 {
						  messages.remove(number);
						  AutoMessage.getConfigUtils().set("lists." + listname + ".messages", messages);
					 }
					 else
					 {
						  sender.sendPrefixedMessage("Сообщение с номером " + number + " не найдено. (нумерация с 0)");
					 }
				}

		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("/am remove <listname> [messageNumber]");
		  }
		  catch (NumberFormatException e)
		  {
		  	 	sender.sendPrefixedMessage("&cИндекс сообщения должен быть целочисленным.");
		  }
		  return false;
	 }
}
