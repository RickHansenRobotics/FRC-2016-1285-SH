/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.Robot;
import com.team1285.frc2016.utilities.TheoryCurve;

import edu.wpi.first.wpilibj.command.Command;

public class AutonTurn extends Command {
	TheoryCurve curve;
	int counter;
	double distance;
	double timeOut;
	double speed;

	public AutonTurn(String startPoint, String controlPoint1, String controlPoint2, String endPoint, double timeOut,
			double speed) {
		curve = new TheoryCurve(startPoint, controlPoint1, controlPoint2, endPoint);
		distance = curve.findDistance();
		this.timeOut = timeOut;
		this.speed = speed;
		requires(Robot.drive);
	}

	public AutonTurn(int i, double d, int j) {
		// TODO Auto-generated constructor stub
	}

	protected void initialize() {
		counter = 0;
		setTimeout(timeOut);
		Robot.drive.reset();
	}

	protected void execute() {
		if (Robot.drive.getAverageDistance() > curve.findHypotenuse(counter) && counter < 19)
			counter++;

		Robot.drive.driveStraight(distance, speed, curve.findAngle(counter), 1);
	}

	protected boolean isFinished() {
		return Robot.drive.getAverageDistance() == distance || isTimedOut();
	}

	protected void end() {
		Robot.drive.runLeftDrive(0);
		Robot.drive.runRightDrive(0);
	}

	protected void interrupted() {

	}
}