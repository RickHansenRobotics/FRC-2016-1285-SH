/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
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
		
	}

	protected void execute() {
		Robot.wedge.runWedge(Robot.oi.getToolLeftY());
    	
    			
	}

	protected boolean isFinished() {
		return false;
		
		//return Robot.wedge.onTarget();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
