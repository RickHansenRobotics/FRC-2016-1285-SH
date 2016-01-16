package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.NumberConstants;
import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private SpeedController leftDriveMotor;
	private SpeedController rightDriveMotor;
	
	private RobotDrive drive;
	
	private Encoder leftDriveEncoder;
	private Encoder rightDriveEncoder;
	
	public PIDController drivePID;
	
	public Drivetrain(){
		super();
		
		leftDriveMotor = new Talon(RobotMap.LEFT_DRIVE_MOTOR);
		rightDriveMotor = new Talon(RobotMap.RIGHT_DRIVE_MOTOR);
		
		drive = new RobotDrive(leftDriveMotor, rightDriveMotor);
		
		leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A,  
				 				RobotMap.LEFT_DRIVE_ENCODER_B,  
				 				RobotMap.leftDriveTrainEncoderReverse,  
				 				Encoder.EncodingType.k4X); 
				 		 
		leftDriveEncoder.setDistancePerPulse(RobotMap.driveEncoderDistPerTick); 
						 
		rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A, 
				 				RobotMap.RIGHT_DRIVE_ENCODER_B,  
				 				RobotMap.rightDriveTrainEncoderReverse,  
				 				Encoder.EncodingType.k4X); 

		rightDriveEncoder.setDistancePerPulse(RobotMap.driveEncoderDistPerTick);
		
		

	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
	}

	
	public void reset() {
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
	}

	
	public double getDistance() {
		return (leftDriveEncoder.getDistance() + rightDriveEncoder.getDistance())/2;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}
	
	

}
