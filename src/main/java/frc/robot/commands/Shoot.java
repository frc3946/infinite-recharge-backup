/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Shoot extends CommandBase {
  /**
   * Creates a new Shoot.
   */
  public Shoot() {
    addRequirements(Robot.m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_shooter.leftShooterTalonSR.setSpeed(1);
    Robot.m_shooter.rightShooterTalonSR.setSpeed(1);
    Robot.m_conveyor.conveyorMotor.setSpeed(.8);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.leftShooterTalonSR.setSpeed(0);
    Robot.m_shooter.rightShooterTalonSR.setSpeed(0);
    Robot.m_conveyor.conveyorMotor.setSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
