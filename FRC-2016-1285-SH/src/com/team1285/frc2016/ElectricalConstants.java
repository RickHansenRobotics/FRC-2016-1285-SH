/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016;

/**
 * The ElectricalConstants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Kaveesha Siribaddana
 * 
 */
public class ElectricalConstants {
	
	// **************************************************************************
	// **************************** DRIVE MOTORS*********************************
	// **************************************************************************

		public static final int LEFT_DRIVE_FRONT = 1;
		public static final int LEFT_DRIVE_BACK = 3;

		public static final int RIGHT_DRIVE_FRONT = 2;
		public static final int RIGHT_DRIVE_BACK = 4;

	// **************************************************************************
	// ************************** DRIVE ENCODERS ********************************
	// **************************************************************************

		public static final int LEFT_DRIVE_ENCODER_A = 0;
		public static final int LEFT_DRIVE_ENCODER_B = 1;

		public static final int RIGHT_DRIVE_ENCODER_A = 2;
		public static final int RIGHT_DRIVE_ENCODER_B = 3;

	// **************************************************************************
	// ********************* DRIVE ENCODER CONSTANTS ****************************
	// **************************************************************************
	
		/** wheel radius in inches */
		public static final int driveWheelRadius = 4;
		/** encoder pulse per rotation */															
		public static final int drivePulsePerRotation = 265;
		/** ratio between wheel and encoder */
		public static final double driveGearRatio = 10.71;
		/** pulse per rotation gear ratio */
		public static final double driveEncoderPulsePerRot = 
			drivePulsePerRotation * driveGearRatio; 
		public static final double driveEncoderDistPerTick = 
			(Math.PI * 2 * driveWheelRadius) / driveEncoderPulsePerRot;
		public static final boolean rightDriveTrainEncoderReverse = false;
		public static final boolean leftDriveTrainEncoderReverse = false;

	// **************************************************************************
	// ************************** INTAKE MOTORS *********************************
	// **************************************************************************

		public static final int LEFT_INTAKE_MOTOR = 1;
		public static final int RIGHT_INTAKE_MOTOR = 2;

	// **************************************************************************
	// *************************** WEDGE MOTORS *********************************
	// **************************************************************************

		public static final int LEFT_WEDGE_MOTOR = 5;
		public static final int RIGHT_WEDGE_MOTOR = 6;

	// **************************************************************************
	// ***************************** WEDGE POT **********************************
	// **************************************************************************

		public static final int WEDGE_POT = 0;

}
