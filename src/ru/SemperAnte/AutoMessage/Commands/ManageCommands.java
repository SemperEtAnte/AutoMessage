package ru.SemperAnte.AutoMessage.Commands;

import org.bukkit.command.CommandSender;
import ru.SemperAnte.AutoMessage.AutoMessageSender;
import ru.SemperAnte.plugins.API.Commands.ConsoleCommand;
import ru.SemperAnte.plugins.API.Exceptions.SemperAPIException;
import ru.SemperAnte.plugins.API.Interface.APICommandSender;

public class ManageCommands extends ConsoleCommand
{
	 public ManageCommands(APICommandSender cs, String[] args) throws SemperAPIException
	 {
		  super(cs, args);
	 }

	 @Override
	 public String getPermission()
	 {
		  return "AutoMessage.manage";
	 }

	 @Override
	 public boolean execute() throws SemperAPIException
	 {
		  try
		  {
				switch (args[0].toLowerCase())
				{
					 case "add":
						  return new AddCommand(sender, args).isDone();
					 case "remove":
						  return new RemoveCommand(sender, args).isDone();
					 case "set":
						  return new SetCommand(sender, args).isDone();
					 case "start":
						  return new StartCommand(sender, args).isDone();
					 case "stop":
						  return new StopCommand(sender, args).isDone();
					 case "interval":
						  return new IntervalCommand(sender, args).isDone();
					 case "reload":
						  return new ReloadCommand(sender, args).isDone();
					 default:
						  sender.sendPrefixedMessage("/am add <listname> [message]");
						  sender.sendPrefixedMessage("/am remove <listname> [message]");
						  sender.sendPrefixedMessage("/am set <listname> [message]");
						  sender.sendPrefixedMessage("/am interval <listname> <time>");
						  sender.sendPrefixedMessage("/am start <listname>]");
						  sender.sendPrefixedMessage("/am stop <listname>");
						  sender.sendPrefixedMessage("/am reload ");
				}
		  }
		  catch (ArrayIndexOutOfBoundsException e)
		  {

				sender.sendPrefixedMessage("/am add <listname> [message]");
				sender.sendPrefixedMessage("/am remove <listname> [message]");
				sender.sendPrefixedMessage("/am set <listname> [message]");
				sender.sendPrefixedMessage("/am interval <listname> <time>");
				sender.sendPrefixedMessage("/am start <listname>]");
				sender.sendPrefixedMessage("/am stop <listname>");
				sender.sendPrefixedMessage("/am reload ");
		  }
		  return false;
	 }
}
