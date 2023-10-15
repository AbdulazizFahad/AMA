import java.util.Scanner; 

    public class Contact implements Comparable<String>{
    	
	private String name;
	private String phoneNumber;
	private String email;
	private String address;     // Contact informations
	private String birthday;
	private String notes;
	private LinkedList<Event> events = new LinkedList<Event>(); // All event that has been schedule with this contact

	
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;               // Constructor
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
	}
	public LinkedList<Event> getEvents() {
		return events;
	}
	public void setEvents(LinkedList<Event> events) {
		this.events = events;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}                                                                 // setters and getters 
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void displayContact() {
		 
		System.out.println("Name: "+name);
		System.out.println("Phonenumber: "+phoneNumber);
		System.out.println("Email: "+email);             // This method display all contact's informations. 
		System.out.println("Address: "+address);
		System.out.println("Birthday: "+birthday);
		System.out.println("Notes: "+notes);
	}
 	@Override
	public int compareTo(String cName) {                               //## We will use this method in Sorting to know which Object must be First 
		return this.name.compareTo(cName); //## This method Will 
                                                    //## For Example "a".compareTo("z"); --> Will return -25 since z is greater than a in the decimal value
		                                            
	}
	
}