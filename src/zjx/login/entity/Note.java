package zjx.login.entity;

public class Note {
	private int id1;
	private String name1;
	private String subject1;
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public Note(int id1, String name1, String subject1) {
		super();
		this.id1 = id1;
		this.name1 = name1;
		this.subject1 = subject1;
	}
	public Note() {
		super();
	}
	
	
	
}
