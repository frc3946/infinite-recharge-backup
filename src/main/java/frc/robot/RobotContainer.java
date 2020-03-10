package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.DeployIntake;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.RaiseRobot;
import frc.robot.commands.ResetClimb;
import frc.robot.commands.ResetIntakePiston;
import frc.robot.commands.RunConveyor;
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
    JoystickButton conveyor = new JoystickButton(driverController, 5); //Left Bumper
    JoystickButton climb = new JoystickButton(driverController, 6); //Right bumper
    JoystickButton resetClimber = new JoystickButton(driverController, 7);//back button ( -<-  X   > )
    JoystickButton bringUpRobot = new JoystickButton(driverController, 8);//start button ( <  X   ->- )

    shoot.whileHeld(new Shoot());
    pcIn.whileHeld(new IntakeIn());
    pistonReset.whileHeld(new ResetIntakePiston());
    intakeDeploy.whileHeld(new DeployIntake());
    conveyor.whileHeld(new RunConveyor());
    climb.whenPressed(new ClimbUp());
    resetClimber.whenPressed(new ResetClimb());
    bringUpRobot.whenPressed(new RaiseRobot());
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
