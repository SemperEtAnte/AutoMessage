package ru.SemperAnte.AutoMessage.Commands;

import org.bukkit.command.CommandSender;
import ru.SemperAnte.AutoMessage.Utils.TasksUtil;
import ru.SemperAnte.AutoMessage.Utils.Utils;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

public class StopCommand extends ManageCommands
{
	 public StopCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  try
		  {
				String listname = args[1];
				if (!TasksUtil.isTaskRunned(listname))
				{
					 sender.sendPrefixedMessage("Task not runned");
				}
				else
				{
					 if (!Utils.hasListWithName(listname))
						  sender.sendPrefixedMessage("List with this name not exists");
					 else
					 {
						  TasksUtil.stopTask(listname);
						  sender.sendPrefixedMessage("Done.");
					 }
				}

		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {
				sender.sendPrefixedMessage("/am stop <listname>");
		  }
		  return false;
	 }
}
