package zjx.login.entity;

/**
 * Ա��
 * @author AdminTC
 */
public class Emp {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public Emp() {
		super();
	}
	public Emp(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
