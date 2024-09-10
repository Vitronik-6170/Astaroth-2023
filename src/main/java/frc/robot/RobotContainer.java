// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.CloseWiper;
import frc.robot.commands.MoveArmBackward;
import frc.robot.commands.MoveArmDown;
//import frc.robot.commands.MoveArmDownWC;
import frc.robot.commands.MoveArmForward;
import frc.robot.commands.MoveArmUpP2;
import frc.robot.commands.MoveArmUpP3;
//import frc.robot.commands.MoveArmUpWC;
import frc.robot.commands.OpenWiper;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  public static CommandXboxController m_driverController;
  public static CommandXboxController m_driverController2;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    m_driverController2 = new CommandXboxController(1);
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(new MoveArmBackward(Robot.m_ForwardBackward));
    m_driverController.b().whileTrue(new MoveArmForward(Robot.m_ForwardBackward));
    m_driverController.y().whileTrue(new OpenWiper(Robot.m_Wipper));
    m_driverController.x().whileTrue(new CloseWiper(Robot.m_Wipper));
    m_driverController.leftBumper().whileTrue(new MoveArmDown(Robot.m_ArmUpDwon));
    m_driverController.rightBumper().whileTrue(new MoveArmUpP3(Robot.m_ArmUpDwon));
    m_driverController.pov(90).onTrue(new MoveArmUpP2(Robot.m_ArmUpDwon));
    //m_driverController.pov(0).onTrue(new MoveArmDownWC(Robot.m_ArmUpDwon));
    //m_driverController.pov(180).onTrue(new MoveArmUpWC(Robot.m_ArmUpDwon));
    //m_driverController2.a().whileFalse(new Drive(Robot.m_Chassis));
    //m_driverController2.a().whileTrue(new DriveReverse(Robot.m_Chassis));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
