package pj;
/*

CLASS: LinkedList.java

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

		if (current.next == null)      // set the current to head because to the the next is null
			current = head;
		else
			current = current.next;
	}
	
	
	
  
	
	
	 public void PrintContacts() {
    	 Node<T> current = head;
    	 while (current != null) {
    		 ((Contact) current.getData()).PrintContact();
    		 current=current.next;
    	 }

	}
	




    public LinkedList<T> searchByEmail (String email ){ 
    	boolean flag = false;
    	LinkedList<T> L =new LinkedList<>();
    	Node<T> current = head;
    	while (current!=null) {               
    		if(((Contact) current.getData()).geteMail().equalsIgnoreCase(email)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");     // if found --> print its info
    			 ((Contact) current.getData()).PrintContact();
    			flag = true;
    		}
    		current=current.next;	
    	}
    	if(flag==false)
  		  System.out.println("Contact not found!!");  
    	return L;
    }
    
    public LinkedList<T> searchByAddres (String addres ){
    	boolean flag = false;
    	LinkedList<T> L =new LinkedList<>();
    	Node<T> current = head;
    	while (current!=null) { 
    		if(((Contact) current.getData()).getAddres().equalsIgnoreCase(addres)) { 
    			L.add(current.data);
    			System.out.println("Contactfound!");  // if found --> print its info
    			 ((Contact) current.getData()).PrintContact();
    			flag = true;
   			
    		}
    		current=current.next;
    			
    	}
    	if(flag==false)
    		 System.out.println("Contact not found!!");  
    	return L;
    }
    
    public LinkedList<T> searchByBirthday (String birthD ){
    	boolean flag = false;
    	LinkedList<T> L =new LinkedList<>();
        Node<T> current = head;
    	while (current!=null) {  
    		if(((Contact) current.getData()).getBirthday().equalsIgnoreCase(birthD)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");   //// if found --> print its info
    			 ((Contact) current.getData()).PrintContact();
    			flag = true;
    		} 
    		current=current.next;
    	}
    	if(flag==false)
    		 System.out.println("Contact not found!!");  
    	return L;
    }
    
    
    public LinkedList<T> searchByPhoneNum (String phone ){
    	boolean flag = false;
    	LinkedList<T> L =new LinkedList<>();
    	Node<T> current = head;
    	while (current!=null) {
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone)) { 
    			L.add(current.data);
    			System.out.println("Contactfound!");      //// if found --> print its info
    			 ((Contact) current.getData()).PrintContact();
    			flag = true;
    		}
    		current=current.next;	
    	}
    	if(flag==false)
    		 System.out.println("Contact not found!!");  
    	return L;
    }
    
    
    public LinkedList<T> searchByName (String name ){
    	boolean flag = false;
    	LinkedList<T> L =new LinkedList<>();
    	Node<T> current = head;
    	while (current!=null) {
    		if(((Contact) current.getData()).getName().equalsIgnoreCase(name)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");  
    			 ((Contact) current.getData()).PrintContact();
    			flag = true;
    		}
    		current=current.next;	
    	}
    	if(flag==false)
    		 System.out.println("Contact not found!!");  
    	return L;
    }
    
    
    public boolean searchByNamePhone (String name, String phone ){
    	boolean flag=false;
    	                               
        Node<T> current = head;
    	while (current!=null) {
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone)|| ((Contact) current.getData()).getName().equalsIgnoreCase(name))
    		flag =true;
    			
    	}
    	return flag;
    }
    
    
    public void searchContacts(int criteria){
    	Scanner input = new Scanner(System.in);       // receive the way of searching then implement it
    	if(criteria==1) {
    		 System.out.print("Enter the contact's name:");
    		 String name = input.nextLine();
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
    		 String address = input.nextLine();
    		searchByAddres (address );
    	}
    	else if(criteria==5) {
    		 System.out.print("Enter the contact's birthday:"); 
    		 String birthday = input.nextLine();
    		searchByBirthday (birthday);
    	}
    }


    public boolean isContactUnique(Contact newContact) {
	    Node<T> current = head;
	    while (current != null) {            // take the contact then make the comparison--> if Unique return true otherwise false
	        if ( ((Contact) current.getData()).getName().equalsIgnoreCase(newContact.getName()) || 
	        		((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(newContact.getPhoneNumber())) {
	            return false;
	        }
	        current = current.next;
	    }
	    return true;
	}
    
    public void PrintEvents() {
   	 Node<T> current = head;
   	 while (current != null) {
   		((Event) current.getData()).PrintEvent();
   		 current=current.next;
   	 }

		
	}
    
   
    
    public LinkedList<T> searchByContactName(String contactname){
    	boolean flag = false;
		 LinkedList<T> L =new LinkedList<>();
		 Node<T> current = head;
		 while(current!=null) {
			 if(((Event) current.getData()).getContactName().equalsIgnoreCase(contactname)) {
				 L.add(current.data);
				 System.out.println("Event found!"); 
				 ((Event) current.getData()).PrintEvent();
				 flag = true;
			 }
			 current = current.next;
		 }
		 if(flag==false)
			 System.out.println("Event Not found!"); 
		 return L;
	 }
    
    public LinkedList<T> searchByEventTitle(String Eventtittle){
    	boolean flag = false;
		 LinkedList<T> L =new LinkedList<>();
		 Node<T> current = head;
		 while(current!=null) {
			 if(((Event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
				 L.add(current.data);
				 System.out.println("Event found!"); 
				 ((Event) current.getData()).PrintEvent();
				 flag = true;
			 }			 
			 current = current.next;
		 }
		 if(flag==false)
			 System.out.println("Event Not found!");
		 return L;
	 }
    
    public void searchEvent(int criteria) {           // receive the way of searching then implement it
		 Scanner input = new Scanner(System.in);
		 if(criteria==1) {
			 System.out.println("Enter the contact's Name:");  
			 String contactName = input.nextLine();
			 searchByContactName(contactName);
		 }
		 else if(criteria==2) {
			 System.out.println("Enter the event title:");  
			 String EventTitle = input.nextLine();
			 searchByEventTitle(EventTitle);
		 }
	 }
    

	
	

}
