// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ForwardBackward extends SubsystemBase {
  private VictorSPX arLifterForwardMotor; 
  private VictorSPX arLifterBackwardMotor;
  private DigitalInput limitForward;
  private DigitalInput limitReverse;
  /** Creates a new ExampleSubsystem. */
  public ForwardBackward() {
    arLifterBackwardMotor = Constants.arLifterBackwardMotor;
    arLifterForwardMotor = Constants.arLifterForwardMotor;
    limitForward = new DigitalInput(7);
    limitReverse = new DigitalInput(9);
  }

  public void backward(double speed){
    //if(limitReverse.get()){
    //  arLifterBackwardMotor.set(ControlMode.PercentOutput, speed * -1);
    //}else{
    //  arLifterBackwardMotor.set(ControlMode.PercentOutput, 0);
    //}
    arLifterForwardMotor.set(ControlMode.PercentOutput, -1);
    arLifterBackwardMotor.set(ControlMode.PercentOutput, 1);
  }

  public void forward(double speed){
    /* 
    if(!limitForward.get()){
      arLifterForwardMotor.set(ControlMode.PercentOutput, speed * -1);
    }else{
      arLifterForwardMotor.set(ControlMode.PercentOutput, 0);
    }*/
    arLifterForwardMotor.set(ControlMode.PercentOutput, 1);
    arLifterBackwardMotor.set(ControlMode.PercentOutput, -1);
    System.out.println(limitForward.get());
  }
  public void stop(){
    arLifterBackwardMotor.set(ControlMode.PercentOutput, 0);
    arLifterForwardMotor.set(ControlMode.PercentOutput, 0);
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
