/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ResetIntakePiston extends CommandBase {
  /**
   * Creates a new ResetPneumatics.
   */
  public ResetIntakePiston() {
    addRequirements(Robot.m_intake);
    addRequirements(Robot.m_conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_intake.intakeSolenoidLeft.set(false);
    Robot.m_conveyor.conveyorMotor.set(0); // TEMPORARY UNTIL BUTTON PRESS ISSUE IS FIXED
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
