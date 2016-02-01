package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.commands.DriveDistance;
import com.team1285.frc2016.commands.SpinIntakeOutward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyZoneAuton extends CommandGroup {

	public SpyZoneAuton() {
		addSequential(new DriveDistance(1, 0.5, 0));
		addSequential(new SpinIntakeOutward());
	}

}
