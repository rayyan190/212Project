package pj;
/*

CLASS: PhoneBookMain.java

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
					 System.out.print("Enter the contact's birthday (YYYY/MM/DD):"); 
					 String birthday = input.next();
					 if(!isValidDate(birthday)) {
				     System.out.print("Enter again correctly"); 
					 birthday = input.next();
					 }
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
					  else  { 
						  p.searchContacts(criteria);
						  System.out.println();    
						  break;
						  }
					  }catch(InputMismatchException e) {
						  input.nextLine();
						  
					  }
					}
					 }
					 
					 
				 
				 else if(x==3) {
					 System.out.print("Enter the contact's name you want to delete:");
					 input.nextLine();
					 String name =  input.nextLine();
					 p.removeContact(name);
					 System.out.println();    
				 }
				 
				 else if(x==4) {
					 String format = "YYYY/MM/DD/HH:MM";
					 System.out.print("Enter event title:");
					 input.nextLine();
					 String eventTitle = input.nextLine();
					 System.out.print("Enter contact name:"); 
					 String ContactName =input.nextLine();
					 input.nextLine();
					 System.out.print("Enter event date and time (YYYY/MM/DD/HH:MM):");  
					 String dateTime =  input.next();
					 if(!isDateTimeValid(dateTime,format)) {
				     System.out.print("Enter again correctly");  
					 dateTime = input.next();
					 }
					 System.out.print("Enter event location:");  
					 input.nextLine();
					 String location = input.nextLine();
					 
					 Event NewEvent = new Event(eventTitle,ContactName,dateTime,location);
					 p.scheduleEvent((T) NewEvent);
					 System.out.println();        
					  
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
					else { 
						p.searchEvent(criteria);
						System.out.println();    
					    break;
					}
					}catch(InputMismatchException e) {
						input.nextLine();
					}
					}
					 }

						
					
				 
				 
				 else if(x==6) {
					 System.out.println("Enter the firstname:");
					 String firstName =  input.next();
			
					 input.nextLine();
					 p.printContactsByFirstName(firstName);
					 System.out.println();    
					 //input.nextLine();


				 }
				 
				 else if(x==7) {
					 p.printAllEventsAlphabetically();
					 System.out.println();    
				 }
				 else if(x==8) {
					 System.out.println("Goodbye!"); 
				 }
				 
				
			}while(x!=8);
			
			
	}
	
	public static boolean isValidDate(String Date) {
	   
	    String[] date = Date.split("-");
	    if (date.length != 3) {
	        return false; 
	    }

	    try {
	        int year = Integer.parseInt(date[0]);
	        int month = Integer.parseInt(date[1]);
	        int day = Integer.parseInt(date[2]);

	        
	        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
	            return false; 
	        }

	       
	        if (month == 4 || month == 6 || month == 9 || month == 11) {
	            if (day > 30) {
	                return false; 
	            }
	        } else if (month == 2) {
	           
	            if (day > 28) {
	                return false; 
	            }
	        }

	        return true;
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	}
	
	
	
    public static boolean isDateTimeValid(String dateTime, String format) {
        try {
            SimpleDateFormat d = new SimpleDateFormat(format);
            d.setLenient(false);

            Date Date = d.parse(dateTime);

            if (Date != null) {
               
                return true;
            }
        } catch (ParseException e) {
           
        }

        return false;
    }

	
	
	
	
	
	
	
	

}
