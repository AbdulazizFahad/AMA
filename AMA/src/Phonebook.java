import java.util.Scanner;
public class Phonebook {

	public static void main(String[] args) {
		

	LinkedList<Contact> l1 = new LinkedList<Contact>();
	
	Contact c1 = new Contact("a","453643636","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c11 = new Contact("a","346345345","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c2 = new Contact("a","05644712006","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c3 = new Contact("a","0564734612006","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c4 = new Contact("a","0564734612006","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c5 = new Contact("a","0564713464362006","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
	Contact c6 = new Contact("a","46346436436436","Azizswe.ksu@gmail.com","Riyadh,alkhuzama","14,05,2003","friend from work");
    l1.insert(c6);
    l1.insert(c5);
    l1.insert(c3);
    System.out.println(l1.Search(c5));	
	
	
	
	
	
	
	/*	Scanner input = new Scanner(System.in);
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
				break;
				
				
			case 2: 
				break;
				
				
			case 3: 
				break;
				
				
			case 4: 
				break;
				
				
			case 5: 
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

		
		*/
}
 
}
	
