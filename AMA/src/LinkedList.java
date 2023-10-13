//
class Node<T> {
	
	public T data;
	public Node<T> next;
	
	public Node(T data) {
		
		this.data = data;
		next=null;
	}
}
public class LinkedList<T> {
	
	private Node<T> head;
	private Node<T> current;
	
	public LinkedList() {
		
		head = null;
		current = null;
	}
	
	public boolean Full() {      // Check if the LinkedList is full (We know it's never FULL :) )
	
		return false;
	}
	
	public boolean isEmpty() {     //Checking if the LinkedList is empty
        return head == null;
    }

    public boolean Last() {  //Checking if the current node is the last one on the LinkedList
        return current.next == null;
    }
    public void findFirst() { // making the current point on the first node
        current = head;
    }

    public void findNext() { // move the current to the next node
        current = current.next;
    }

    public T retrieve()    {  // obtain the current node data 
        return current.data;
    }

    public void update(T val) { // updating the node data
        current.data = val;
    }

    public void insert(T val) { // inserting nodes

        Node<T> newNode = new Node<T>(val);
   
        if (head==null) {
        	head=newNode;
        	current=newNode;
        }
        	
        else {

            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
        }
    }

    public void remove() { // removing the current node and put the current in the next Node 

        if (current == head) {
            head = head.next;
            current=current.next;
        }
            else {
                Node<T> tmp = head;

                while(tmp.next != current) {
                    tmp = tmp.next;
            }
        
        tmp.next = current.next;
            }
        if (current.next != null)
            current = current.next;
        else
            current = head;
    }
    public void displayAllContactsInformation() {
    	if(head == null)
    		System.out.println("List is empty");
    	    System.out.println();
    	Node<T> tmp = head;
    		while(tmp != null) {
    			((Contact)tmp.data).displayContact();
    			System.out.println("-------------------------------------------------");
    			tmp = tmp.next;
    		}    	
    }
    public void displayAllEventsInformation() {
    	Node<T> tmp = head;
    		while(tmp != null) {
    			((Event)tmp.data).displayEvent();
    			System.out.println("-------------------------------------------------");
    			tmp = tmp.next;
    		}    	
    }
    public void PrintLinkedListOfContacts(LinkedList<Contact> C) {
    	
    	if(C.head == null) 
    		System.out.println("List is empty");
    	else {
    		Node<Contact> tmp = C.head;
    		while(tmp!=null) {
    			tmp.data.displayContact(); // display Contacts
    			tmp.data.getEventsInContact().displayAllEventsInformation(); // display all events with the contact 
    			System.out.println("-------------------------------------------------");
    			tmp = tmp.next;
    		}
    	}
    }
    public void PrintLinkedListOfEvents() { // Come back to make sure its correct 
    	
    	if(head == null)
    		System.out.println("List is empty");
    	else {
    		Node<T> tmp = head;
    		while(tmp != null) {
    			((Event)tmp.data).displayEvent(); // display Events
    			((Event)tmp.data).getContactsInEvent().displayAllContactsInformation(); // display all contacts with the event
			    System.out.println("-------------------------------------------------");
			    tmp = tmp.next;
    		}
    	}
    }
    
    public boolean isUniqueForContact(T x) {
    	if(head == null)
    		return true;
    	Node<T> tmp = head;
    	while(tmp != null) {
    		if(((Contact)x).getPhoneNumber().equalsIgnoreCase(((Contact)tmp.data).getPhoneNumber()) || ((Contact)x).getName().equalsIgnoreCase(((Contact)tmp.data).getName()))
    			return false;
    		tmp=tmp.next;
    	}
		return true;
    }
    public void addContact(T x) {

        if(isUniqueForContact(x)==false) {
            System.out.println("Contact already exists!");
            System.out.println();
            return;
        }
        else {
        	
        Node<T> newNode = new Node<T>(x);
        
        if(head==null) {
        	
            head=newNode;
            current=newNode;
            System.out.println("Contact added successfully!");
            System.out.println();
            return;
        }
        else {

            if(((Contact)x).compareTo(((Contact)head.data).getName() ) < 0) {
                newNode.next = head;
                head = newNode;
                System.out.println("Contact added successfully!");
                System.out.println();
                return;
            }
            else {
                Node<T> tmp = head;
                Node<T> pervious = null;
                while(tmp != null && ((Contact)tmp.data).compareTo(((Contact)x).getName()) <= 0 ){
                    pervious = tmp;
                    tmp = tmp.next;
                }
                pervious.next = newNode;
                newNode.next = tmp;
                System.out.println("Contact added successfully!");
                System.out.println();
             }
          }
        }  
    }
   
