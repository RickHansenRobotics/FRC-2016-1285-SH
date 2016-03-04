package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hanger extends Subsystem{

	CANTalon leftHangerMotor1; 
	CANTalon leftHangerMotor2;
	
	CANTalon rightHangerMotor1; 
	CANTalon rightHangerMotor2; 
	
	public Hanger(){
		
		leftHangerMotor1 =  new CANTalon(ElectricalConstants.LEFT_HANGER_MOTOR1);
		leftHangerMotor2 =  new CANTalon(ElectricalConstants.LEFT_HANGER_MOTOR2);
		
		rightHangerMotor1 =  new CANTalon(ElectricalConstants.RIGHT_HANGER_MOTOR1);
		rightHangerMotor2 =  new CANTalon(ElectricalConstants.RIGHT_HANGER_MOTOR2);
	}
	
	public void runLeftHanger(){
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
