
class Node<T> {
	
	T data;
	Node next;
}



public class LinkedList<T> {
	
	Node<T> head;
	Node<T> current;
	
public boolean isempty() {     //Checking if the list is empty
		
		return head == null;
	}
	
	public boolean islast() {  //Checking if the node is the last one
		
		return current.next == null;
	}
	public void findfirst() { // making the current point on the first node
		
		current = head;
	}
	
	public void findnext() { // move the current to the next node
		
		current = current.next;
	}
	
	public T retrieve () {  // obtain the current node
		
		return current.data;
	}
	
	public void update (T val) { // updating the node
		
		current.data = val;
	}
	
    public void insert (T val) { // inserting nodes
		
		Node<T> tmp;
		
		if (isempty())
			head = current = newNode <T> (val);
		
		else {
			
			tmp = current.next;
			current.next = newNode<T> (val)
			current = current.next;
			current.next = tmp;
		}
	}
	 
    public void remove() { // removing the current node
    	
    	if (current == head)
    		head = null
    		
    		else {
    			
    			Node <T> tmp = head;
    			
    			while(tmp.next != current)
    				tmp = tmp.next
    				
    				tmp.next = current.next;
    		}
    	if (current.next == null)
    		current = head;
    	else
    		current = current.next;
    }

}
