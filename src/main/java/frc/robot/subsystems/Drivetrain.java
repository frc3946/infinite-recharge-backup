/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  
  private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.frontLeftPort);
  private final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.frontRightPort);
  private final WPI_VictorSPX backLeft = new WPI_VictorSPX(Constants.backLeftPort);
  private final WPI_VictorSPX backRight = new WPI_VictorSPX(Constants.backRightPort);
  private final DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);
  
  public void arcadeDrive (double xSpeed, double zRotation){
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    drive.arcadeDrive(xSpeed, -zRotation);
  }

  @Override
  public void periodic() {
    
  }
}