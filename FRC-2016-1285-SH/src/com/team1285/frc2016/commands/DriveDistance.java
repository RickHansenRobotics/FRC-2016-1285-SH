package com.team1285.frc2016.commands;


import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{
	
	private double distance;
	private double setAngle;
	private double speed;
	
	public DriveDistance(double distance, double speed, double setAngle){
		requires(Robot.drive);
		this.distance = distance;
		this.setAngle = setAngle;
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
		setTimeout(setAngle);
	}

	@Override
	protected void execute() {
		Robot.drive.driveStraight(distance, speed, setAngle);
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
