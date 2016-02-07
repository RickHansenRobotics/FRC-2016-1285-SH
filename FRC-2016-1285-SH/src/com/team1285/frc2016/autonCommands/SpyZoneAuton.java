/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
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
