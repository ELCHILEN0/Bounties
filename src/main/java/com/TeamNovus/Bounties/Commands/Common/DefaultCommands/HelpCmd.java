package com.TeamNovus.Bounties.Commands.Common.DefaultCommands;

import com.TeamNovus.Bounties.Commands.Command;

public class HelpCmd extends Command {

	public HelpCmd(Command parent, String[] aliases) throws InstantiationException {
		super(parent, aliases);
		
		setAllowConsole(true);
		setAllowPlayer(true);
		setPermission("");
	}

	public HelpCmd(String[] aliases) throws InstantiationException {
		this(null, aliases);
	}

}
