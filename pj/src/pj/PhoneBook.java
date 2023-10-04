package pj;

public class PhoneBook <T>{
	private LinkedList<T> ContactList;
	private LinkedList<T> EventList;
	
	public PhoneBook() {
		ContactList=new LinkedList<>();
		EventList=new LinkedList<>();
	}
	
	public void add(T contact ) {
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

		
	}
	

}
