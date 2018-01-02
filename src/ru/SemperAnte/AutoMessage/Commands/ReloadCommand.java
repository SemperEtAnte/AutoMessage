package ru.SemperAnte.AutoMessage.Commands;

import ru.SemperAnte.AutoMessage.AutoMessage;
import ru.SemperAnte.AutoMessage.Utils.TasksUtil;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

public class ReloadCommand extends ManageCommands
{
	 public ReloadCommand(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public boolean execute()
	 {
		  TasksUtil.stopAllTasks();
		  AutoMessage.getConfigUtils().reloadConfig();
		  TasksUtil.runAllTasks();
		  sender.sendPrefixedMessage("Done.");
		  return true;
	 }
}
