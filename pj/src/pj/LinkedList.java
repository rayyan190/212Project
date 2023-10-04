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
	
	
	
	public void add (T e) {
		Node <T> tmp;
		if(empty())
			current =head =new Node<T>(e); 
		
		if(!searchByNamePhone(null, null)) {
		 tmp =current.next;
		 current.next=new Node<T>(e);
		 current =current.next;
		 current.next=tmp;  
		 System.out.println("Contact added successfully!");
		}
		else {
			 System.out.println("its already exist --->not added !!");

		}
		
		
	}
	
public void delete() {
		
		
		if(current ==head) {
			head=head.next;}
		
		Node <T> tmp =head;
		while(tmp.next!=current)
			tmp=tmp.next;
		tmp.next=current.next;
		
		if(current.next==null)
			current =head;
					
		
	}




    public LinkedList<T> searchByEmail (String email ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).geteMail().equalsIgnoreCase(email)) {
    			L.add(current.data);
    			System.out.println("Contactfound!");      
      			
    		}
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
   			
    		}
    			
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
   			
    		}
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
    			
    			
    		}
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
   			
    		}
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

	
	

}
