package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HangerWinch extends Command {

	public HangerWinch() {
		requires(Robot.hanger);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (Robot.oi.getToolLeftBumper()) {
			Robot.hanger.runHanger(1);
		} else if (Robot.oi.getToolLeftTrigger()) {
			Robot.hanger.runHanger(-1);
		} else {
			Robot.hanger.runHanger(0);

		}
		// going up (if getToolLeftY is positive, 0.5), going down (if getToolLeftY is negative, 0.25)
		// set everything on buttons
		Robot.hanger.runTapeMeasure(0.5*(Robot.oi.getToolLeftY()));

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
