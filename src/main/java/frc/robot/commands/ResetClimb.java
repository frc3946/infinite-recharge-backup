/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ResetClimb extends CommandBase {
  /**
   * Creates a new ResetClimb.
   */
  public ResetClimb() {
    addRequirements(Robot.m_climbMech);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_climbMech.checkClimb = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.m_climbMech.climbPistonRaiserLeft.set(false);
    Robot.m_climbMech.climbPistonRaiserRight.set(false);
    Robot.m_climbMech.climbPistonLeft.set(false);
    Robot.m_climbMech.climbPistonRight.set(false);
    Robot.m_climbMech.climbStage = 0;

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
