package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends PIDSubsystem{

	CANTalon leftWedgeMotor;
	AnalogInput leftWedgePot;
	
	CANTalon rightWedgeMotor;
	AnalogInput rightWedgePot;
	
	double averagePotVoltage = 
		(leftWedgePot.getAverageVoltage() + rightWedgePot.getAverageVoltage() ) /2 ;
	
	public Wedge(){
		super("Wrist", 2.0, 0.0, 0.0);
		
		leftWedgeMotor = new CANTalon(ElectricalConstants.LEFT_WEDGE_MOTOR);
		rightWedgeMotor = new CANTalon(ElectricalConstants.RIGHT_WEDGE_MOTOR);
		
		leftWedgePot = new AnalogInput(ElectricalConstants.LEFT_WEDGE_POT);
		rightWedgePot = new AnalogInput(ElectricalConstants.RIGHT_WEDGE_POT);
		
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);

	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return averagePotVoltage;
	}

	@Override
	protected void usePIDOutput(double output) {
		leftWedgeMotor.pidWrite(output);
		rightWedgeMotor.pidWrite(output);
	}

}
