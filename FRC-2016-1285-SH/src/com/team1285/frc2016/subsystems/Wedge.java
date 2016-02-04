package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends Subsystem {

	CANTalon leftWedgeMotor;
	CANTalon rightWedgeMotor;

	public AnalogInput wedgePot;

	public Wedge() {
			
		leftWedgeMotor = new CANTalon(ElectricalConstants.LEFT_WEDGE_MOTOR);
		rightWedgeMotor = new CANTalon(ElectricalConstants.RIGHT_WEDGE_MOTOR);

		wedgePot = new AnalogInput(ElectricalConstants.WEDGE_POT);
	}
	
	public double getWedgeSetpoint(){
		return wedgePot.getAverageVoltage();
	}
	
	@Override
	protected void initDefaultCommand() {

	}
}
