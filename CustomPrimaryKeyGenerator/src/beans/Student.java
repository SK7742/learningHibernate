package beans;

public class Student {
	private String UID;
	private String name;
	private String email;
	private String address;
	
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(String uID, String name, String email, String address) {
		super();
		UID = uID;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
}
