package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.commands.DriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NormalAuton extends CommandGroup {

	public NormalAuton() {
		addSequential(new DriveDistance( 1, 0.5, 0));
		addSequential(new AutonTurn( 1, 0.5, 0));
	}
	
}
