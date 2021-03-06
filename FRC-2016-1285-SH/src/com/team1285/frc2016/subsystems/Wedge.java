/**(c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;
import com.team1285.frc2016.NumberConstants;
import com.team1285.frc2016.commands.WedgeSetpoint;
import com.team1285.frc2016.commands.WedgeWithJoy;
import com.team1285.frc2016.utilities.PIDController;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem that is used for the wedge actuation of the robot. It runs the
 * 2 motors in the wedge as well as reads the potentiometer values from the
 * motors.
 * 
 * @author Kaveesha
 */

public class Wedge extends Subsystem {

	CANTalon leftWedgeMotor;
	CANTalon rightWedgeMotor;

	public AnalogInput wedgePot;

	/** Calls PIDController from com.team1285.frc2016.utilities */
	public PIDController wedgePID;

	public Wedge() {

		leftWedgeMotor = new CANTalon(ElectricalConstants.LEFT_WEDGE_MOTOR);
		rightWedgeMotor = new CANTalon(ElectricalConstants.RIGHT_WEDGE_MOTOR);

		wedgePot = new AnalogInput(ElectricalConstants.WEDGE_POT);

		wedgePID = new PIDController(NumberConstants.pWedge, NumberConstants.iWedge, NumberConstants.dWedge);
	}

	/** Runs the left wedge motor */
	public void runLeftWedge(double val) {
		leftWedgeMotor.set(val);
	}

	/** Runs the right wedge motor */
	public void runRightWedge(double val) {
		rightWedgeMotor.set(val);
	}

	/** Runs both wedge motor */
	public void runWedge(double val) {
		leftWedgeMotor.set(val);
		rightWedgeMotor.set(-val);
	}

	/** Sets wedge position using setpoints */
	public void setWedgeAngle(double angle, double speed) {
		// Set up sensor methods
		double output = wedgePID.calcPID(angle, getWedgePot(), 5);
		runWedge(-output * speed);
	}

	public double getWedgePot() {
		return wedgePot.getVoltage() / 5 * 1080;
	}

	public boolean onTarget(double target) {
		if (target - 10 <= getWedgePot() && target + 10 >= getWedgePot()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new WedgeWithJoy());
	}
}