    public boolean isUniqueForEvent(String title) {
    	if(head == null)
    		return true;
    	Node<T> tmp = head;
    	while(tmp != null) {
    		if(((Event)tmp.data).getTitle().equalsIgnoreCase(title))
    			return false;
    		tmp=tmp.next;
    	}
		return true;
    }
    public void addEvent(T x) {

        if(isUniqueForEvent(((Event)x).getTitle())==false) {
            System.out.println("Event already exists!");
            System.out.println();
            return;
        }
        else {
        	
        Node<T> newNode = new Node<T>(x);
        
        if(head==null) {
        	
            head=newNode;
            current=newNode;
            System.out.println("Event added successfully!");
            System.out.println();
            return;
        }
        else {

            if(((Event)x).getTitle().compareTo(((Event)head.data).getTitle() ) < 0) {
                newNode.next = head;
                head = newNode;
                System.out.println("Event added successfully!");
                System.out.println();
                return;
            }
            else {
                Node<T> tmp = head;
                Node<T> pervious = null;
                while(tmp != null && ((Event)tmp.data).compareTo(((Event)x).getTitle()) <= 0 ){
                    pervious = tmp;
                    tmp = tmp.next;
                }
                pervious.next = newNode;
                newNode.next = tmp;
                System.out.println("Event added successfully!");
                System.out.println();
             }
          }
        }  
    }
    
    public void deleteContactByName(String name) {
    	    	
    	if(head==null) {
    		System.out.println("The Phonebook is empty can not delete");
    		return;
    	}

    	else {
    		
			if(((Contact)head.data).getName().equalsIgnoreCase(name)) {
    			head = head.next;
    			
    			System.out.println("Contact deleted successfully!");
    			System.out.println();
    			return;
    			
    		}
    		
    		else {
    		Node<T> tmp = head;
    		Node<T> pervious = null;
    		while(tmp != null ) {
    			if(((Contact)tmp.data).getName().equalsIgnoreCase(name)) {
    				pervious.next = tmp.next;
    				tmp = pervious.next;
    				System.out.println("Contact deleted successfully!");
    				System.out.println();
    				return;
    			}
    			pervious = tmp;
    			tmp = tmp.next;
    		      }
		       System.out.println("Not found");
    		}
    	}
    }
    public void deleteContactByPhoneNumber(String phoneNumber) {

    	
    	if(head==null) {
    		System.out.println("The Phonebook is empty can not delete");
    		return;
    	}

    	else {
    		
			if(((Contact)head.data).getName().equalsIgnoreCase(phoneNumber)) {
    			head = head.next;
    			System.out.println("Contact deleted successfully!");
    			System.out.println();
    			return;
    			
    		}
    		
    		else {
    		Node<T> tmp = head;
    		Node<T> pervious = null;
    		while(tmp != null ) {
    			if(((Contact)tmp.data).getName().equalsIgnoreCase(phoneNumber)) {
    				pervious.next = tmp.next;
    				tmp = pervious.next;
    				System.out.println("Contact deleted successfully!");
    				System.out.println();
    				return;
    			}
    			pervious = tmp;
    			tmp = tmp.next;
    		      }
    		    System.out.println("Not found");
    		}
    	}
    }

