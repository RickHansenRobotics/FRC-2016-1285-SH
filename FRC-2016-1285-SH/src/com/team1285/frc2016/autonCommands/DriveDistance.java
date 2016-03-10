/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double distance;
	private double speed;
	private double angle;
	private double timeOut;
	private double epsilon;
	
	public DriveDistance(double distance, double speed, double angle, double timeOut){
		this(distance, speed, angle, timeOut, 1);
	}

	public DriveDistance(double distance, double speed, double angle, double timeOut, double epsilon) {
		requires(Robot.drive);
		this.distance = distance;
		this.speed = speed;
		this.angle = angle;
		this.timeOut = timeOut;
		this.epsilon = epsilon;
				
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
		setTimeout(this.timeOut);
	}

	@Override
	protected void execute() {
		Robot.drive.driveStraight(distance, speed, angle, epsilon);
	}

	@Override
	protected boolean isFinished() {
		if(Robot.drive.drivePID.isDone() || isTimedOut()){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	protected void end() {
		Robot.drive.runLeftDrive(0);
		Robot.drive.runRightDrive(0);
		Robot.drive.drivePID.resetPID();
		Robot.drive.gyroPID.resetPID();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.drive.runLeftDrive(0);
		Robot.drive.runRightDrive(0);
		Robot.drive.drivePID.resetPID();
		Robot.drive.gyroPID.resetPID();
	}

}
