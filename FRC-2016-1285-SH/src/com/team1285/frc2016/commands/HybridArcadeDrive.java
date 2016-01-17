package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HybridArcadeDrive extends Command {
	
	double leftPower = Robot.oi.getDriveLeftY() + Robot.oi.getDriveRightX();
	double rightPower = Robot.oi.getDriveLeftY() - Robot.oi.getDriveRightX();

	public HybridArcadeDrive() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.drive.runLeftDrive(leftPower);
		Robot.drive.runRightDrive(rightPower);

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
