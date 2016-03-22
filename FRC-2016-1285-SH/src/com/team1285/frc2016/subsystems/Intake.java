/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;
import com.team1285.frc2016.commands.SpinIntake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem that is used for intaking the ball to the robot. It runs the 2
 * motors in the intake.
 * 
 * @author Kaveesha
 */

public class Intake extends Subsystem {

	CANTalon leftIntakeMotor;
	CANTalon rightIntakeMotor;

	public Intake() {
		leftIntakeMotor = new CANTalon(ElectricalConstants.LEFT_INTAKE_MOTOR);
		rightIntakeMotor = new CANTalon(ElectricalConstants.RIGHT_INTAKE_MOTOR);
	}

	/** Spins Intake rollers to outtake ball */
	public void outtake() {
		leftIntakeMotor.set(1);
		rightIntakeMotor.set(-1);
	}

	/** Spins Intake rollers to intake ball */
	public void intake() {
		leftIntakeMotor.set(-1);
		rightIntakeMotor.set(1);
	}

	/** Stops spinning Intake rollers */
	public void intakeStop() {
		leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SpinIntake());

	}

}
