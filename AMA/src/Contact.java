import java.util.Scanner;

public class Contact implements Comparable<String>{
	

	private String phoneNumber;
	private String name;
	private String email;
	private String adress;     // Contact informations
	private String birthday;
	private String notes;

	public Contact() {  // Default Constracutor
	}
	public Contact(String phoneNumber, String name, String email, String adress, String birthday, String notes) {
		
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;               // Constracutor
		this.adress = adress;
		this.birthday = birthday;
		this.notes = notes;
	}
	public Contact(Contact c) {
		this.phoneNumber = c.phoneNumber;
		this.name = c.name;
		this.email = c.email;         // Copy Constracutor
		this.adress = c.adress;
		this.birthday = c.birthday;
		this.notes = c.notes;
	}
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
		
		System.out.println("Contact's phone number "+phoneNumber);
		System.out.println("Contact's name "+name);
		System.out.println("Contact's email "+email);                // This method display all contact's informations. 
		System.out.println("Contact's adress "+adress);
		System.out.println("Contact's name "+birthday);
		System.out.println("Contact's name "+notes);
	}
	public int compareTo(Contact c) {
		return name.compareTo(c.getName());      // Compare :: (name > c) -> = 1 , if (name < c) ->  = -1 , (name=c) -> = 0 
		
	}
	
	public void readContact() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Contact's phone number "+phoneNumber);
		phoneNumber = input.nextLine();
		
		System.out.println("Enter the Contact's name "+phoneNumber);
		name = input.nextLine();
		
		System.out.println("Enter the Contact's email "+phoneNumber);            // read Contact Informations
		email = input.nextLine();
		
		System.out.println("Enter the Contact's adress "+phoneNumber);
		adress = input.nextLine();
		
		System.out.println("Enter the Contact's birthday "+phoneNumber);
		birthday = input.nextLine();
		
		System.out.println("Enter the Contact's notes "+phoneNumber);
		notes = input.nextLine();
	}
	
	}
