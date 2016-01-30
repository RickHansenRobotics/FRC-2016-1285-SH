package com.team1285.frc2016.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends Subsystem{

	CANTalon leftWedgeMotor;
	Encoder leftWedgeEncoder;
	
	CANTalon rightWedgeMotor;
	Encoder rightWedgeEncoder;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
