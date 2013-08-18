package com.TeamNovus.Bounties.Commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class CommandExecutor implements org.bukkit.command.CommandExecutor, TabCompleter {

	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args)
	{				
		String[] labels = (String[]) ArrayUtils.add(args, 0, label);		
		
		Command cmd = Commands.getCommand(labels);
		
		if (cmd == null)
		{
			sender.sendMessage(ChatColor.RED + "The specified command was not found!");
			
			return true;
		}
		
		if (cmd.doesntAllowConsole() && sender instanceof ConsoleCommandSender)
		{
			sender.sendMessage(cmd.getConsoleDisallowedMessage());
			
			return true;
		}
		
		if (cmd.doesntAllowPlayer() && sender instanceof Player)
		{
			sender.sendMessage(cmd.getPlayerDisallowedMessage());
			
			return true;
		}
		
		String[] trueLabels = Commands.getLabels(labels);
		String[] trueArgs = Commands.getArgs(labels);
		
		if (trueArgs.length < cmd.getMin() || (trueArgs.length > cmd.getMax() && cmd.getMax() != -1))
		{
			sender.sendMessage(cmd.getUsageMessage());
			System.out.println("length issue");
			return true;
		}
				
		cmd.onCommand(trueLabels, sender, trueArgs);
		
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args)
	{
		String[] labels = (String[]) ArrayUtils.add(args, 0, label);
		
		Command cmd = Commands.getCommand(labels);
		
		if (cmd != null)
		{
			String[] trueLabels = Commands.getLabels(labels);
			String[] trueArgs = Commands.getArgs(labels);
			
			cmd.onCommand(trueLabels, sender, trueArgs);
		}
		
		return new ArrayList<String>();
	}


}
