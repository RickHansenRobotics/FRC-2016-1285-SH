package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends PIDSubsystem{

	CANTalon leftWedgeMotor;
	CANTalon rightWedgeMotor;
	
	AnalogInput wedgePot;
	
	public Wedge(){
		super("Wrist", 2.0, 0.0, 0.0);
		
		leftWedgeMotor = new CANTalon(ElectricalConstants.LEFT_WEDGE_MOTOR);
		rightWedgeMotor = new CANTalon(ElectricalConstants.RIGHT_WEDGE_MOTOR);
		
		wedgePot = new AnalogInput(ElectricalConstants.WEDGE_POT);
				
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
		return wedgePot.getAverageVoltage();
	}

	@Override
	protected void usePIDOutput(double output) {
		leftWedgeMotor.pidWrite(output);
		rightWedgeMotor.pidWrite(output);
	}

}
