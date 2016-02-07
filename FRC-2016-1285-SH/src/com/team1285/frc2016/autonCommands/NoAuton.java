/**
 * Copyright (c) 2016, Rick Hansen Robotics, Canada. All rights reserved.
 * This information contained herein may not be used in whole or in part without the
 * express written consent of the Rick Hansen Robotics, Canada.
 */
package com.team1285.frc2016.autonCommands;

import com.team1285.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NoAuton extends Command {

    public NoAuton() {
        this.requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.runRightDrive(0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
