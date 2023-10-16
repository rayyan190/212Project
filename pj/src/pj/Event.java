package pj;
/*

CLASS: Event.java

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

public class Event {
	
	 private String eventTitle;
	 private String ContactName;
	 private String dateTime;
	 private String location;

	 
	 public Event(String eventTitle, String ContactName, String dateTime, String location) {
	  this.eventTitle = eventTitle;
	  this.ContactName = ContactName;
	  this.dateTime = dateTime;
	  this.location = location;
	  
	 }
	 
	 public Event(Event e) {
		  this.eventTitle = e.eventTitle;
		  this.ContactName = e.ContactName;
		  this.dateTime = e.dateTime;
		  this.location = e.location;
		 
	 }
	 public Event() {
		 eventTitle="";
		 ContactName="";
		 dateTime="";
		 location="";
		 
	 }
	 public String getEventTitle() {
	  return eventTitle;
	 }
	 public void setEventTitle(String eventTitle) {
	  this.eventTitle = eventTitle;
	 }
	 public String getContactName() {
	  return ContactName;
	 }
	 public void setContactName(String contactName) {
	  ContactName = contactName;
	 }
	 public String getDateTime() {
	  return dateTime;
	 }
	 public void setDateTime(String dateTime) {
	  this.dateTime = dateTime;
	 }
	 public String getLocation() {
	  return location;
	 }
	 public void setLocation(String location) {
	  this.location = location;
	 }
	
	 
	 public void PrintEvent() {
		 System.out.println("Event title: "+eventTitle); 
	     System.out.println("Contact Name: "+ContactName); 
	     System.out.println("Date Time: "+dateTime); 
		 System.out.println("Location: "+location ); 
	 }

}
