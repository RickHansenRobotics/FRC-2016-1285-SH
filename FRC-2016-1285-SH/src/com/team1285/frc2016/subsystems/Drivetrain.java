/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.subsystems;

import com.team1285.frc2016.ElectricalConstants;
import com.team1285.frc2016.NumberConstants;
import com.team1285.frc2016.commands.TankDrive;
import com.team1285.frc2016.utilities.Nav6;
import com.team1285.frc2016.utilities.PIDController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem that is used for the drive train of the robot. It runs the 4
 * motors in the drive train as well as read the encoder values from the motors.
 * 
 * @author Kaveesha Siribaddana
 * @since 2016-10-16
 */
public class Drivetrain extends Subsystem {

	CANTalon leftDriveFront;
	CANTalon leftDriveBack;

	CANTalon rightDriveFront;
	CANTalon rightDriveBack;

	Encoder leftDriveEncoder;
	Encoder rightDriveEncoder;

	Nav6 nav6;

	public PIDController drivePID;
	public PIDController gyroPID;

	public double cogx = 0;

	public Drivetrain() {
		leftDriveFront = new CANTalon(ElectricalConstants.LEFT_DRIVE_FRONT);
		leftDriveBack = new CANTalon(ElectricalConstants.LEFT_DRIVE_BACK);

		rightDriveFront = new CANTalon(ElectricalConstants.RIGHT_DRIVE_FRONT);
		rightDriveBack = new CANTalon(ElectricalConstants.RIGHT_DRIVE_BACK);

		leftDriveEncoder = new Encoder(ElectricalConstants.LEFT_DRIVE_ENCODER_A,
				ElectricalConstants.LEFT_DRIVE_ENCODER_B, ElectricalConstants.leftDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);

		leftDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);

		rightDriveEncoder = new Encoder(ElectricalConstants.RIGHT_DRIVE_ENCODER_A,
				ElectricalConstants.RIGHT_DRIVE_ENCODER_B, ElectricalConstants.rightDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);

		rightDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);

		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dGyro);
	}

	/** Runs left side of Drive */
	public void runLeftDrive(double pwmVal) {

		leftDriveFront.set(pwmVal);
		leftDriveBack.set(pwmVal);
	}

	/** Runs right side of Drive */
	public void runRightDrive(double pwmVal) {

		rightDriveFront.set(pwmVal);
		rightDriveBack.set(pwmVal);

	}

	/** Gets average distance that drive has gone */
	public double getAverageDistance() {
		return (getLeftEncoderDist() + getRightEncoderDist()) / 2;
	}

	/** Drive goes in a straight line */
	public void driveStraight(double setPoint, double speed, double setAngle) {

		drivePID.calcPID(setPoint, getAverageDistance(), 5);
		gyroPID.calcPID(setAngle, getYaw(), 5);
		double output = drivePID.calcPID(setPoint, getAverageDistance(), 1);
		double angle = gyroPID.calcPID(setAngle, getYaw(), 5);

		runLeftDrive(output + angle * speed);
		runRightDrive(-output + angle * speed);
	}

	public void turnDrive(double setAngle, double speed) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), 5);

		runLeftDrive(angle * speed);
		runRightDrive(angle * speed);
	}

	/**
	 * Resets the encoder AND gyro to zero
	 */
	public void reset() {
		resetEncoders();
		// resetGyro();
	}

	/**
	 * This function returns the distance traveled from the left encoder in
	 * inches
	 * 
	 * @return Returns distance traveled by encoder in inches
	 */
	public double getLeftEncoderDist() {
		return leftDriveEncoder.getDistance();
	}

	/**
	 * This function returns the distance traveled from the right encoder in
	 * inches
	 * 
	 * @return Returns distance traveled by encoder in inches
	 */
	public double getRightEncoderDist() {
		return rightDriveEncoder.getDistance();
	}

	/**
	 * This function returns the raw value from the left encoder
	 * 
	 * @return Returns raw value from encoder
	 */
	public double getLeftEncoderRaw() {
		return leftDriveEncoder.getRaw();
	}

	/**
	 * This function returns the raw value from the right encoder
	 * 
	 * @return Returns raw value from encoder
	 */
	public double getRightEncoderRaw() {
		return rightDriveEncoder.getRaw();
	}

	/**
	 * This function returns the rate the left encoder is moving at in
	 * inches/sec
	 * 
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getLeftEncoderRate() {
		return leftDriveEncoder.getRate();
	}

	/**
	 * This function returns the rate the right encoder is moving at in
	 * inches/sec
	 * 
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getRightEncoderRate() {
		return rightDriveEncoder.getRate();
	}

	/**
	 * Resets both left and right encoders
	 */
	public void resetEncoders() {
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		// setDefaultCommand(new HybridArcadeDrive());
	}

	private boolean getToolStartButton() {
		// TODO Auto-generated method stub
		return false;
	}

	/************************ GYRO FUNCTIONS ************************/

	/**
	 * This function is used to check if the gyro is connected
	 * 
	 * @return Returns true or false depending on the state of the gyro
	 */
	public boolean gyroConnected() {
		return nav6.isConnected();
	}

	/**
	 * This function is used to check if the gyro is calibrating
	 * 
	 * @return Returns true or false depending on the state of the gyro
	 */
	public boolean gyroCalibrating() {
		return nav6.isCalibrating();
	}

	/**
	 * This function returns the YAW reading from the gyro
	 * 
	 * @return Returns YAW
	 */
	public double getYaw() {
		return nav6.getYaw();
	}

	/**
	 * This function returns the PITCH reading from the gyro
	 * 
	 * @return Returns PITCH
	 */
	public double getPitch() {
		return nav6.getPitch();
	}

	/**
	 * This function returns the ROLL reading from the gyro
	 * 
	 * @return Returns ROLL
	 */
	public double getRoll() {
		return nav6.getRoll();
	}

	/**
	 * This function returns the heading from the gyro
	 * 
	 * @return Returns compass heading
	 */
	public double getCompassHeading() {
		return nav6.getCompassHeading();
	}

	/**
	 * Resets the gyro back to zero
	 */
	public void resetGyro() {
		nav6.zeroYaw();
	}

}
