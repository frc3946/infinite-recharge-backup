/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeIn extends CommandBase {
  /**
   * Creates a new IntakeIn.
   */
  public IntakeIn() {
    addRequirements(Robot.m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.m_intake.intakeTalonSR.setSpeed(.4);
    if((Robot.m_conveyor.getUpperLeft() == false || Robot.m_conveyor.getUpperRight() == false) &&
       (Robot.m_conveyor.getLowerLeft() == true || Robot.m_conveyor.getLowerRight() == true)){

      Robot.m_conveyor.conveyorMotor.setSpeed(.4);
    
    }else{
      Robot.m_conveyor.conveyorMotor.setSpeed(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_intake.intakeTalonSR.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
