package com.TeamNovus.Bounties.Commands.Common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;

import com.TeamNovus.Bounties.Commands.Command;

public class TestCmd extends Command {

	public TestCmd() throws InstantiationException {
		super("test", "t");		
	}

	@Override
	public void onCommand(String[] labels, CommandSender sender, String[] args) {
		sender.sendMessage(StringUtils.join(labels, ", "));
		sender.sendMessage(StringUtils.join(args, ", "));
		
	}

	@Override
	public List<String> onTabComplete(String[] labels, CommandSender sender, String[] args) {
		return new ArrayList<String>();
	}

}
