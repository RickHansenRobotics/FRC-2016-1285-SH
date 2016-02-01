package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;
import com.team1285.frc2016.commands.IntakeOff;
import com.team1285.frc2016.commands.TankDrive;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	Relay leftIntakeMotor;
	Relay rightIntakeMotor;

	public Intake() {
		leftIntakeMotor = new Relay(ElectricalConstants.LEFT_INTAKE_MOTOR);
		rightIntakeMotor = new Relay(ElectricalConstants.RIGHT_INTAKE_MOTOR);
	}

	public void intakeForward() {
		leftIntakeMotor.set(Relay.Value.kForward);
		rightIntakeMotor.set(Relay.Value.kReverse);
	}

	public void intakeReverse() {
		leftIntakeMotor.set(Relay.Value.kReverse);
		rightIntakeMotor.set(Relay.Value.kForward);
	}

	public void intakeStop() {
		leftIntakeMotor.set(Relay.Value.kOff);
		rightIntakeMotor.set(Relay.Value.kOff);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeOff());

	}

}
