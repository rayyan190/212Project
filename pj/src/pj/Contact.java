package pj;

public class Contact implements Comparable<Contact> {
	private String name;
	private String PhoneNumber;
	private String eMail;
	private String Birthday;
	private String notes;
	private String addres;

	
	private 
	
	public  int compareTo(Contact o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public String getBirthday() {
		return Birthday;
	}



	public void setBirthday(String birthday) {
		Birthday = birthday;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}
	



	public String getAddres() {
		return addres;
	}



	public void setAddres(String addres) {
		this.addres = addres;
	}



	public void Print () {
		System.out.println();
	}
	

}
