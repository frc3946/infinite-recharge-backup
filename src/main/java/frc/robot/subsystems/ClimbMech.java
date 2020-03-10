/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbMech extends SubsystemBase {

  public Solenoid climbPistonRaiserLeft = new Solenoid(Constants.raiseClimbPistonLeft);
  public Solenoid climbPistonRaiserRight = new Solenoid(Constants.raiseClimbPistonRight);
  public Solenoid climbPistonLeft = new Solenoid(Constants.climbPistonLeft);
  public Solenoid climbPistonRight = new Solenoid(Constants.climbPistonRight);
  public boolean checkClimb = false;
  public int primitiveTimer = 0;
  public int climbStage = 0;
  
  public ClimbMech() {

  }

  @Override
  public void periodic() {
  }
}
