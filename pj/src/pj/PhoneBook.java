package pj;

public class PhoneBook <T>{
	private LinkedList<T> contactList;
	private LinkedList<T> eventList;
	
	public PhoneBook() {
		contactList=new LinkedList<>();
		eventList=new LinkedList<>();
	}
	
	public void addContact(T contact) {
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
		if( contactList.empty()) {
 	   System.out.println("No contact to delete!!"); 
		}
		
			 
		else if(!contactList.empty()&&!contactList.last()) {
		 contactList.findFirst();
		while(!contactList.last()){
			if(((Contact) contactList.retrieve()).getName().equalsIgnoreCase(contactName)) {
				contactList.remove();
				 System.out.println("Contact deleted successfully!");	
			}
			
				
				 contactList.findNext();
		}
		 
			
		
		}
		else if(contactList.last()&&!contactList.empty()) {
			contactList.remove();;
			 System.out.println("Contact deleted successfully!");	
		}
	}
	
	 public void searchContacts(int criteria) {
		 if(contactList.empty())
			 System.out.println("the Contact List is empty ");
		 else {
			 contactList.search(criteria);
		 }
	 }
	 
	 public void searchEvent(int criteria) {
		 if(eventList.empty())
			 System.out.println("the event List is empty ");
		 else {eventList.search(criteria);}

	 }
	 
	 private  boolean eventConflict(Event newEvent) {
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
		 if(eventConflict((Event)event)) {
			 System.out.println("conflict whith another event ");
		 return;}
		 
		String contactName =((Event)event).getContactName();
		 if(searchByName(contactName)) {
			if(eventList.empty()) {
				eventList.add(event);
				 System.out.println("Event scheduled successfully!");}
			else  {
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
			

			
		}
		
		else  System.out.println("Contact doesn't ");

		 
	 }
	 
	 public void printContactsByFirstName(String firstName) {
		 
		 
	 }
	 
	 public void printAllEventsAlphabetically() {
		 if(eventList.empty())
			 System.out.println("event List is empty");
		 
		 eventList.PrintEvent();
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void add(T contact ) {
		if(!ContactList.isContactUnique((Contact) contact))
			System.out.println("Contact aleardy exist");
		else {
			ContactList.add(contact);
			System.out.println("Contact added successfully!");

		}
		
	}
	
	public void remove(T e) {
		if(ContactList.empty())
			return;
		
		if(ContactList.delete(e))	
			System.out.println("Contact deleted successfully");
		
					
		else System.out.println("Contact Not found");

		
	}*/
	

}