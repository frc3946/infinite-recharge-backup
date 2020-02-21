/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class Intake extends SubsystemBase {

  public static final Talon intakeTalonSR = new Talon (Constants.intakeMoterPort);
  public static final Solenoid intakeSolenoidLeft = new Solenoid (Constants.intakeSolenoidPort1);
  public static final Solenoid intakeSolenoidRight = new Solenoid (Constants.intakeSolenoidPort2);

  public void intake(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
