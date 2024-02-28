package Employee;

public class Login {
	private String id;
	private String password;

	public Login() {
	}

	public String getID() {
		return id;
	}

	public boolean setID(String iD) {
		id = iD;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		this.password = password;
		return true;
	}
}