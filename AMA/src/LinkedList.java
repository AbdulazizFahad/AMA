
class Node<T> {
	
	public T data;
	public Node<T> next;
	
	public Node(T d) {
		
		data=d;
		next=null;
	}
}
public class LinkedList<T> {
	
	private Node<T> head;
	private Node<T> current;
	
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

    public T retrieve() {  // obtain the current node data 

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
    public void Add(T x) {
    	
    	
    }
    public boolean Search(T x) {
    	Node<T> tmp = head;
    	while(tmp!=null) {
    		if( ( (Contact)x).getPhoneNumber().equals( ((Contact)tmp.data).getPhoneNumber()  )  )
    			return true;
    		tmp=tmp.next;
    	}
		return false;
    }
   

    
    


}
