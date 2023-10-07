package pj;

public class Event {
	
	 private String eventTitle;
	 private String ContactName;
	 private String dateTime;
	 private String location;
	 private Contact contact;
	 
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
	 public Contact getContact() {
	  return contact;
	 }
	 public void setContact(Contact contact) {
	  this.contact = contact;
	 }

}
