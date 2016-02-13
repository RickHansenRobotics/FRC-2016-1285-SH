/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntake extends Command {

	public SpinIntake() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (Robot.oi.getToolRightTrigger()) {
			Robot.intake.intakeReverse();
		} else if (Robot.oi.getToolLeftTrigger()) {
			Robot.intake.intakeForward();
		} else {
			Robot.intake.intakeStop();
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
