package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.commands.WedgeSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyPosAuton extends CommandGroup{
	
	public ReadyPosAuton(){
		addSequential(new WedgeSetpoint(90, 5));

	}
	
}
