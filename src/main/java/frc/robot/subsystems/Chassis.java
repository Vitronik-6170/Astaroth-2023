package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  // Atributos de Chassis
  private CANSparkMax chassisMotorL1;
  private CANSparkMax chassisMotorL2;
  private CANSparkMax chassisMotorR1;
  private CANSparkMax chassisMotorR2;
  private RelativeEncoder encoderMotorL;
  private RelativeEncoder encoderMotorR;

  public Chassis() {
    chassisMotorL1 = Constants.chassisMotorL1;
    chassisMotorL2 = Constants.chassisMotorL2;
    chassisMotorR1 = Constants.chassisMotorR1;
    chassisMotorR2 = Constants.chassisMotorR2;
    encoderMotorL = chassisMotorL1.getEncoder();
    encoderMotorR = chassisMotorR1.getEncoder();
    chassisMotorL1.setInverted(true);
    chassisMotorL2.setInverted(true);
    encoderMotorL.setPosition(0);
    encoderMotorR.setPosition(0);
    chassisMotorL1.setIdleMode(IdleMode.kBrake);
    chassisMotorL2.setIdleMode(IdleMode.kBrake);
    chassisMotorR1.setIdleMode(IdleMode.kBrake);
    chassisMotorR2.setIdleMode(IdleMode.kBrake);
  }

  public void move(double y, double x){
    double speedL = (y - (x * 0.8));
    double speedR = (y + (x * 0.8));
    if((x >= -0.1 && x <= 0.1) && (y >= -0.1 && y <= 0.1)){
      speedL = 0;
      speedR = 0;
    }
    chassisMotorL1.set(speedL * 0.30);
    chassisMotorL2.set(speedL * 0.30);
    chassisMotorR1.set(speedR * 0.30);
    chassisMotorR2.set(speedR * 0.30);
    SmartDashboard.putNumber("Potencia L", speedL);
    SmartDashboard.putNumber("Potencia R", speedR);
    SmartDashboard.putNumber("X", x);
    SmartDashboard.putNumber("Y", y);
        SmartDashboard.putNumber("encoder L", encoderMotorL.getPosition());
    SmartDashboard.putNumber("encoder R", encoderMotorR.getPosition());
  }
  
  public void moveForward(double distance, double speed){
    double r = (distance* -1 * 545/52) + (10 * distance * -1);
    if(encoderMotorR.getPosition() > r && encoderMotorL.getPosition() > r){
      chassisMotorL1.set(speed);
      chassisMotorL2.set(speed);
      chassisMotorR1.set(speed);
      chassisMotorR2.set(speed);
    }else{
      chassisMotorL1.set(0);
      chassisMotorL2.set(0);
      chassisMotorR1.set(0);
      chassisMotorR2.set(0);
    }
  }

  public void moveBackward(double distance, double speed){
    double r = (distance* 545/52) + (10 * distance);
    if(encoderMotorR.getPosition() < r && encoderMotorL.getPosition() < r){
      chassisMotorL1.set(speed);
      chassisMotorL2.set(speed);
      chassisMotorR1.set(speed);
      chassisMotorR2.set(speed);
    }else{
      chassisMotorL1.set(0);
      chassisMotorL2.set(0);
      chassisMotorR1.set(0);
      chassisMotorR2.set(0);
    }
  }
  public void restEncoder(){
    encoderMotorL.setPosition(0);
    encoderMotorR.setPosition(0);
  }


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
