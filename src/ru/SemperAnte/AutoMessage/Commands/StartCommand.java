package ru.SemperAnte.AutoMessage.Commands;

import org.bukkit.command.CommandSender;
import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.AutoMessage.Utils.TasksUtil;
import ru.SemperAnte.AutoMessage.Utils.Utils;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

public class StartCommand extends ManageCommands
{
	 public StartCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  try
		  {
				String listname = args[1];
				if (TasksUtil.isTaskRunned(listname))
				{
					 sender.sendPrefixedMessage("Task already runned");
				}
				else
				{
					 if (!Utils.hasListWithName(listname))
						  sender.sendPrefixedMessage("List with this name not exists");
					 else
					 {
					 	 TasksUtil.startTask(listname);
					 	 sender.sendPrefixedMessage("Done.");
					 }
				}

		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("/am start <listname>");
		  }
		  return false;
	 }

}
