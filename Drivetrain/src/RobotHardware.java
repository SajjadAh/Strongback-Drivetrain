import org.strongback.components.*;
import org.strongback.hardware.Hardware;
import org.strongback.components.ui.FlightStick;

public class RobotHardware {
	
	private Motor lfMotor = Hardware.Motors.talon(PORTS.LF_MOTOR_PORT);
	private Motor lrMotor = Hardware.Motors.talon(PORTS.LR_MOTOR_PORT);
	private Motor rfMotor = Hardware.Motors.talon(PORTS.RF_MOTOR_PORT);
	private Motor rrMotor = Hardware.Motors.talon(PORTS.RR_MOTOR_PORT);
	private Motor armMotor = Hardware.Motors.talon(PORTS.ARM_MOTOR_PORT);
	
	public Motor getLfMotor() {
		return lfMotor;
	}
	public Motor getLrMotor() {
		return lrMotor;
	}
	public Motor getRfMotor() {
		return rfMotor;
	}
	public Motor getRrMotor() {
		return rrMotor;
	}
	public Motor getArmMotor() {
		return armMotor;
	}
}
