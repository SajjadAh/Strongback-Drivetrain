import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.FlightStick;
import org.strongback.drive.TankDrive;
import org.strongback.hardware.Hardware;
import org.strongback.hardware.Hardware.Motors;

public class Robot extends edu.wpi.first.wpilibj.IterativeRobot {
	protected PORTS ports = new PORTS();
	protected RobotHardware hardware = new RobotHardware();
	private TankDrive drive;
	private Motor lift;
	private ContinuousRange driveSpeed;
	private ContinuousRange turnSpeed;
	private ContinuousRange armSpeed;
	
	public void robotInit() {
		Strongback.configure().initialize();
		
		Motor arm = Hardware.Motors.talon(this.ports.ARM_MOTOR-PORT);
		Motor left = Motor.compose(Hardware.Motors.talon(LF_MOTOR_PORT),
				Hardware.Motors.talon(LR_MOTOR_PORT));
		Motor right = Motor.compose(Hardware.Motors.talon(RF_MOTOR_PORT),
				Hardware.Motors.talon(RR_MOTOR_PORT)).invert();
		
		drive = new TankDrive(left, right);
		lift = new Motor(arm);
		
		FlightStick joystick = Hardware.HumanInterfaceDevices.logitechAttack3D(JOYSTICK_PORT);
			driveSpeed = joystick.getPitch();
			turnSpeed = joystick.getRoll().invert();
		
			
		FlightStick armJoystick = Hardware.HumanInterfaceDevices.logitechAttack3D(ARM_JOYSTICK_PORT);
			armSpeed = armJoystick.getPitch();
	}
	
	public TankDrive getDrive() {
		return drive;
	}
	public void teleopInit() {
		
	}
	public void teleopPeriodic() {
		drive.arcade(driveSpeed.read(), turnSpeed.read());
		
		Strongback.submit(new DriveForward (this));
	}
	public void disabledInit() {
		
	}
}
