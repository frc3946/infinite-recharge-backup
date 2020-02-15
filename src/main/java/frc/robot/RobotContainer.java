package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DeployIntake;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.ResetPneumatics;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final Drivetrain m_drivetrain = new Drivetrain();

  XboxController driverController = new XboxController(Constants.xboxControllerPort);
  
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, 
    () -> driverController.getY(Hand.kLeft), 
    () -> driverController.getX(Hand.kRight)));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton pcIn = new JoystickButton(driverController, 1);//A button
    JoystickButton shoot = new JoystickButton(driverController, 2);//B button
    JoystickButton intakeDeploy = new JoystickButton(driverController, 3);//X button
    JoystickButton pistonReset = new JoystickButton(driverController, 4);//Y button
    shoot.whileHeld(new Shoot());
    pcIn.whileHeld(new IntakeIn());
    pistonReset.whileHeld(new ResetPneumatics());
    intakeDeploy.whileHeld(new DeployIntake());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // return m_autoCommand;
  }
}
