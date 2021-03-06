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
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The subsystem that is used for the drive train of the robot. It runs the 4
 * motors in the drive train as well as read the encoder values from the motors.
 * 
 * @author Kaveesha Siribaddana
 * @since 2016-10-16
 */
public class Drivetrain extends Subsystem {

	// Drive Talons
	CANTalon leftDriveFront;
	CANTalon leftDriveBack;
	CANTalon rightDriveFront;
	CANTalon rightDriveBack;

	// Encoder
	Encoder leftDriveEncoder;
	Encoder rightDriveEncoder;


	// Gyro
	private Nav6 gyro;
	private SerialPort serialPort;


	// PID
	public PIDController drivePID;
	public PIDController gyroPID;

	public double cogx = 0;

	public Drivetrain() {

		try {
			serialPort = new SerialPort(57600, SerialPort.Port.kOnboard);


			// You can add a second parameter to modify the
			// update rate (in hz) from 4 to 100. The default is 100.
			// If you need to minimize CPU load, you can set it to a
			// lower value, as shown here, depending upon your needs.

			// You can also use the IMUAdvanced class for advanced
			// features.

			byte update_rate_hz = 50;
			gyro = new Nav6(serialPort, update_rate_hz);

			if (!gyro.isCalibrating()) {
				Timer.delay(0.3);
				gyro.zeroYaw();
			}
		} catch (Exception e) {
			gyro = null;

		}

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

	/**
	 * Drive goes in a straight line
	 * 
	 * @param i
	 */
	public void driveStraight(double setPoint, double speed, double setAngle, double epsilon) {
		double output = drivePID.calcPID(setPoint, getAverageDistance(), epsilon);
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);

		runLeftDrive((output + angle) * speed);
		runRightDrive((-output + angle) * speed);
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
		return gyro.isConnected();
	}

	/**
	 * This function is used to check if the gyro is calibrating
	 * 
	 * @return Returns true or false depending on the state of the gyro
	 */
	public boolean gyroCalibrating() {
		return gyro.isCalibrating();
	}

	/**
	 * This function returns the YAW reading from the gyro
	 * 
	 * @return Returns YAW
	 */
	public double getYaw() {
		return gyro.getYaw();
	}

	/**
	 * This function returns the PITCH reading from the gyro
	 * 
	 * @return Returns PITCH
	 */
	public double getPitch() {
		return gyro.getPitch();
	}

	/**
	 * This function returns the ROLL reading from the gyro
	 * 
	 * @return Returns ROLL
	 */
	public double getRoll() {
		return gyro.getRoll();
	}

	/**
	 * This function returns the heading from the gyro
	 * 
	 * @return Returns compass heading
	 */
	public double getCompassHeading() {
		return gyro.getCompassHeading();
	}

	/**
	 * Resets the gyro back to zero
	 */
	public void resetGyro() {
		gyro.zeroYaw();
	}

}
