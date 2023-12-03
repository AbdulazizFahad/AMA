import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}

public class main {
	
    public static Phonebook Phonebook = new Phonebook();
    
    public static void main(String[] args) {
    	
    	
        Scanner input = new Scanner(System.in);

        int choice = 0;
        System.out.println("........  ....... ..................................\r\n"
        		+ "........  ....... .........:-=+++*****++==-.........\r\n"
        		+ "....   ....   ..........-+*******++++*******+=:.....\r\n"
        		+ "....   ....   .......:++***+-:..........::=+***+-...\r\n"
        		+ "   ...... ..........=***=:...................-+**+-.\r\n"
        		+ "   ...... ........:+**=:.......................-+**=\r\n"
        		+ "...... ..........:***=..........................:+**\r\n"
        		+ "...... ..........+**=....-++:....:++=.....=+=:...-+*\r\n"
        		+ "...-+*+:.........**+-..:+****=..=****+:.:+****=...+*\r\n"
        		+ ".=#######-.......**+-..:+****=..=****+:.:+****=...+*\r\n"
        		+ "##########+......+**=....-==:....:==-.....-==:...-+*\r\n"
        		+ "###########*:....:***-..........................:+**\r\n"
        		+ "############=.....:+**=:.......................-+**=\r\n"
        		+ "###########*-......:=***=:...................-+**+-.\r\n"
        		+ "##########*:.........:+****..............:-+***+=...\r\n"
        		+ "#########-.............=**+...:=+++++++******=-.....\r\n"
        		+ "-########-......  ....=**+::=+*********+=--:....... \r\n"
        		+ ".=########-...........=********=:...................\r\n"
        		+ "..=########+...........-+*+=-:......................\r\n"
        		+ "...-*#######*-......................................\r\n"
        		+ "....:*########*:..........  ...............   ......\r\n"
        		+ "......=#########+...................................\r\n"
        		+ "........##########+:.........:=-........   ......   \r\n"
        		+ "   ......:##########*-.....+######*..........   ....\r\n"
        		+ "   ........-############*###########*:....... ......\r\n"
        		+ "....   ......-*#######################=..  ........ \r\n"
        		+ "....   ........:*#####################+..  ........ \r\n"
        		+ "   ........   ....=*#################*-........   ..\r\n"
        		+ "   ........   .......=*#############+:.........   ..\r\n"
        		+ "........  ....... ......:=+**#####+:.......   ......\r\n"
        		+ " .......  ....... .........................   ......\r\n"
        		+ "");
        System.out.println("***************************************");
        System.out.println("Welcome to the Tree Phonebook!"); 
        do {
        	try {
            System.out.println("Please choose an option: ");
            System.out.println("1. Add a contact ");
            System.out.println("2. Search for a contact ");
            System.out.println("3. Delete a contact ");
            System.out.println("4. Schedule an event/appointment");
            System.out.println("5. Print event details ");
            System.out.println("6. Print contacts by first name ");
            System.out.println("7. Print all events alphabetically ");
            System.out.println("8. Print all Contacts in Phonebook");
            System.out.println("9. Exit");
            System.out.println("***************************************");
            System.out.println();
            System.out.print("Please Enter your choice from  1 to 9 : ");

            while (true) {
                try {
                    choice = input.nextInt();
                    input.nextLine(); 
                    if (choice < 1 || choice > 9) {
                        throw new InvalidChoiceException("Invalid choice. Please enter a valid choice (1-9).");
                    }
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid choice (1-9).");
                    input.nextLine(); 
                } catch (InvalidChoiceException e) {
                    System.out.println(e.getMessage());
                }
			}

            switch (choice) {

                case 1: {
                    Scanner add = new Scanner(System.in);
                    System.out.println();
                    System.out.print("Enter the contact's name: ");
                    String newName = add.nextLine();
                    System.out.print("Enter the contact's phone number: ");
                    String newPhone = add.nextLine();
                    System.out.print("Enter the contact's email address: ");
                    String newEmail = add.nextLine();
                    System.out.print("Enter the contact's address: ");
                    String newAddress = add.nextLine();
                    System.out.print("Enter the contact's birthday: ");
                    String newBirthday = add.nextLine();
                    System.out.print("Enter any notes for the contact: ");
                    String newNotes = add.nextLine();
                    System.out.println();
                    System.out.println();

                    Contact newContact = new Contact(newName, newPhone, newEmail, newAddress, newBirthday, newNotes);

                    Phonebook.addContact(newContact);
                }
                break;

                case 2: {
                    System.out.println();
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Name");
                    System.out.println("2. Phone Number");
                    System.out.println("3. Email Address");
                    System.out.println("4. Address");
                    System.out.println("5. Birthday");
                    System.out.println();

                    Scanner searchCritrea = new Scanner(System.in);
                    int searchChoice = 0;
                    
                    while (true) {
    				    System.out.print("Enter your choice: ");
    				    try {
    				        searchChoice = input.nextInt();
    				        input.nextLine();// Consume the newline character
    				        if (searchChoice >= 1 && searchChoice <= 5) {
    				            break; // Exit the loop if the choice is valid
    				        } else {
    		    				System.out.println();
    				            System.out.println("Invalid choice. Please enter a choice between 1 and 5.");
    				        }
    				    } catch (InputMismatchException e) {
    	    				System.out.println();
    				        System.out.println("Invalid choice. Please enter a choice between 1 and 5.");
    				        input.nextLine(); // Clear the invalid input
    				    }
    				}
    				System.out.println();

                    switch (searchChoice) {

                        case 1:

                            System.out.println("Enter the contact's Name:");
                            String name = searchCritrea.nextLine();
                            Phonebook.SearchByName(name);

                            break;

                        case 2:
                            System.out.println("Enter the contact's Phonenumber:");
                            String phone = searchCritrea.nextLine();
                            Phonebook.SearchByPhoneNumber(phone);

                            break;

                        case 3:
                            System.out.println("Enter the contact's Email Address:");
                            String email = searchCritrea.nextLine();
                            Phonebook.SearchByEmail(email);

                            break;

                        case 4:
                            System.out.println("Enter the contact's Address:");
                            String address = searchCritrea.nextLine();
                            Phonebook.SearchByAddress(address);

                            break;

                        case 5:
                            System.out.println("Enter the contact's Birthday:");
                            String birthday = searchCritrea.nextLine();
                            Phonebook.SearchByBirthday(birthday);

                            break;

                    }

                }
                break;
                    
                    
                case 3:
                {
                    System.out.println();
                    System.out.print("Enter Name of contact: ");
                    String deleteByName = input.nextLine();
                    Phonebook.deleteContactByName(deleteByName);
                    System.out.println("");
                }
                break;
   
                case 4:
                {
                    System.out.println("");
                    System.out.println("Enter type:\n"
                            + "1. event\n"
                            + "2. appointment\n");
                    int searchChoice = 0;
                    
                    while (true) {
    				    System.out.print("Enter your choice: ");
    				    try {
    				    	searchChoice = input.nextInt();
    				        input.nextLine(); // Consume the newline character
    				        System.out.println();

    				        if (searchChoice == 1 || searchChoice == 2) {
    				            break; // Exit the loop if the choice is valid
    				        } else {
        				        System.out.println();
    				            System.out.println("Invalid choice. Please enter 1 or 2.");
    				        }
    				    } catch (InputMismatchException e) {
    				        System.out.println();
    				        System.out.println("Invalid choice. Please enter 1 or 2.");
    				        input.nextLine(); // Clear the invalid input
    				    } catch (Exception e1) {
    			            System.out.println("There is an error: " + e1.getMessage());
    			            input.nextLine(); // Clear the invalid input
    				    	
    				    }
    				}

                    switch (searchChoice) {
                    
                        case 1:{
                        
                            System.out.print("Enter event title: ");
                            String title = input.nextLine();
                            System.out.print("Enter the contacts names separately by a comma between names ( , ): ");
                            String name = input.nextLine();
                            String date;
                            
                            while (true) {
                                try {
                                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                                    date = input.nextLine();
                                    Date parsedDate = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(date);

                                    // Validate the month, day, and year
                                    int enteredMonth = Integer.parseInt(date.split("/")[0]);
                                    int enteredDay = Integer.parseInt(date.split("/")[1].split(" ")[0]);
                                    int enteredYear = Integer.parseInt(date.split("/")[2].split(" ")[0]);

                                    // Add a condition to check if the entered year is under December 3, 2023
                                    if (enteredMonth < 1 || enteredMonth > 12 || enteredDay < 1 || enteredDay > 31 || enteredYear < 2023) {
                                        System.out.println("Invalid date. Please enter a valid month (1-12), day (1-31), and year after December 2023.");
                                    } else {
                                        System.out.println("Valid date format. Date entered: " + parsedDate);
                                        break;
                                    }
                                } catch (ParseException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Invalid date format. Please enter the date in MM/DD/YYYY HH:MM format.");
                                }
                            }
                            
                            System.out.print("Enter event location: ");
                            String location = input.nextLine();
                            System.out.println("");
                            if (Phonebook.ScheduleEvent(title, name, new Date(date), location , true)) { // set to event
                                System.out.println("Event scheduled successfully!");
                            }
                             System.out.println("");
                        }
                        break;
                            
                            
                        case 2:
                        {
                            System.out.print("Enter appointment title: ");
                            String title = input.nextLine();
                            System.out.print("Enter contacts name: ");
                            String name = input.nextLine();
                            String date;
                            
                            while (true) {
                                try {
                                    System.out.print("Enter appointment date and time (MM/DD/YYYY HH:MM): ");
                                    date = input.nextLine();
                                    Date parsedDate = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(date);

                                    // Validate the month, day, and year
                                    int enteredMonth = Integer.parseInt(date.split("/")[0]);
                                    int enteredDay = Integer.parseInt(date.split("/")[1].split(" ")[0]);
                                    int enteredYear = Integer.parseInt(date.split("/")[2].split(" ")[0]);

                                    // Add a condition 
                                    if (enteredMonth < 1 || enteredMonth > 12 || enteredDay < 1 || enteredDay > 31 || enteredYear < 2023) {
                                        System.out.println("Invalid date. Please enter a valid month (1-12), day (1-31), and year after 2023.");
                                    } else {
                                        System.out.println("Valid date format. Date entered: " + parsedDate);
                                        break;
                                    }
                                } catch (ParseException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Invalid date format. Please enter the date in MM/DD/YYYY HH:MM format.");
                                }
                            }
                            
                            System.out.print("Enter appointment location: ");
                            String location = input.nextLine();
                             System.out.println("");
                            if (Phonebook.ScheduleEvent(title, name, new Date(date), location , false)) { // set appointment
                                System.out.println("Appointment scheduled successfully!");
                            }
                             System.out.println("");
                        }break;
                    }
                }
                break;

                    
                case 5: {
                    System.out.println();
                    System.out.println("Enter search criteria");
                    System.out.println("1. Contact name");
                    System.out.println("2. Event title");
                    System.out.println();
                    int eventSearchChoice = 0;

                    while (true) {
    				    System.out.print("Enter your choice: ");
    				    try {
    				        eventSearchChoice = input.nextInt();
    				        input.nextLine(); // Consume the newline character

    				        if (eventSearchChoice == 1 || eventSearchChoice == 2) {
    				            break; // Exit the loop if the choice is valid
    				        } else {
    				        	System.out.println();
    				            System.out.println("Invalid choice. Please enter 1 or 2.");
    				        }
    				    } catch (InputMismatchException e11) {
				        	System.out.println();
    				        System.out.println("Invalid choice. Please enter 1 or 2.");
    				        input.nextLine(); // Clear the invalid input
    				    }
    				}
                    switch (eventSearchChoice) {
                        case 1:
                            System.out.print("Enter the contact's name: ");
                            String contactName = input.nextLine();
                            System.out.println();
                            Phonebook.printEventsWithContactName(contactName);
                            break;
                        case 2:
                            System.out.print("Enter the event title: ");
                            String eventTitle = input.nextLine();
                            System.out.println();
                            Phonebook.printEventsWithTitle(eventTitle);
                            break;
                    }
                }
                break;
                    
                case 6:
                {
                    Scanner FirstName = new Scanner(System.in);
				System.out.println();
				System.out.println("Enter the first name:");
				String firstName = FirstName.nextLine();
				Phonebook.SearchByFirstName(firstName);
                }break;
                    
                    
                case 7:
                    System.out.println();
                    Phonebook.printAllEventsInfo();
                    
                break;
                    
                case 8:
                	Phonebook.printAllContactsInfo();
				break;
				
			case 9: 
				System.out.println();
				System.out.println("Goodbye!");
				break;	
            }
        	}catch(InputMismatchException e) {
        		System.out.println("Invaild input");
        		input.nextLine();
        	}
        } while (choice >= 1 && choice < 9);
    }
}