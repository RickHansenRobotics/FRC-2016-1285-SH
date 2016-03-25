package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedAuton extends Command {

	double speed;
	double timeOut;
    public TimedAuton(double speed, double timeOut) {
    	this.speed = speed;
    	this.timeOut = timeOut;
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.runLeftDrive(speed);
    	Robot.drive.runRightDrive(-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.runRightDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.runRightDrive(0);
    }
}
