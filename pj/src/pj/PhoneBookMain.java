package pj;

import java.util.Scanner;

public class PhoneBookMain {

	public static <T> void main(String[] args) {
		PhoneBook<T> p  = new PhoneBook<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to theLinked Tree Phonebook!");
		int x;
		boolean flag = true;
		

		try {
			do {
				System.out.println("Please choose an option:");  
				System.out.println("1.Add a contact");  
				System.out.println("2.Search for a contact");  
				System.out.println("3.Delete a contact");  
				System.out.println("4.Schedule an event");  
				System.out.println("5.Print event details");  
				System.out.println("6.Printcontacts byfirstname ");  
				System.out.println("7.Print all events alphabetically");  
				System.out.println("8.Exit"); 
				System.out.println();
				System.out.print("Enter your choice:"); 
				 x = input.nextInt();
				 System.out.println(); 
				 
				 if(x==1) {
					 //باقي نزين انه يضيف مرتب هذا اضافه عاديه
					 System.out.print("Enter the contact's name:");
					 String name = input.next();
					 input.nextLine();
					 System.out.print("Enter the contact's phone number:"); 
					 String phoneNumber = input.next();
					 System.out.print("Enter the contact's email address:"); 
					 String emailAddress = input.next();
					 System.out.print("Enter the contact's address: "); 
					 String address = input.next();
					 System.out.print("Enter the contact's birthday:"); 
					 String birthday = input.next();
					 System.out.print("Enter any notes for the contact: "); 
					 String notes = input.next();
					 Contact NewContact = new Contact(name,phoneNumber,emailAddress,address,birthday,notes);
					 p.addContact((T) NewContact);
					 System.out.println(); 
				 }
				 
				 else if(x==2) {
					 System.out.println("Enter search criteria:"); 
					 System.out.println("1.Name");  
					 System.out.println("2.Phone Number");  
					 System.out.println("3.Email Address");  
					 System.out.println("4.Address");  
					 System.out.println("5.Birthday");  
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					 int  criteria = input.nextInt();
					 p.searchContacts(criteria);
					
					 
				 }
				 
				 else if(x==3) {
					 System.out.print("Enter the contact's name you want to delete:");
					 String name = input.next();
					 input.nextLine();
					 p.removeContact(name);
				 }
				 
				 else if(x==4) {
					 System.out.print("Enter event title:");
					 String eventTitle = input.next();
					 input.nextLine();
					 System.out.print("Enter contact name:");  
					 String ContactName = input.next();
					 input.nextLine();
					 System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");  
					 String dateTime = input.next();
					 input.nextLine();
					 System.out.print("Enter event location:");  
					 String location = input.next();
					 input.nextLine();
					 Event NewEvent = new Event(eventTitle,ContactName,dateTime,location);
					 p.scheduleEvent((T) NewEvent);
					  
				 }
				 else if(x==5) {
					 System.out.println("Enter search criteria:"); 
					 System.out.println("1.contact name");  
					 System.out.println("2.Event tittle"); 
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					 int  criteria = input.nextInt();
					 p.searchEvent(criteria);
				 }
				 
				 else if(x==6) {
					 System.out.println("Enter the firstname:");
					 String firstName =  input.next();
			
					 input.nextLine();
					 p.printContactsByFirstName(firstName);
					 //input.nextLine();


				 }
				 
				 else if(x==7) {
					 p.printAllEventsAlphabetically();
				 }
				 else if(x==8) {
					 System.out.println("Goodbye!"); 
				 }
				 else
					 System.out.println("choose from 1-8"); 
				
			}while(x!=8);
			
			
			
			
		}catch(Exception e ) {
			System.out.println("Enter Integer only 1-8");   
		
			//flag=false;
			
		}
		
		

	}

}
