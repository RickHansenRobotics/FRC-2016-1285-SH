package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private SpeedController leftDriveMotor;
	private SpeedController rightDriveMotor;
	
	private RobotDrive drive;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	public Drivetrain(){
		super();
		
		leftDriveMotor = new Talon(RobotMap.LEFT_DRIVE_MOTOR);
		rightDriveMotor = new Talon(RobotMap.RIGHT_DRIVE_MOTOR);
		
		drive = new RobotDrive(leftDriveMotor, rightDriveMotor);
		
		leftEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A,
				RobotMap.LEFT_DRIVE_ENCODER_B);
		
		rightEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A,
				RobotMap.RIGHT_DRIVE_ENCODER_B);
		
	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
	}

	
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}
	
	

}
