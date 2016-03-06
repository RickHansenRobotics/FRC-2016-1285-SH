/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.commands.SpinIntake;
import com.team1285.frc2016.commands.WedgeSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NormalAuton extends CommandGroup {

	public NormalAuton() {
		addSequential(new DriveDistance(144, 0.8, 5, 1));
		addSequential(new AutonTurn(45, 0.8, 0));
		addSequential(new DriveDistance(45, 0.8, 5, 1));
		addParallel(new WedgeSetpoint(2, 7));
		addSequential(new AutonOuttake());
	}

}
