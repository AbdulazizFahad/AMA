import java.util.Date;

public class Phonebook {
	
    public  ContactBST BST;
    public  Event Events;

    Phonebook() {
        BST = new ContactBST();
        Events = null;
    }
    public void addContact(Contact c) {    //  add a new contact before checks for existing contact with the same name or phone number if there existing contacts it does not add. if its unique it add the new contact.
                                                                                                              
        if (BST.isExistName(c.getName())) {
            System.out.println("Contact's name already exist");
            System.out.println("");
            return;
        }
        if (BST.isExistPhone(c.getPhoneNumber())) {
            System.out.println("Contact's phone number already exist");
            System.out.println("");
            return;
        }
        BST.insert(c); // add
        System.out.println("Contact added succsefully");
        System.out.println("");
    }
    private boolean isConflict(String n, Date d) {  //check if we have conflict in date
    	
        Event tmp = Events;
        while (tmp != null) {
            tmp.getListOfContactsInEvents().findFirst();
            while (!tmp.getListOfContactsInEvents().Last()) {  //if the same event date and time then return true this is conflict!
                if (tmp.getDate().compareTo(d) == 0) 
                    return true;
                tmp.getListOfContactsInEvents().findNext();
            }
            if (tmp.getDate().compareTo(d) == 0)   //if the same event date and time then return true this is conflict!
                return true;
            tmp = tmp.getNext();
        }
        return false;  //return false so no conflict for the date and time
    }
    public boolean ScheduleEvent(String title, String name, Date date, String location, boolean isEventType) {
    	
        boolean Scheduled = true; // flag if Scheduled or Not
        String[] contactsString = name.split(","); // split between contacts with symbol ( , ) 
        for (String Name : contactsString) {
            if (!BST.isExistName(Name)) {
                System.out.println("Sorry the contact " + Name + " does not exist");
                Scheduled = false;
            } else {
                if (isConflict(Name, date)) {
                    System.out.println("Sorry there is a conflict in date and time");
                    Scheduled = false;
                }
            }
        }
        if (!Scheduled) {
            System.out.println("Something is wrong try again :)");
            System.out.println();
            return false;
        }
        Event event = new Event(title, date, location, isEventType);
        for (String n : contactsString) {
            event.getListOfContactsInEvents().add(BST.ContactByName(n));
            BST.AddEvent(event, n);
        }
        if (Events == null) { //add event
            Events = event;
            return true;
        }
        Event tmp = Events;
        Event prev = Events;
        while (tmp != null) {
            if (tmp.getTitle().compareTo(title) > 0) {
                if (tmp == Events) {
                    event.setNext(Events);
                    Events = event;
                } 
                else {
                    prev.setNext(event);
                    event.setNext(tmp);
                }
                return true;
            }
            prev = tmp;
            tmp = tmp.getNext();
        }
        prev.setNext(event);
        return true;
    } 
    public void deleteContactByName(String name) { //   delete a contact by name and also any related events 
        if (!BST.isExistName(name)) {
            System.out.println("Sorry contact " + name + " does not exist");
            System.out.println("");
        }
        else
        {
          BST.delete(name);
          Event tmp = Events;
          Event previous = Events;
          while (tmp != null) {
            if(!tmp.getListOfContactsInEvents().isEmpty()) {
               tmp.getListOfContactsInEvents().findFirst();
               while (!tmp.getListOfContactsInEvents().Last()) {
                 Contact c = tmp.getListOfContactsInEvents().retrieve();
                 if (c.getName().equals(name)) {
                     if (tmp.getIsEventType()) {
                         tmp.deleteContact(name);
                     } 
                     else {
                          if (tmp == Events) {
                              Events = Events.getNext();
                            } 
                            else {
                                previous.setNext(tmp.getNext());
                            }
                        }
                        break;
                    }
                    tmp.getListOfContactsInEvents().findNext();
                }
                Contact c = tmp.getListOfContactsInEvents().retrieve();
                if (c.getName().equals(name)) {
                    if (tmp.getIsEventType()) {
                        tmp.deleteContact(name);
                    } 
                    else {
                        if (tmp == Events) {
                            Events = Events.getNext();
                        } else {
                            previous.setNext(tmp.getNext());
                        }
                    }
                }
            }
                previous = tmp;
                tmp = tmp.getNext();

          }
        System.out.println("Contact deleted successfully");
        System.out.println("");
        }
    }
    public void SearchByName(String name) {
        BST.SearchByName(name);
    }
   public void SearchByPhoneNumber(String phone) {
        BST.SearchByPhone(phone);
    }
    public void SearchByEmail(String email) {
        BST.SearchByEmail(email);
    }
    public void SearchByAddress(String address) {
        BST.SearchByAddress(address);
    }
   public void SearchByBirthday(String birthday) {
        BST.SearchByBirth(birthday);
    }
    public void SearchByFirstName(String FirstName) {
        BST.SerachByFirstName(FirstName);
    }
    public void printEventsWithContactName(String name) { 
        BST.printEventsWithContactName(name);
    }
    public void printEventsWithTitle(String title) { // search inside a linked list of events print information for events with provided title.
        Event tmp = Events;
        while (tmp != null) {
            if (tmp.getTitle().equals(title)) {
                System.out.println(tmp);
                System.out.println("");
            }
            tmp = tmp.getNext();
        }
    }
    public void printAllContactsInfo() { // display all contacts in the BST and their informations
        BST.printAllContacts();
    }
    public void printAllEventsInfo() { // print all events 
    	if(Events==null) {
    		System.out.println("");
    		return;
    	}
        Event tmp = Events;
        while (tmp != null) {
            System.out.println(tmp);
            System.out.println("");
            tmp = tmp.getNext();
        }
    }
}