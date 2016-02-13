/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is used to set a default command for the Drivetrain subsystem.
 * This command allows the driver to control the robot using tank drive.
 *
 * @author Kaveesha Siribaddana
 * @since 2016-01-16
 */
public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.drive);
	}

	protected void initialize() {
	}

	/**
	 * This method will run as long as isFinished() returns true In this method
	 * values from the joystick are sent to the corresponding drives to make the
	 * robot move.
	 */
	protected void execute() {
		/**
		 * This statement will run the drive at 80% of speed unless Left Bumper 
		 * is pressed.
		 */
		if (Robot.oi.getDriveLeftBumper()) {
			Robot.drive.runLeftDrive(-(Robot.oi.getDriveLeftY()));
			Robot.drive.runRightDrive((Robot.oi.getDriveRightY()));
		} else {
			Robot.drive.runLeftDrive(-0.8 * (Robot.oi.getDriveLeftY()));
			Robot.drive.runRightDrive(0.8 * (Robot.oi.getDriveRightY()));
		}

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}