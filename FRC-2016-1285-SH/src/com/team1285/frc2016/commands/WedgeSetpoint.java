package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WedgeSetpoint extends Command {

	private double setpoint;

	public WedgeSetpoint(double setpoint) {
		this.setpoint = setpoint;
		requires(Robot.wedge);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.wedge.enable();
		Robot.wedge.setSetpoint(setpoint);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.wedge.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}