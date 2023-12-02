class LinkedNode<T extends Comparable> {
	
	public T data;
	public LinkedNode<T> next;
	
	public LinkedNode(T data) {
		
		this.data = data;
		next=null;
	}
}

public class LinkedList<T extends Comparable> {

	private LinkedNode<T> head;
    private LinkedNode<T> current;

	public LinkedList() {
		
		head = null;
		current = null;
	}
	
	public boolean Full() {    
	
		return false;
	}
	
	public boolean isEmpty() {  
        return head == null;
    }

    public boolean Last() {  
        return current.next == null;
    }
    public T retrieve()    {   
        return current.data;
    }

    public void update(T x) {
        current.data = x;
    }
    public void findFirst() {   
        current = head;
    }
//
    public void findNext() {    
        current = current.next;
    }
    public boolean DeleteContact(String name) {
    	
        LinkedNode<Contact> tmp = (LinkedNode<Contact>) head; // Casting the head 
        LinkedNode<Contact> previous = (LinkedNode<Contact>) head; // Casting the head
        while(tmp != null) {
            if(tmp.data.getName().equals(name)) { // if there is same name founded then delete the contact 
                if (tmp == head)
                    head = head.next;
                else {
                    previous.next = tmp.next;
                }
                return true;
            }
            previous = tmp;
            tmp=tmp.next;
        }
        return false;  //Contact has not been found
    }
    
    public void add(T c) {//add alphabetically
    	
        if (head == null) //check if list is empty
            head = new LinkedNode(c);
        else {
        	
            LinkedNode newNode = new LinkedNode(c);
            LinkedNode tmp = head;
            LinkedNode previous = head;
            
            while(tmp != null) {
                if (tmp.data.compareTo(c) > 0) {   
                    if (tmp == head) {
                        newNode.next= head;
                        head=newNode;
                    }
                    else{
                        previous.next =newNode;
                        newNode.next = tmp;
                    }
                    return;
                }
                previous = tmp;
                tmp= tmp.next;
            }
            previous.next = newNode;
        }
    }
}