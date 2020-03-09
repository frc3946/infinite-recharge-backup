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
   boolean upperLeft, upperRight, lowerLeft, lowerRight;
   String test;
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
    upperLeft = Robot.m_conveyor.getUpperLeft();
    upperRight = Robot.m_conveyor.getUpperRight();
    lowerLeft = Robot.m_conveyor.getLowerLeft();
    lowerRight = Robot.m_conveyor.getLowerRight();

    Robot.m_intake.intakeTalonSR.setSpeed(.5);
    test = "method";

     if(upperLeft == true && lowerRight == false ){//|| upperRight == true*//*|| */
      test = "if"; 
      Robot.m_conveyor.conveyorMotor.setSpeed(.5);
     }
    else {
      test = "else";
        Robot.m_conveyor.conveyorMotor.setSpeed(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_intake.intakeTalonSR.setSpeed(0);
    Robot.m_conveyor.conveyorMotor.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}