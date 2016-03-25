package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RightTimedAutonTurn extends Command {

	double rightSpeed;
	double rightTimeOut;

	public RightTimedAutonTurn(double rightSpeed, double rightTimeOut) {
		this.rightSpeed = rightSpeed;
		this.rightTimeOut = rightTimeOut;
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setTimeout(rightTimeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.runRightDrive(-rightSpeed);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {

		Robot.drive.runRightDrive(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

		Robot.drive.runRightDrive(0);
	}
}
