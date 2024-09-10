// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import frc.robot.Robot;
import frc.robot.subsystems.ArmUpDwon;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.ForwardBackward;
import frc.robot.subsystems.Wipper;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Autonomus extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmUpDwon m_ArmUpDwon;
  private final ForwardBackward m_ForwardBackward;
  private final Chassis m_Chassis;
  private final Wipper m_Wipper;
  private Timer timer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Autonomus(ArmUpDwon armUpDwon, ForwardBackward forwardBackward, Chassis chassis, Wipper wipper) {
    timer = new Timer();
    m_ArmUpDwon = armUpDwon;
    m_ForwardBackward = forwardBackward;
    m_Chassis = chassis;
    m_Wipper = wipper;
    addRequirements(armUpDwon);
    addRequirements(forwardBackward);
    addRequirements(chassis);
    addRequirements(wipper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    m_ArmUpDwon.restEncoder();
    m_Chassis.restEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() < 4){
      m_Chassis.restEncoder();
      m_ArmUpDwon.moveUp(1, ArmUpDwon.postion3);
      m_Wipper.closewiper();
    }else if(timer.get() > 4 && timer.get() <= 6.5){
      m_ForwardBackward.forward(1);
    }else if(timer.get() > 6.5 && timer.get() <= 10){
      m_Chassis.moveForward(1, 0.1 * -1);
      m_Wipper.stop(); 
    }else if(timer.get() > 10 && timer.get() <= 10.5){
      m_Wipper.openwiper();
      //m_ForwardBackward.stop();
    }else if(timer.get() > 10.5 && timer.get() < 11){
      m_Wipper.stop();
    }else if(timer.get() > 11 && timer.get() <= 13){
      m_ForwardBackward.backward(1);
      m_Chassis.moveBackward(1.6, 0.4);
    }else{
      m_Chassis.move(0, 0);
      m_ForwardBackward.stop();
    }
    // if(timer.get() > 11 && timer.get() <= 11.5){
    //   m_ForwardBackward.backward(1);
    // }else if(timer.get() > 11.5 && timer.get() <= 12){
    //   m_ForwardBackward.stop();;
    // }else if(timer.get() > 12 && timer.get() <= 14){
    //   m_ForwardBackward.backward(1);
    // }else{
    //   m_ForwardBackward.stop();
    // }
    // if(timer.get() < 4.5){
    //   m_Wipper.closewiper();
    //   m_Chassis.moveBackward(1.6, 0.1);
    //   m_ArmUpDwon.moveUp(1, ArmUpDwon.postion3);
    // }else if(timer.get() > 4.5 && timer.get() <= 7){
    //   m_ForwardBackward.forward(1);
    // }else if(timer.get() > 7 && timer.get() <= 7.25){
    //   m_Chassis.restEncoder();
    // }else if(timer.get() > 7.25 && timer.get() <= 12){
    //   m_Chassis.moveForward(1.6, -0.1);
    // }else if(timer.get() > 12 && timer.get() <= 12.5){
    //   m_Wipper.openwiper();
    // }else if(timer.get() > 12 && timer.get() <= 14){
    //   m_ForwardBackward.backward(1);
    //   m_Wipper.stop();
    //   m_Chassis.move(1, 0);
    // }else{
    //   m_ForwardBackward.stop();
    //   m_Chassis.move(0, 0);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
