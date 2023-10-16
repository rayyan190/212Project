package pj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookMain {

	public static <T> void main(String[] args) {
		PhoneBook<T> p  = new PhoneBook<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to theLinked Tree Phonebook!");
		int x;
		boolean flag = true;
		

		
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
				 try {
				 x = input.nextInt();
				 if(x>8||x<1) {
					 System.out.println("inter 1-8"); 
					 continue;}}catch(InputMismatchException e) {
						 System.out.println("inter only 1-8");
						 input.nextLine();
						 x=0;

					 }
				 

				 System.out.println(); 
				 
				 if(x==1) {
					 System.out.print("Enter the contact's name:");
					 input.nextLine();
					 String name = input.nextLine();
					 System.out.print("Enter the contact's phone number:"); 
					 String phoneNumber = input.next();
					 System.out.print("Enter the contact's email address:"); 
					 String emailAddress = input.next();
					 
					 System.out.print("Enter the contact's address: "); 
					 input.nextLine();
					 String address =  input.nextLine();
					 System.out.print("Enter the contact's birthday:"); 
					 String birthday = input.next();
					 System.out.print("Enter any notes for the contact: "); 
					 input.nextLine();
					 String notes =  input.nextLine();
				
					 Contact NewContact = new Contact(name,phoneNumber,emailAddress,address,birthday,notes);
					 p.addContact((T) NewContact);
					 System.out.println(); 
				 }
				 
				 else if(x==2) { 
					 
					 int  criteria = 0;
					 
					 while(true){
					 System.out.println("Enter search criteria:"); 
					 System.out.println("1.Name");  
					 System.out.println("2.Phone Number");  
					 System.out.println("3.Email Address");  
					 System.out.println("4.Address");  
					 System.out.println("5.Birthday");  
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					
					 
					 
					 try {
					  criteria = input.nextInt();
					  if(criteria <1||criteria>5) {
						  continue; }
					  else  { p.searchContacts(criteria);break;}
					  }catch(InputMismatchException e) {
						  input.nextLine();
						  
					  }
					}}
					 
					 
				 
				 else if(x==3) {
					 System.out.print("Enter the contact's name you want to delete:");
					 input.nextLine();
					 String name =  input.nextLine();
					 p.removeContact(name);
				 }
				 
				 else if(x==4) {
					 System.out.print("Enter event title:");
					 input.nextLine();
					 String eventTitle = input.nextLine();
					 
					 System.out.print("Enter contact name:");  
					 input.nextLine();
					 String ContactName =input.nextLine();
					 input.nextLine();
					 System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");  
					 String dateTime = input.next();
					 input.nextLine();
					 System.out.print("Enter event location:");  
					 input.nextLine();
					 String location = input.nextLine();
					// input.nextLine();
					 Event NewEvent = new Event(eventTitle,ContactName,dateTime,location);
					 p.scheduleEvent((T) NewEvent);
					  
				 }
				 else if(x==5) {
					 while (true) {
					 System.out.println("Enter search criteria:"); 
					 System.out.println("1.contact name");  
					 System.out.println("2.Event tittle"); 
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					try { int  criteria = input.nextInt(); 
					if(criteria<1||criteria>2) {
						 System.out.println("Enter 1 or 2 please"); 

						continue;}
					else { p.searchEvent(criteria);
					break;}}catch(InputMismatchException e) {
						input.nextLine();
					}
					}}

						
					
				 
				 
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
				 
				
			}while(x!=8);
			
			
	}

}
