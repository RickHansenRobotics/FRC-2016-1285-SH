/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.commands.DriveDistance;
import com.team1285.frc2016.commands.SpinIntake;
import com.team1285.frc2016.commands.WedgeSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyZoneAuton extends CommandGroup {

	public SpyZoneAuton() {
		addSequential(new DriveDistance(100, 0.8, 3));
		addSequential(new WedgeSetpoint(270,8));
		addSequential(new AutonOuttake());
		addSequential(new DriveDistance(-100, 0.8, 4));
	}

}
