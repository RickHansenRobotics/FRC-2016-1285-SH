package com.team1285.frc2016.autonCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefenceCrossAutonLong extends CommandGroup{

	public DefenceCrossAutonLong() {
		
		addSequential(new TimedAuton(1, 3));

	}
	
}
