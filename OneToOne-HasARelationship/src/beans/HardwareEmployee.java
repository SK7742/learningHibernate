package beans;

public class HardwareEmployee extends Employee {
	private int workingHour;

	public HardwareEmployee() {
	}

	public HardwareEmployee(int id, String name, String email, int salary, int workingHour) {
		super(id, name, email, salary);
		this.workingHour = workingHour;
	}

	public int getWorkingHour() {
		return workingHour;
	}

	public void setWorkingHour(int workingHour) {
		this.workingHour = workingHour;
	}
	
	
	
}
