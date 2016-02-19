import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.FlightStick;
import org.strongback.drive.TankDrive;
import org.strongback.hardware.Hardware;
import org.strongback.hardware.Hardware.Motors;

public class Robot extends edu.wpi.first.wpilibj.IterativeRobot {
	private static final int JOYSTICK_PORT = 1;
	private static final int LF_MOTOR_PORT = 1;
	private static final int LR_MOTOR_PORT = 2;
	private static final int RF_MOTOR_PORT = 3;
	private static final int RR_MOTOR_PORT = 4;
	/* Motors and Joystick */
	
	private TankDrive drive;
	private ContinuousRange driveSpeed;
	private ContinuousRange turnSpeed;
	
	public void robotInit() {
		Strongback.configure().initialize();
		
		Motor left = Motor.compose(Hardware.Motors.talon(LF_MOTOR_PORT),
				Hardware.Motors.talon(LR_MOTOR_PORT));
		Motor right = Motor.compose(Hardware.Motors.talon(RF_MOTOR_PORT),
				Hardware.Motors.talon(RR_MOTOR_PORT)).invert();
		
		drive = new TankDrive(left, right);
		
		FlightStick joystick = Hardware.HumanInterfaceDevices.logitechAttack3D(JOYSTICK_PORT);
		driveSpeed = joystick.getPitch();
		turnSpeed = joystick.getRoll().invert();
	}
	public void teleopInit() {
		
	}
	public void teleopPeriodic() {
		drive.arcade(driveSpeed.read(), turnSpeed.read());
	}
	public void disabledInit() {
		
	}
}
