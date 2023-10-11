
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
    	Node<T> tmp = head;
    		while(tmp != null) {
    			((Contact)tmp.data).displayContact();
    			tmp = tmp.next;
    			System.out.println("-------------------------------------------------");
    		}
    	
    }
    public boolean isUnique(T x) {
    	Node<T> tmp = head;
    	while(tmp != null) {
    		if(((Contact)x).getPhoneNumber().equalsIgnoreCase(((Contact)tmp.data).getPhoneNumber()) || ((Contact)x).getName().equalsIgnoreCase(((Contact)tmp.data).getName()))
    			return false;
    		tmp=tmp.next;
    	}
		return true;
    }
  /*  public void addContact(T x) {
    
    	if( isUnique(x)==false) {
    		System.out.println("Contact already exists");
    		return;
    	}
    	Node<T> newNode = new Node<T>(x);
    	
    	if(head==null) {
    		head=newNode;
    		current=newNode;
    	}
    }
   */
    
    public boolean deleteContact(String name) {
    	    	
    	if(head==null)
    		return false;
    	else {
    		Node<T> tmp = head;
    		while(tmp != null ) {
    			if(((Contact)tmp.data).getName().equalsIgnoreCase(name))
    			return true;
    			
    			tmp = tmp.next;
    		      }
    		return false;
    	}
    }
    public void SearchByName(String name) {
    	if(head==null)
    		System.out.println();
    	else {
    		Node<T> tmp = head;
    		while(tmp != null) {
       		    if(((Contact)tmp.data).getName().equalsIgnoreCase(name)) {
       		    	System.out.println("Contact found!");
       		    	((Contact)tmp.data).displayContact();
       		    	return;
       		    }
       		    tmp = tmp.next;
       		    	
    		}System.out.println("Not found!");
    	}
    }
   public void SearchByPhoneNumber(String PhoneNumber) {
    	if(head==null)
    		System.out.println();
    	else {
    		Node<T> tmp = head;
    		while(tmp != null) {
       		    if(((Contact)tmp.data).getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
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
		 System.out.println("Not found!");
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
		 System.out.println("Not found!");
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
    		 System.out.println("Not found!");
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
    
}
