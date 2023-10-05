
class Node<T> {
	
	public T data;
	public Node next;
	
	public Node(T d) {
		data=d;
		next=null;
	}
}
public class LinkedList<T> {
	
	Node<T> head;
	Node<T> current;
	
	public boolean isFull() {      // Check if the LinkedList is full (We know it's never FULL :) )
		return false;
	}
	
	public boolean isEmpty() {     //Checking if the list is empty

        return head == null;
    }

    public boolean isLast() {  //Checking if the node is the last one

        return current.next == null;
    }
    public void findFirst() { // making the current point on the first node

        current = head;
    }

    public void findNext() { // move the current to the next node

        current = current.next;
    }

    public T retrieve() {  // obtain the current node

        return current.data;
    }

    public void update(T val) { // updating the node

        current.data = val;
    }

    public void insert(T val) { // inserting nodes

        Node<T> tmp;

        if (isEmpty())
             head=current=new Node<T>(val);
        else {

            tmp = current.next;
            current.next = new Node <T> (val);
            current = current.next;
            current.next = tmp;
        }
    }

    public void remove() { // removing the current node

        if (current == head)
            head = null;

            else {

                Node <T> tmp = head;

                while(tmp.next != current)
                    tmp = tmp.next;

                    tmp.next = current.next;
            }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }


}
