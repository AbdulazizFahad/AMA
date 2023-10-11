import java.util.Scanner;
public class Phonebook {

	public static void main(String[] args) {
		

	LinkedList<Contact> Contacts = new LinkedList<Contact>();
	
	Contact c1 = new Contact("aziz","453643636","az@swe.ksu","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c0 = new Contact("mohammed","346345345","gfdh.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c2 = new Contact("khaled","0564712006","az@swe.ksu","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c3 = new Contact("abdullah","0564712006","dsdfdfg.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c4 = new Contact("naif","0564222712006","az@swe.ksu","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c5 = new Contact("saad","0564713464362006","fh.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c6 = new Contact("rayad","46346436436436","az@swe.ksu","Riyadh,alkhuzama","14,05,203","friend from work");
	
    Contacts.insert(c1);
    Contacts.insert(c2);
    Contacts.insert(c3);
	Contacts.insert(c4);
	Contacts.insert(c5);
	Contacts.insert(c6);
	
	
	
	
	
	
	
	Scanner input = new Scanner(System.in);
	
		int choice;
	
		System.out.println("Welcome to the Linked Tree Phonebook!"); // Menu for choosing .
	
		do {	
			System.out.println("Please choose an option: ");
			System.out.println("1. Add a contact ");
			System.out.println("2. Search for a contact ");
			System.out.println("3. Delete a contact ");
			System.out.println("4. Schedule an event ");
			System.out.println("5. Print event details ");
			System.out.println("6. Print contacts by first name ");
			System.out.println("7. Print all events alphabetically ");
			System.out.println("8. Exit");
			System.out.println();
			System.out.print("Enter your Choice: ");
		
			choice = input.nextInt();
		
			while(choice < 1 || choice > 8) {     // In case user puts number not between 1-8.
				System.out.println();
				System.out.println("Sorry the choice you have choosen is not available");
				System.out.print("Enter a correct value, 1 through 8: ");
			
				choice = input.nextInt();
			}
		
			System.out.println();

			switch(choice) {
		
			case 1:
			  
				System.out.print("Enter the contact's name: ");
				String newName = input.next();
				System.out.print("Enter the contact's phone number: ");
				String newPhone = input.next();
				System.out.print("Enter the contact's email address: ");
				String newEmail = input.next();
				System.out.print("Enter the contact's address: ");
				String newAddress = input.next();
				System.out.print("Enter the contact's birthday: ");
				String newBirthday = input.next();
				System.out.print("Enter any notes for the contact: ");
				String newNotes = input.next();
				System.out.println();
				System.out.println();
				System.out.println("Contact added successfully!");
				System.out.println();

              
				break;
			
			
			case 2: 
				System.out.println("******************************************");
				System.out.println("Enter search criteria:");
				System.out.println("1. Name");
				System.out.println("2. Phone Number");
				System.out.println("3. Email Address");
				System.out.println("4. Address");
				System.out.println("5. Birthday");
				System.out.println();
				System.out.print("Enter your choice: ");
            
            
				Scanner searchCritrea = new Scanner(System.in);
				int searchChoice = input.nextInt();
            
				switch(searchChoice){
          
				case 1:
            	
					System.out.println("Enter the contact's Name:");
					String name = searchCritrea.nextLine();
					Contacts.SearchByName(name);  
          	  
					break;
            
				case 2:
					System.out.println("Enter the contact's Phonenumber:");
					String phone = searchCritrea.nextLine();
					Contacts.SearchByPhoneNumber(phone);  
                	  
					break;
            
				case 3:
					System.out.println("Enter the contact's Email Address:");
					String email = searchCritrea.nextLine();
					Contacts.SearchByEmail(email);
            
					break;
            
				case 4:
					System.out.println("Enter the contact's Address:");
					String address = searchCritrea.nextLine();
					Contacts.SearchByAddress(address);
            
					break;
            
            
				case 5:
					System.out.println("Enter the contact's Birthday:");
					String birthday = searchCritrea.nextLine();
					Contacts.SearchByAddress(birthday);
         
					break;
            
				}
				break;
			
			
			case 3: 
			
				System.out.println("Enter delete criteria:");
				System.out.println("1. Delete by name");
				System.out.println("2. Delete by phone number");
				System.out.println();
				System.out.print("Enter your choice: ");
				System.out.println();
				int deleteChoice = input.nextInt();
			
				if(deleteChoice == 1) {
				
				}
				if(deleteChoice == 2) {
				
				}
				if(deleteChoice > 2 || deleteChoice < 1) {
					System.out.println("Your input was invalid");
					System.out.println();
				}
			
				break;
			
			
			case 4: 
			
				System.out.print("Enter event title: ");
				String newEventTitle = input.next();
				System.out.print("Enter contact name: ");
				String newEventContact = input.next();
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
				String newEventDateTime = input.next();
				System.out.print("Enter event location: ");
				String newEventLocation = input.next();
			
			
			
				System.out.println();
				System.out.println("Event scheduled successfully!");
				System.out.println();
				
				break;
			
			case 5: 
			
				System.out.println("Enter search criteria");
				System.out.println("1. Contact name");
				System.out.println("2. Event title");
				System.out.println();
				System.out.print("Enter your choice: ");
				int eventSearchChoice = input.nextInt();
				
				if(eventSearchChoice == 1) {
					System.out.print("Enter the contact's name: ");
					String contact = input.next();

				
				}
				if(eventSearchChoice == 2) {
					System.out.print("Enter the event title: ");
					String eventTitle = input.next();
				
				}
				if(eventSearchChoice > 2 || eventSearchChoice < 1) {
					System.out.println("Your input was invalid!");
					System.out.println();
				}
				break;
			
			
			case 6: 
				break;
			
			case 7: 
				break;
			
			case 8: 
				System.out.println();
				System.out.println("Goodbye!");
				break;	
			}
	
		}while(choice >= 1 && choice < 8); 

	} 

		
	
 
}
	
