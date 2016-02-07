/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016;

import com.team1285.frc2016.autonCommands.NoAuton;
import com.team1285.frc2016.autonCommands.NormalAuton;
import com.team1285.frc2016.autonCommands.SpyZoneAuton;
import com.team1285.frc2016.subsystems.Drivetrain;
import com.team1285.frc2016.subsystems.Intake;
import com.team1285.frc2016.subsystems.Wedge;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final OI oi = new OI();
    public static final Drivetrain drive = new Drivetrain();
    public static final Intake intake = new Intake();
    public static final Wedge wedge = new Wedge();
   
	//Command autonomousCommand;
	public SendableChooser autoChooser;

	Command autonomousCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		autoChooser = new SendableChooser();
		autoChooser.addDefault("No Auton", new NoAuton());
		autoChooser.addObject("Normal Auton", new NormalAuton());
		autoChooser.addObject("SpyZone Auton", new SpyZoneAuton());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		System.out.println("Teleop Init Works");
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		if(autonomousCommand!=null)
    		autonomousCommand.cancel();
		
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
		updateSmartDashboard();

			
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void updateSmartDashboard() {
		SmartDashboard.putNumber("Left Drive Encoder", 
				Math.round(drive.getLeftEncoderDist()));
		SmartDashboard.putNumber("Right Drive Encoder", 
				Math.round(drive.getRightEncoderDist()));
		
	}
}
