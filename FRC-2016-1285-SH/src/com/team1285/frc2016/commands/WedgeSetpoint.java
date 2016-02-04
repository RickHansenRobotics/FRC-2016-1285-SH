package com.team1285.frc2016.commands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WedgeSetpoint extends Command {

	private double setpoint;
	private double currentWedgeSetpoint = Robot.wedge.wedgePot.getAverageVoltage();
	private double setpointIncreaser = 0.1;
	private double maxSetpoint = 0.9;
	private double minSetpoint = 0;

	public WedgeSetpoint(double setpoint) {
		this.setpoint = setpoint;
		requires(Robot.wedge);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		if(Robot.oi.getToolLeftBumper()){
			if(currentWedgeSetpoint == maxSetpoint){
		//		Robot.wedge.setSetpoint(currentWedgeSetpoint);
			}else{
				currentWedgeSetpoint = currentWedgeSetpoint + setpointIncreaser;
			//	Robot.wedge.setSetpoint(currentWedgeSetpoint);
			}			
		}
		if(Robot.oi.getToolLeftTrigger()){
			if(currentWedgeSetpoint == minSetpoint){
				//Robot.wedge.setSetpoint(currentWedgeSetpoint);
			}else{
				currentWedgeSetpoint = currentWedgeSetpoint - setpointIncreaser;
				//Robot.wedge.setSetpoint(currentWedgeSetpoint);
			}
		}
		
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
