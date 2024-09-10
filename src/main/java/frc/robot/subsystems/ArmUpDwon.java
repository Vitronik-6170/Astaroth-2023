// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmUpDwon extends SubsystemBase {
  private CANSparkMax motorUpDown;
  private RelativeEncoder encoder;
  public static final double postion1 = 0;
  public static final double postion2 = 175;
  public static final double postion3 = 231;
  public ArmUpDwon() {
    motorUpDown = Constants.armUpDown;
    motorUpDown.setIdleMode(IdleMode.kBrake);
    encoder = motorUpDown.getEncoder();
    encoder.setPosition(0);
  }

  public void moveUp(double speed, double position){
    if(encoder.getPosition() <= position){
      motorUpDown.set(speed*0.3);
    }else{
      motorUpDown.set(0);
    }

  }

  public void moveDown(double speed, double position){
    if(encoder.getPosition() >= position){
      motorUpDown.set(speed*-0.3);
    }else{
      motorUpDown.set(0);
    }
  }
  public void stop(){
    motorUpDown.set(0);
  }

  public void restEncoder(){
    encoder.setPosition(0);
  }
  public void moveWOutCUp(){
    motorUpDown.set(1);
  }
  public void moveWOutCDown(){
    motorUpDown.set(-1);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
