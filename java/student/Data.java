package student;
import java.io.InputStream;
public class Data {
	private String name;
	private String rollno;
	private String gender;
	private String Father_name;
	private InputStream image;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getRollno() {
		return rollno;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}


	public void setFather_name(String father_name) {
		Father_name = father_name;
	}
	
	public String getFather_name() {
		return Father_name;
	}
	
	    public InputStream getImage() {
	        return image;
	    }

	    public void setImage(InputStream image) {
	        this.image = image;
	    }
	
}
