package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public final class Constants {
  private static final int chassisMotorL1_ID = 1;
  private static final int chassisMotorL2_ID = 5;
  private static final int chassisMotorR1_ID = 7;
  private static final int chassisMotorR2_ID = 9;
  private static final int arLifterForwardnum = 7; // extendido
  private static final int arLifterBackwardnum = 4; // reverso
  private static final int wipernum = 2; // 7
  private static final int armUpDownmun = 3;

  public static VictorSPX arLifterForwardMotor; 
  public static VictorSPX arLifterBackwardMotor;
  public static VictorSPX wipermotor;
  public static CANSparkMax armUpDown;
  public static CANSparkMax chassisMotorL1;
  public static CANSparkMax chassisMotorL2;
  public static CANSparkMax chassisMotorR1;
  public static CANSparkMax chassisMotorR2;

  public static void init(){
    wipermotor = new VictorSPX(wipernum);
    arLifterForwardMotor = new VictorSPX(arLifterForwardnum);
    arLifterBackwardMotor = new VictorSPX(arLifterBackwardnum);
    armUpDown = new CANSparkMax(armUpDownmun, MotorType.kBrushless);
    chassisMotorL1 = new CANSparkMax(chassisMotorL1_ID, MotorType.kBrushless);
    chassisMotorL2 = new CANSparkMax(chassisMotorL2_ID, MotorType.kBrushless);
    chassisMotorR1 = new CANSparkMax(chassisMotorR1_ID, MotorType.kBrushless);
    chassisMotorR2 = new CANSparkMax(chassisMotorR2_ID, MotorType.kBrushless);
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
