/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double distance;
	
	private double speed;
	private double timeOut;

	public DriveDistance(double distance, double speed, double timeOut) {
		requires(Robot.drive);
		this.distance = distance;
		
		this.speed = speed;
		this.timeOut = timeOut;
				
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
		setTimeout(timeOut);
	}

	@Override
	protected void execute() {
		Robot.drive.driveStraight(distance, speed, timeOut);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.drive.drivePID.isDone() || isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drive.runLeftDrive(0);
		Robot.drive.runRightDrive(0);
		Robot.drive.drivePID.resetPID();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.drive.runLeftDrive(0);
		Robot.drive.runRightDrive(0);
		Robot.drive.drivePID.resetPID();
	}

}
