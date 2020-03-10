/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ClimbUp extends CommandBase {
  /**
   * Creates a new ClimbUp.
   */
  public ClimbUp() {
    addRequirements(Robot.m_climbMech);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_climbMech.checkClimb = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.m_climbMech.climbPistonRaiserLeft.set(true);
    Robot.m_climbMech.climbPistonRaiserRight.set(true);
    Robot.m_climbMech.climbStage = 1;

    if (Robot.m_climbMech.primitiveTimer >= 50){
      Robot.m_climbMech.climbPistonLeft.set(true);
      Robot.m_climbMech.climbPistonRight.set(true);
      Robot.m_climbMech.climbStage = 2;
    }
    Robot.m_climbMech.primitiveTimer++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_climbMech.primitiveTimer = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
