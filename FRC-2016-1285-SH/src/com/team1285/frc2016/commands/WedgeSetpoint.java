package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WedgeSetpoint extends Command {

	private double setpoint;

	public WedgeSetpoint(double setpoint) {
		this.setpoint = setpoint;
		requires(Robot.wedge);
	}

	protected void initialize() {
		Robot.wedge.enable();
		Robot.wedge.setSetpoint(setpoint);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Robot.wedge.onTarget();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