    public Contact SearchByName(String name) {
    	
    	if(head==null)
    		return null;
    	else {
    		Node<T> tmp = head;
    		while(tmp != null) {
       		    if(((Contact)tmp.data).getName().equals(name)) {
       		    	return (Contact)tmp.data;
       		    }
        		tmp = tmp.next;
    		} 
    		return null;
    	}
    }
    public void SearchByPhoneNumber(String PhoneNumber) {
    	if(head==null)
    		System.out.println("The phonebook is empty");
    	else {
    		Node<T> tmp = head;
    		while(tmp != null) {
       		    if(((Contact)tmp.data).getPhoneNumber().equals(PhoneNumber)) {
       		    	System.out.println("Contact found!");
       		    	((Contact)tmp.data).displayContact();
       		    	return;
       		    }
       		    tmp = tmp.next;
       		    	
    		}System.out.println("Not found!");
    	}
    }
    public void SearchByEmail(String email){
   	 if(head==null)
 		System.out.println("The phonebook is empty");
	 else {
		 boolean found = false;
		 Node<T> tmp = head;
		 while(tmp != null) {
    		 if(((Contact)tmp.data).getEmail().equalsIgnoreCase(email)) {
    			 found = true;
    			 System.out.println("Contact found!");
    			((Contact)tmp.data).displayContact();
    			System.out.println("--------------------------------------");
    		 }
    		    tmp = tmp.next;
    	 } if(found==false)
    		 System.out.println("Not found!");
	 }    	 
}
    public void SearchByAddress(String address){
   	 if(head==null)
 		System.out.println("The phonebook is empty");
	 else {
		 boolean found = false;
		 Node<T> tmp = head;
		 while(tmp != null) {
    		 if(((Contact)tmp.data).getAddress().equalsIgnoreCase(address)) {
    			 found = true;
    			 System.out.println("Contact found!");
    			((Contact)tmp.data).displayContact();
    			System.out.println("--------------------------------------");
    		 }
    		    tmp = tmp.next;
    	 } if(found==false)
    		 System.out.println("Not found!");
	 }    	 
}
    public void SearchByBirthday(String birthday){
    	 if(head==null)
     		System.out.println("The phonebook is empty");
    	 else {
    		 boolean found = false;
    		 Node<T> tmp = head;
    		 while(tmp != null) {
        		 if(((Contact)tmp.data).getBirthday().equalsIgnoreCase(birthday)) {
        			 found = true;
        			 System.out.println("Contact found!");
        			((Contact)tmp.data).displayContact();
        			System.out.println("--------------------------------------");
        		 }
        		    tmp = tmp.next;
        	 } if(found==false)
        		 System.out.println("Not found!");
    	 }    	 
    }
    public void SearchByFirstName(String FirstName) {
    	
        if(head==null) 
		   System.out.println("The phonebook is empty");
         else {
    	
		 boolean found = false;
    	Node<T> tmp = head;
    	while(tmp != null) {
    		
    		String tmpFullName = ((Contact)tmp.data).getName();
    		String tmpFirstName = tmpFullName.substring(0,tmpFullName.indexOf(" ")-1);
    		if(tmpFirstName.equals(FirstName)) {
    			found = true;
   			 System.out.println("Contact found!");
   			 ((Contact)tmp.data).displayContact();
 			 System.out.println("--------------------------------------");
    		   }
    		tmp = tmp.next;
    	    } if(found==false)
   		    System.out.println("Not found!");
         }
    
       

    
    	
    }
    public void printEventsByName(String name) {
    	if(head==null)
     		System.out.println("The phonebook is empty");
    	 else {
    		 boolean found = false;
    		 Node<T> tmp = head;
    		 while(tmp != null) {
        		 if(((Contact)tmp.data).getName().equals(name)) {
        			 found = true;
        			 System.out.println("Contact found!");
        			((Contact)tmp.data).getEventsInContact().displayAllEventsInformation();
        			System.out.println("--------------------------------------");
        		 }
        		    tmp = tmp.next;
        	 } if(found==false)
            	 System.out.println("Contact Not found!");
    	 }    	 
    }
    public void printEventsByTitle(String title) {
    	if(head==null)
     		System.out.println("The phonebook is empty");
    	 else {
    		 boolean found = false;
    		 Node<T> tmp = head;
    		 while(tmp != null) {
        		 if(((Event)tmp.data).getTitle().equals(title)) {
        			 found = true;
        			 System.out.println("Event found!");
        			((Event)tmp.data).getContactsInEvent().displayAllContactsInformation();;
        			System.out.println("--------------------------------------");
        		 }
        		    tmp = tmp.next;
        	 } if(found==false)
            	 System.out.println("Event Not found!");
    	 }    	 
    }
    public boolean isConflict(Contact contact,Event event) {
    	
    		if(head == null)
    			return false;
    		else {
    			Node<T> tmp = head;
    			while(tmp != null) {
    				if(event.getTime().equals(((Event)tmp.data).getTime() ) && event.getDate().equals(((Event)tmp.data).getDate()) )
    					return true;
    			}
    			tmp = tmp.next;
    		}
    		return false;
    }
    public void ScheduleEvent(Contact contact,Event event) {
    	if(contact == null) {
    		System.out.println("You can't Schedule, The contact doesn't exist");
    		return;
    	}
    	if(contact != null && isConflict(contact, event)==false ) {
    		
    		contact.getEventsInContact().addEvent(event);
    		event.getContactsInEvent().addContact(contact);
    		addEvent((T)event);
    		
    		System.out.println("Event scheduled successfully!");
    	}
    	else {
    		if(isConflict(contact, event) == true)
    			System.out.println("Sorry there is conflict!");
    		if(contact == null)
    			System.out.println("Sorry Contact doesn't exist");
    	}
    }
    	
    
    	
    
    
}
