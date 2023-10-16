package pj;
/*

CLASS: PhoneBook.java

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

public class PhoneBook <T>{
	private LinkedList<T> contactList;
	private LinkedList<T> eventList;
	
	public PhoneBook() {
		contactList=new LinkedList<>();
		eventList=new LinkedList<>();
	}
	
	public void addContact(T contact) {
		//this method will  add the contacts sorted in the list based on the name of the contacts 
		if(contactList.empty()) { 
			 contactList.add(contact);
             System.out.println("Contact added successfully!");
		}
		
		else if (!contactList.isContactUnique((Contact) contact)) {
            System.out.println("Contact with the same name or phone number already exists.");
            
        }
		
		else {
			contactList.findFirst();
			if(((Contact) contact).compareTo(((Contact) contactList.retrieve()))<0) { 
				Contact NewContact = new Contact((Contact)contactList.retrieve());
				contactList.update(contact);
				contactList.add((T) NewContact);
				  System.out.println("Contact added successfully!");
			}
			else {
				while(!contactList.last()&&((Contact) contactList.retrieve()).compareTo((Contact) contact)<=0) {
					contactList.findNext();
				}
				if(((Contact) contactList.retrieve()).compareTo((Contact) contact)>0) {
					Contact NewContact = new Contact((Contact)contactList.retrieve());
					contactList.update(contact);
					contactList.add((T) NewContact);
					  System.out.println("Contact added successfully!");
				}
				else {
					contactList.add(contact);
					  System.out.println("Contact added successfully!");
				}
					
			}
		}
	}
	
	
	public void removeContact(String contactName ) {
		// this method will remove the contact if it found in the list and will remove the contact events if it has any 
		if( contactList.empty()) {
 	   System.out.println("No contact to delete!!"); 
		}
		
			 
		else if(!contactList.empty()&&!contactList.last()) {
		 contactList.findFirst();
		while(!contactList.last()){
			if(((Contact) contactList.retrieve()).getName().equalsIgnoreCase(contactName)) {
				contactList.remove();
				removeEventsWithContact(contactName);
				 System.out.println("Contact deleted successfully!");	
			}
			
				
				 contactList.findNext();
		}
		 
			
		
		}
		else if(contactList.last()&&!contactList.empty()) {
			contactList.remove();;
			removeEventsWithContact(contactName);

			 System.out.println("Contact deleted successfully!");	
		}
	}
	
	private void removeEventsWithContact(String contactName) {
    	//this method will remove event connected with given contact name in the parameter 
    	if(eventList.empty()) {
    		System.out.println("The Event List Is empty!!"); 
    		return;
    	}
    	while(!eventList.empty()) {
    	    		eventList.findFirst();
    	
    	if((((Event) eventList.retrieve()).getContactName().equalsIgnoreCase(contactName))) {
  				eventList.remove();
  			
  				eventList.findFirst();
    	}
    	
    		
    		else if(eventList.last()) {
    	    		
 				if (((Event) eventList.retrieve()).getContactName().equalsIgnoreCase(contactName)) {
 					 eventList.remove();
 				 }
 			}
    		
    	}
     		
    	
  	
     }
	
	 public void searchContacts(int criteria) {
		 //this method will search for contacts based on the criteria
		 if(contactList.empty())
			 System.out.println("the Contact List is empty ");
		 else {
			 contactList.searchContacts(criteria);
		 }
	 }
	 
	 public void searchEvent(int criteria) {
		 //this method will search for events based on the criteria
		 if(eventList.empty())
			 System.out.println("the event List is empty ");
		 else {
			 eventList.searchEvent(criteria);
		 }
	 }
	 
	 private  boolean eventConflict(Event newEvent) {
		 //this method will check that there is no conflict of time and date 
		 eventList.findFirst();
		 while(!eventList.last()) {
		 if(((Event) eventList.retrieve()).getDateTime().equalsIgnoreCase(newEvent.getDateTime())&&((Event) eventList.retrieve()).getContactName().equalsIgnoreCase(newEvent.getContactName()))
			 return true;
		 eventList.findNext();
		 }
		 if(((Event) eventList.retrieve()).getDateTime().equalsIgnoreCase(newEvent.getDateTime())&&((Event) eventList.retrieve()).getContactName().equalsIgnoreCase(newEvent.getContactName()))
	      return true;
		 else return false;
		 
		 
	 }
	 
	 private boolean  searchByName (String name ){
		 //this method will search for a contact in the list by name
		 contactList.findFirst();
		 while(!contactList.last()) {
			 if(((Contact) contactList.retrieve()).getName().equalsIgnoreCase(name))
			 return true;
			 contactList.findNext();
		 }
		 if(contactList.last())
			 if(((Contact) contactList.retrieve()).getName().equalsIgnoreCase(name))
				 return true;
			  return false;
	 }

	 
	 public void scheduleEvent(T event) {
		 if(contactList.empty()) {
			 System.out.println(" can not schedule becuase there no contact ");
		 return;}
		 else {

		//this method will schedule the events sorted in the list based on the event title
			String contactName =((Event)event).getContactName();

		 if(eventList.empty()&&searchByName(contactName)) {
			 eventList.add(event);
			 System.out.println("Event scheduled successfully!");
			 }
		 else if(!eventList.empty()&&!eventConflict((Event)event)) {
				 if(searchByName(contactName)) {
		                eventList.findFirst();
		                if(((Event) eventList.retrieve()).getEventTitle().compareTo(((Event) event).getEventTitle())>0) {
		                    Event NewEvent1 = new Event((Event) eventList.retrieve());
		                    eventList.update(event);
		                    eventList.add((T) NewEvent1);
		                    System.out.println("Event scheduled successfully!");

		                }
		                else {
		                    while(!eventList.last()&&((Event) eventList.retrieve()).getEventTitle().compareTo(((Event) event).getEventTitle())>=0) {
		                        eventList.findNext();
		                    }
		                    if(((Event) eventList.retrieve()).getEventTitle().compareTo(((Event) event).getEventTitle())<0) {
		                        Event NewEvent1 = new Event((Event) eventList.retrieve());
		                        eventList.update(event);
		                        eventList.add((T) NewEvent1);
		                        System.out.println("Event scheduled successfully!");

		                    }
		                    else {
		                         eventList.add((T) event);
		                            System.out.println("Event scheduled successfully!");
		                    }
		                }
				}
				
				else  System.out.println("The Contact is not in the list ");
			 }
		 
		 else
			 System.out.println("Conflict with anther event");  
	 }
	 }
	 public void printContactsByFirstName(String firstName) {
		 //this method will print all contacts with the first name given in the parameter if it found 
		 boolean f = false;
		    contactList.findFirst();
		    if(contactList.empty()) {
		    	System.out.println("No Contact To Search For!"); 
		    }
		    else  {
		    	while (!contactList.last()) {
		    		
			        if (  ((Contact) contactList.retrieve()).getName().startsWith(firstName)) {
			            ((Contact) contactList.retrieve()).PrintContact();
			            System.out.println();
			            f=true;
			        }
			        contactList.findNext();
			    }
		    	 if (contactList.last()) {
				        if (  ((Contact) contactList.retrieve()).getName().startsWith(firstName)) {
				            ((Contact) contactList.retrieve()).PrintContact();
				            System.out.println();
				            f=true;
				        }
		    }
	 }
		    if(f==false) {
		    	System.out.println("Contact Not Found!"); 
		    }   	
	 }
	 
	 public void printAllEventsAlphabetically() {
		 //this method will print events ordered alphabetically witch already done in method scheduleEvent
		 if(eventList.empty())
			 System.out.println("event List is empty");
		 
		 eventList.PrintEvents();
		 
		 
	 }

}
