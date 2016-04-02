import org.strongback.command.Command;

public class LiftArm extends Command {
	private Robot robot;
	public LiftArm (Robot robot) {
		this.robot = robot;
	}
	@Override
	public boolean execute() {
		robot.hardware.getArmMotor()
		return false;
	}
	
}
