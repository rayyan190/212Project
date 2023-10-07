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
			current =head =new Node<T>(e); 
		else {
		 tmp =current.next;
		 current.next=new Node<T>(e);
		 current =current.next;
		 current.next=tmp;}  
		
		
		
	}
	
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
	
	
	
   /* public boolean delete(T e) {
		if(current ==head) {
			head=head.next;
		return true;}
		
		while (current!=null ) {
			if(((Contact) current.getData()).getName().equalsIgnoreCase(((Contact) e).getName())) 
				break;
				current=current.next;
			
		}
	
		Node <T> tmp =head;
		while(tmp.next!=current)
			tmp=tmp.next;
		tmp.next=current.next;
		
		if(current.next==null)
			current =head;
		return true;
					
		
	}*/
	
	
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
    	while (current!=null) {
    		if(((Contact) current.getData()).geteMail().equalsIgnoreCase(email)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");    
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
    		if(((Contact) current.getData()).getAddres().equalsIgnoreCase(addres)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");  
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
    		if(((Contact) current.getData()).getBirthday().equalsIgnoreCase(birthD)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");   
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
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");      
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
    	Scanner input = new Scanner(System.in);
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

	    while (current != null) {
	        Contact existingContact = (Contact) current.data; // Assuming Contact is the type stored in the list

	        if (existingContact.getName().equalsIgnoreCase(newContact.getName()) ||
	            existingContact.getPhoneNumber().equalsIgnoreCase(newContact.getPhoneNumber())) {
	            return false; // A contact with the same name or phone number already exists
	        }

	        current = current.next;
	    }

	    return true; // The contact is unique
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
    
    public void searchEvent(int criteria) {
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
