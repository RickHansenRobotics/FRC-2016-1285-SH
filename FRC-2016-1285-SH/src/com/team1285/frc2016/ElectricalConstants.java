package com.team1285.frc2016;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class ElectricalConstants {
	//**************************************************************************
	//**************************** DRIVE MOTORS*********************************
	//**************************************************************************        
	  
	  public static final int LEFT_DRIVE_FRONT                              = 1;
	  public static final int LEFT_DRIVE_BACK                               = 2;
	  
	  public static final int RIGHT_DRIVE_FRONT                             = 3;
	  public static final int RIGHT_DRIVE_BACK                              = 4; 
	
	//**************************************************************************
	//************************** DRIVE ENCODERS ********************************
	//**************************************************************************

	  public static final int LEFT_DRIVE_ENCODER_A                          = 0;
	  public static final int LEFT_DRIVE_ENCODER_B                          = 1;

	  public static final int RIGHT_DRIVE_ENCODER_A                         = 2;
	  public static final int RIGHT_DRIVE_ENCODER_B                         = 3;
	
	//**************************************************************************
	//********************* DRIVE ENCODER CONSTANTS ****************************
	//**************************************************************************
	  
	  public static final int driveWheelRadius = 8;//wheel radius in inches
	  public static final int drivePulsePerRotation = 128; //encoder pulse per rotation
	  public static final double driveGearRatio = 10.71; //ratio between wheel and encoder
	  public static final double driveEncoderPulsePerRot = 
			  			drivePulsePerRotation*driveGearRatio; //pulse per rotation * gear ratio
	  public static final double driveEncoderDistPerTick =
			  			(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
	  public static final boolean rightDriveTrainEncoderReverse = false; 
	  public static final boolean leftDriveTrainEncoderReverse = false; 

	//**************************************************************************
	//************************** INTAKE MOTORS *********************************
	//**************************************************************************
	  
	  public static final int LEFT_INTAKE_MOTOR                             = 5;
	  public static final int RIGHT_INTAKE_MOTOR                            = 6;
	  
	//**************************************************************************
	//*************************** WEDGE MOTORS *********************************
	//**************************************************************************
	  
	  public static final int LEFT_WEDGE_MOTOR                              = 7;
	  public static final int RIGHT_WEDGE_MOTOR                             = 8;
	  
	  
}
