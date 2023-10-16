package pj;
/*

CLASS: Contact.java

CSC212 Data structures - Project phase I

Fall 2023

EDIT DATE:

16-10-2023

TEAM:

team name: my technology.

AUTHORS:
Rayan Alghamdi. id:443102225
Mohammed Aleidi.id:443102416



*/

public class Contact implements Comparable<Contact> {
	LinkedList <Contact> eventList;
	private String name;
	private String PhoneNumber;
	private String eMail;
	private String Birthday;
	private String notes;
	private String addres;
	
    public Contact(String name, String PhoneNumber, String eMail, String addres, String Birthday, String notes) {
		
		this.name = name;
		this.PhoneNumber = PhoneNumber;
		this.eMail = eMail;
		this.addres = addres;
		this.Birthday = Birthday;
		this.notes = notes;
		
	}
    public Contact() {
    	name="";
    	PhoneNumber="";
    	eMail="";
    	Birthday="";
    	notes="";
    	addres="";
    }
	
	public Contact(Contact c ) {
		this.name = c.name;
		this.PhoneNumber = c.PhoneNumber;
		this.eMail = c.eMail;
		this.addres = c.addres;
		this.Birthday = c.Birthday;
		this.notes = c.notes;
	}

	
	
	
	public  int compareTo(Contact o) {
		return this.getName().compareTo(o.name);
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



	public void PrintContact () {
		System.out.println("Name: "+name); 
		System.out.println("Phone Number: "+PhoneNumber); 
		System.out.println("Email Address: "+eMail); 
		System.out.println("Address: "+addres); 
		System.out.println("Birthday: "+Birthday); 
		System.out.println("Notes: "+notes); 
		
	}
	

}
