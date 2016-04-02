import org.strongback.command.Command;

public class DriveForward extends Command {
	private Robot robot;
	public DriveForward (Robot robot) {
		this.robot = robot;
	}
	@Override
	public boolean execute() {
		robot.getDrive().arcade(1.0, 0);
		return false;
	}
}