/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WedgeSetpoint extends Command {

	private double setpoint;
	private double startpoint = 0;
	private boolean started = false;
	private double time;

	Timer timer;

	public WedgeSetpoint(double setpoint, double time) {

		this.setpoint = setpoint;
		this.time = time;
		timer = new Timer();
		requires(Robot.wedge);
	}

	protected void initialize() {
		timer.start();
		setTimeout(time);
	}

	protected void execute() {

		/*
		 * if (Robot.oi.getToolYButton()) {
		 * Robot.wedge.runWedge(Robot.oi.getToolLeftY() * 0.3); } else { if
		 * (Robot.oi.getToolRightBumper() && !started) {
		 * Robot.wedge.setWedgeAngle(startpoint += 50, 8); timer.reset();
		 * started = true; } else if (Robot.oi.getToolLeftBumper() && !started)
		 * { Robot.wedge.setWedgeAngle(startpoint -= 50, 8); timer.reset();
		 * started = true; }
		 * 
		 * if (timer.get() >= 500) started = false; }
		 */
	

		Robot.wedge.setWedgeAngle(setpoint, 1);
	}

	protected boolean isFinished() {
		return false;

		// return Robot.wedge.onTarget();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
