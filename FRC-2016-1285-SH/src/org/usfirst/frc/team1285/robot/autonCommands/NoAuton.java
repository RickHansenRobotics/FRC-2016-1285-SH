package org.usfirst.frc.team1285.robot.autonCommands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class NoAuton extends Command {

	@Override
	protected void initialize() {
		this.requires(Robot.drive);
		
	}

	@Override
	protected void execute() {
		

		
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
