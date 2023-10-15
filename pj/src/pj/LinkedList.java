package pj;

import java.util.Scanner;

public class LinkedList <T> {
	
	
	private Node<T> head;
	private Node<T> current;
	
	public LinkedList() {
		head =current=null;
	}
	
	public boolean empty () {
		return head==null;
	}
	
	public boolean last() {
		return current.next==null;
	}
	public boolean full() {
		return false;
	}
	public void findFirst() {
		current =head;
	}
	public void findNext() {
		current=current.next;
	}
	public T retrieve( ) {
		return current.data;

	}
	public void update(T e) {
		current.data = e;
	}
	
	
	
	public void add (T e) {
		Node <T> tmp;
		if(empty())
			current =head =new Node<T>(e);  // if empty --> first element
		
		else {
		 tmp =current.next;                 // else add it after current 
		 current.next=new Node<T>(e);
		 current =current.next;
		 current.next=tmp;}  
		
		
		
	}
	
	public void remove () {         
		if (current == head) {      // just one element 
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)      // set the current to head becuase to the the next is null
			current = head;
		else
			current = current.next;
	}
	
	
	
  
	
	
	 public void PrintContact() {
    	 Node<T> current = head;
    	 while (current != null) {
	    	    System.out.println("Name:"+((Contact) current.getData()).getName()); 
	 			System.out.println("Phone Number:"+((Contact) current.getData()).getPhoneNumber()); 
	 			System.out.println("Email Address:"+((Contact) current.getData()).geteMail()); 
	 			System.out.println("Address:"+((Contact) current.getData()).getAddres()); 
	 			System.out.println("Birthday:"+((Contact) current.getData()).getBirthday()); 
	 			System.out.println("Notes:"+((Contact) current.getData()).getNotes());
    		 current=current.next;
    	 }

		
	}




    public LinkedList<T> searchByEmail (String email ){ 
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {               //nckndsckldnclk
    		if(((Contact) current.getData()).geteMail().equalsIgnoreCase(email)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");     // if found --> print its info
    			PrintContact();
      			
    		}
    		else  System.out.println("Contact not found!!");  
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByAddres (String addres ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) { 
    		if(((Contact) current.getData()).getAddres().equalsIgnoreCase(addres)) { //ndsklndsklfnlfknsf
    			L.add(current.data);
    			System.out.println("Contactfound!");  // if found --> print its info
    			PrintContact();
   			
    		}
    		else System.out.println("Contact not found!!");  
    			
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByBirthday (String birthD ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {  
    		if(((Contact) current.getData()).getBirthday().equalsIgnoreCase(birthD)) { //ljhgiuguigui
    			L.add(current.data);
    			System.out.println("Contactfound!");   //// if found --> print its info
    			PrintContact();
   			
    		}
    		else System.out.println("Contact not found!!");  
    		current=current.next;
    			
    	}
    	return L;
    }
    
    
    public LinkedList<T> searchByPhoneNum (String phone ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone)) { //lfjiehfeiofhioew
    			L.add(current.data);
    			System.out.println("Contactfound!");      //// if found --> print its info
    			PrintContact();
    			
    			
    		}
    		else System.out.println("Contact not found!!");   
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByName (String name ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getName().equalsIgnoreCase(name)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");  
    			PrintContact();
   			
    		}
    		else System.out.println("Contact not found!!");  
    		current=current.next;
    			
    	}
    	return L;
    }
    
    
    public boolean searchByNamePhone (String name, String phone ){
    	boolean flag=false;
    	                               
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone)|| ((Contact) current.getData()).getName().equalsIgnoreCase(name))
    		flag =true;
    			
    	}
    	return flag;
    }
    
    
    public void search(int criteria){
    	Scanner input = new Scanner(System.in);       // receive the way of searching then implement it
    	if(criteria==1) {
    		 System.out.print("Enter the contact's name:");
    		 String name = input.next();
    		   
    		searchByName (name);
    	}
    	else if(criteria==2) {
    		 System.out.print("Enter the contact's phone number:"); 
    		 String phoneNumber = input.next();
    		 searchByPhoneNum (phoneNumber);
    	}
    	
    	else if(criteria==3) {
    		 System.out.print("Enter the contact's email address:"); 
    		 String emailAddress = input.next();
    		searchByEmail (emailAddress );
    	}
    	else if(criteria==4) {
    		 System.out.print("Enter the contact's address: "); 
    		 String address = input.next();
    		searchByAddres (address );
    	}
    	else if(criteria==5) {
    		 System.out.print("Enter the contact's birthday:"); 
    		 String birthday = input.next();
    		searchByBirthday (birthday);
    	}
    }


    public boolean isContactUnique(Contact newContact) {
	    Node<T> current = head;

	    while (current != null) {            // take the contact then make the comparison--> if Unique return true otherwise false
	        Contact existingContact = (Contact) current.data; 

	        if (existingContact.getName().equalsIgnoreCase(newContact.getName()) ||
	            existingContact.getPhoneNumber().equalsIgnoreCase(newContact.getPhoneNumber())) {
	            return true;
	        }

	        current = current.next;
	    }

	    return false;
	}
    
    public void PrintEvent() {
   	 Node<T> current = head;
   	 while (current != null) {
	    	    System.out.println("Event title:"+((Event) current.getData()).getEventTitle() ); 
	 			System.out.println("Contact Name:"+((Event) current.getData()).getContactName()); 
	 			System.out.println("Date Time:"+((Event) current.getData()). getDateTime()); 
	 			System.out.println("Location:"+((Event) current.getData()).getLocation() ); 

	 			
   		 current=current.next;
   	 }

		
	}
    
    public LinkedList<T> searchByContactName(String contactname){
		 LinkedList<T> L =new LinkedList<>();
		 Node<T> current = head;
		 while(current!=null) {
			 if(((Event) current.getData()).getContactName().equalsIgnoreCase(contactname)) {
				 L.add(current.data);
				 System.out.println("Event found!"); 
				 PrintEvent();
			 }
			 else  System.out.println("Event Not found!"); 
			 
			 current = current.next;
		 }
		 return L;
	 }
    
    public LinkedList<T> searchByEventTitle(String Eventtittle){
		 LinkedList<T> L =new LinkedList<>();
		 Node<T> current = head;
		 while(current!=null) {
			 if(((Event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
				 L.add(current.data);
				 System.out.println("Event found!"); 
				 PrintEvent();
			 }
			 else  System.out.println("Event Not found!"); 
			 
			 current = current.next;
		 }
		 return L;
	 }
    
    public void searchEvent(int criteria) {           // receive the way of searching then implement it
		 Scanner input = new Scanner(System.in);
		 if(criteria==1) {
			 System.out.println("Enter the contact's Name:");  
			 String contactName = input.next();
			 searchByContactName(contactName);
		 }
		 else if(criteria==2) {
			 System.out.println("Enter the event title:");  
			 String EventTitle = input.next();
			 searchByEventTitle(EventTitle);
		 }
	 }
    

	
	

}
