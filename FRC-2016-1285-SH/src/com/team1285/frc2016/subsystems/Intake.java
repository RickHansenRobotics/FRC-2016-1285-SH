/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;
import com.team1285.frc2016.commands.IntakeOff;
import com.team1285.frc2016.commands.SpinIntake;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem that is used for intaking the ball to the robot. It runs the 2
 * motors in the intake.
 * 
 * @author Kaveesha
 */

public class Intake extends Subsystem {

	Relay leftIntakeMotor;
	Relay rightIntakeMotor;

	public Intake() {
		leftIntakeMotor = new Relay(ElectricalConstants.LEFT_INTAKE_MOTOR);
		rightIntakeMotor = new Relay(ElectricalConstants.RIGHT_INTAKE_MOTOR);
	}

	/** Spins Intake rollers to outtake ball*/
	public void intakeForward() {
		leftIntakeMotor.set(Relay.Value.kForward);
		rightIntakeMotor.set(Relay.Value.kReverse);
	}
	/** Spins Intake rollers to intake ball*/
	public void intakeReverse() {
		leftIntakeMotor.set(Relay.Value.kReverse);
		rightIntakeMotor.set(Relay.Value.kForward);
	}
	
	/** Stops spinning Intake rollers*/
	public void intakeStop() {
		leftIntakeMotor.set(Relay.Value.kOff);
		rightIntakeMotor.set(Relay.Value.kOff);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SpinIntake());

	}

}
