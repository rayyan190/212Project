package pj;

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
    		if(((Contact) current.getData()).geteMail().equalsIgnoreCase(email))
    			L.add(current.data);
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByAddres (String addres ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getAddres().equalsIgnoreCase(addres))
    			L.add(current.data);
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByBirthday (String birthD ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getBirthday().equalsIgnoreCase(birthD))
    			L.add(current.data);
    		current=current.next;
    			
    	}
    	return L;
    }
    
    
    public LinkedList<T> searchByPhoneNum (String phone ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(phone))
    			L.add(current.data);
    		current=current.next;
    			
    	}
    	return L;
    }
    
    public LinkedList<T> searchByName (String name ){
    	LinkedList<T> L =new LinkedList<>();
    	
    	
    	findFirst();
    	while (current!=null) {
    		if(((Contact) current.getData()).getName().equalsIgnoreCase(name))
    			L.add(current.data);
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




	
	

}
