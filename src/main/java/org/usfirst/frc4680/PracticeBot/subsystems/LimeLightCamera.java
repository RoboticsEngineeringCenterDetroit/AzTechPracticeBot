/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4680.PracticeBot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class LimeLightCamera extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  NetworkTable nTable;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public LimeLightCamera() {
    nTable = NetworkTableInstance.getDefault().getTable("limelight");
  }

  public boolean targetFound() {
    return nTable.getEntry("tv").getDouble(0) == 1;
  }

  public Double horizAngle() {
    return nTable.getEntry("tx").getDouble(Double.NaN);
  }

  public Double vertAngle() {
    return nTable.getEntry("ty").getDouble(Double.NaN);
  }

  @Override
  public void periodic() {
      // Put code here to be run every loop
      SmartDashboard.putBoolean("Target Found", targetFound());
      SmartDashboard.putNumber("Horizontal Angle", horizAngle());
      SmartDashboard.putNumber("Vertical Angle", vertAngle());
  }

}
