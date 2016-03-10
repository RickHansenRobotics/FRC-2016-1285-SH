package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hanger extends Subsystem {

	CANTalon leftHangerMotor;
	CANTalon rightHangerMotor;

	CANTalon tapeMeasureMotor;

	public Hanger() {

		leftHangerMotor = new CANTalon(ElectricalConstants.LEFT_HANGER_MOTOR);
		rightHangerMotor = new CANTalon(ElectricalConstants.RIGHT_HANGER_MOTOR);

		tapeMeasureMotor = new CANTalon(ElectricalConstants.TAPE_MEASURE_MOTOR);

	}

	public void runHanger(double val) {
		leftHangerMotor.set(val);
		rightHangerMotor.set(val);
	}

	
	public void runTapeMeasure(double val) {
		tapeMeasureMotor.set(val);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
