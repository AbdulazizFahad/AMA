class BSTNode<T> {
	
    public Contact data;
    public BSTNode<T> left, right;

    public BSTNode(Contact data) {

        this.data = data;
        left = right = null;
    }
}
public class ContactBST<Y extends Comparable<Y> > {
	
    public BSTNode<Y> root;
    int size;

    ContactBST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean full() {
        return false;
    }

    public void clear() {
        root = null;
        size = 0;
    }
    public void insert(Contact c) {// It adds a new  Contact into the tree with order based on the contact's name If the tree is empty, it make the new node the root else it traverses in the tree to find the suitable position.
        if (root == null) {
            root = new BSTNode(c);
            size++;
            return;
        }
        BSTNode<Y> p = root;
        BSTNode<Y> q = root;
        
        while (p != null) {
            q = p;
            if (p.data.getName().compareTo(c.getName()) > 0) 
                p = p.left;
            else 
                p = p.right;
            

        }
        if (q.data.getName().compareTo(c.getName()) > 0) {
            q.left = new BSTNode(c);
        } else {
            q.right = new BSTNode(c);
        }
        size++;
    }
    public boolean isExistName(String name) { // name existence  if we have contact with the same name before
        BSTNode<Y> p = root;
        while (p != null) {
            if (p.data.getName().compareTo(name) == 0) 
                return true;
            else if (p.data.getName().compareTo(name) > 0) 
                p = p.left;
            else
                p = p.right;
        }
        return false;
    }
    public boolean isExistPhone(String phone) { //phone existence we have contact with same phone before
        return isInOrder(root, phone);
    }
    private boolean isInOrder(BSTNode root , String phone) {
        if (root == null) 
            return false;
        
        boolean isOrderd = isInOrder(root.left , phone); //  left child
        if (root.data.getPhoneNumber().equals(phone)) { 
            return true;
        }
        return isOrderd || isInOrder(root.right, phone); //  right child
    }
    public Contact ContactByName(String name) { //    return a contact by name from a binary tree.  It returns the contact if found otherwise return null.
        BSTNode<Y> p = root;
        while (p != null) {
            if (p.data.getName().compareTo(name) == 0) 
                    return p.data;
            else if (p.data.getName().compareTo(name) > 0) 
                p = p.left;
            else 
                p = p.right;
        }
        return null;
    }
    public Contact SearchByName(String name) {// this method will search for a contact by name. If it has been found displays the contact information and returns the contact,  otherwise it display a No contact found and return null
        
        BSTNode<Y> p = root;
        while (p != null) {
            if(p.data.getName().compareTo(name) == 0) {
                    System.out.println("Contact found!");
                    System.out.println(p.data);
                    return p.data;
            } 
            else if (p.data.getName().compareTo(name) > 0) 
                p = p.left;
             else 
                p = p.right;
        }
        System.out.println("No contact found!");
        return null;
    }
    public void SearchByPhone(String phone) { // this method will search for a contact by name. If it has been found displays the contact information ,otherwise it display a "No contact found!" message 
        Contact con = SearchByPhone(root, phone);
        if (con != null) {
            System.out.println("Contact found!");
            System.out.println(con);
        } 
        else 
            System.out.println("No contact found!");
    }
    private Contact SearchByPhone(BSTNode<Y> root, String phone) { //Search for a contact by phone number in a binary tree. if the Conatct has been found it returns the contact , if the phone number is not found it returns null in the tree  The method search  by checking the left and right children if found a matching phone numbers.
        
        if (root == null) 
            return null;
        
        Contact con = SearchByPhone(root.left, phone);  // left child
        if (con != null) 
            return con;
        if (root.data.getPhoneNumber().equals(phone)) {
            return root.data;
        }
        return SearchByPhone(root.right, phone);  // right child
    }
    
    private boolean SearchByEmail(BSTNode<Y> root, String email) { //  if a contact with a provided email exists in a binary tree.  It returns true if founded and prints the contact information  and put found to true. otherwise returns false. The method search in the tree check the left and right children until a matching email. result there is three cases: the result from the left child, the current node and the result from the right child.
        
        if (root == null) 
            return false;
        
        boolean firstFlag = SearchByEmail(root.left, email); //  left child
        boolean secondFlag = false;
        if (root.data.getEmail().equals(email)) {
            System.out.println(root.data);
            secondFlag = true;
        }
        boolean thirdFlag = SearchByEmail(root.right, email); // right child
        return firstFlag || secondFlag || thirdFlag;
    }
    public void SearchByEmail(String email) {
        boolean found = SearchByEmail(root, email);
        if (!found) {
            System.out.println("No contacts found!");
        }
    }
    private boolean SearchByAddress(BSTNode<Y> root, String address) { //  if a contact with a provided address exists in a binary tree.  It returns true if founded and prints the contact information  and put found to true. otherwise returns false. The method search in the tree check the left and right children until a matching Address result, there is three cases: the result from the left child, the current node and the result from the right child.
        if (root == null) 
            return false;
        
        boolean firstFlag = SearchByAddress(root.left, address);   // First  on left child
        boolean secondFlag = false;
        if (root.data.getAddress().equals(address)) {
            System.out.println(root.data);
            secondFlag = true;
        }
        boolean thirdFlag = SearchByAddress(root.right, address);; //  right child
        return firstFlag || secondFlag || thirdFlag;
    }
    public void SearchByAddress(String address) {
        boolean found = SearchByAddress(root, address);
        if (!found) 
            System.out.println("No contacts found!");
    }
    private boolean SearchByBirth(BSTNode<Y> root, String birthday) {//  if a contact with a provided birth exists in a binary tree.  It returns true if founded and prints the contact information  and put found to true. otherwise returns false. The method search in the tree check the left and right children until a matching birth result, there is three cases: the result from the left child, the current node, and the result from the right child.
        if (root == null) 
            return false;
        boolean firstFlag = SearchByBirth(root.left, birthday);// First on left child
        boolean secondFlag = false;
        if (root.data.getBirthday().equals(birthday)) {
            System.out.println(root.data);
            secondFlag = true;
        }
        boolean thirdFlag = SearchByBirth(root.right, birthday);; // right child
        return firstFlag || secondFlag || thirdFlag;
    }
    public void SearchByBirth(String birthday) {
        boolean found = SearchByBirth(root, birthday);
        if (!found) 
            System.out.println("No contacts found!");
    }
    private boolean SerachByFirstName(BSTNode<Y> root, String firstName) { // if a contact with a provided first name exists in a binary tree. It returns true if found, prints the contact information,  make found to true. If not found, it returns false. The method search the tree in check the left and right children until a matching first name is found.  The final result is a logical OR of three conditions: the result from the left child, the current node, and the result from the right child.
        if (root == null) 
            return false;
        boolean firstFlag = SerachByFirstName(root.left, firstName);//  left child
        boolean secondFlag = false;
        String first = root.data.getName().split(" ")[0];
        if (first.equals(firstName)) {
            System.out.println(root.data);
            secondFlag = true;
        }
       
        boolean thirdFlag = SerachByFirstName(root.right, firstName); // right child
        return firstFlag || secondFlag || thirdFlag;
    }
    public void SerachByFirstName(String firstName) {
        boolean found = SerachByFirstName(root, firstName);
        if (!found) 
            System.out.println("No contacts found!");
    }
    public void delete(String name) {
        BSTNode<Y> p = root; // Starting from the root of the Binary Search Tree (BST)
        BSTNode<Y> q = null; // q will keep track of the parent node

        // Loop through the BST nodes until p becomes null
        while (p != null) {
            if (name.compareTo(p.data.getName()) >= 0) {// Check if the name to be deleted is greater than or equal to the current node's name
                if (name.compareTo(p.data.getName()) <= 0) { // If the name is found in the current node
                    if ((p.left != null) && (p.right != null)) { // If the current node has both left and right children
                        BSTNode<Y> min = p.right; // Find the minimum node in the right subtree of the current node
                        q = p;                    // Set q as the current node
                        while (min.left != null) {
                            q = min;              // Update q as the parent of the minimum node
                            min = min.left;       // go left to find the minimum node
                        }
                                                  // Replace the current node's data with the minimum node's data
                        p.data = min.data;
                        name = min.data.getName(); // Update the name to be deleted
                        p = min; // Set the current node as the minimum node
                    }
                    if (p.left == null)
                        p = p.right; // Replace the node with its right child
                    else
                        p = p.left; // Replace the node with its left child

                                    // Update the parent node's 
                    if (q != null) {
                        if (name.compareTo(q.data.getName()) >= 0)
                            q.right = p; // Update the right child of the parent node
                        else
                            q.left = p; // Update the left child of the parent node
                    } else
                        root = p; // Update the root if the deleted node was the root
                    size--; // Decrement the size of the BST
                } else {
                    // Move to the right child if the name is greater than the current node's name
                    q = p;
                    p = p.right;
                }
            } else {
                // Move to the left child if the name is smaller than the current node's name
                q = p;
                p = p.left;
            }
        }
    }
    public void AddEvent(Event e, String name) { //  this method is to add  event  to the contact with a provided name in a binary tree It search in the tree to find the contact by name and add it to the event to that contact list of events.
        BSTNode<Y> p = root;
        while (p != null) {
            if (p.data.getName().compareTo(name) == 0) {
                    p.data.addEvent(e);
                    return;
            } 
            else if (p.data.getName().compareTo(name) > 0) 
                p = p.left;
            else 
                p = p.right;
        }
    }
    public void printEventsWithContactName(String name) { // prints events by contact by name in a binary tree. If the contact is found, it displays the events; otherwise, it prints "No contact found!".
        BSTNode<Y> p = root;
        while (p != null) {
            if (p.data.getName().compareTo(name) == 0) {
                
                    p.data.displayEventInfo();
                    return;
                
            } else if (p.data.getName().compareTo(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }

        }
        System.out.println("No contact found!");
    }
    private void display(BSTNode<Y> root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.println(root.data);
        System.out.println("");
        display(root.right);
    }
    public void printAllContacts() { // Print all contacts
    	if(root==null) {
    		System.out.println();
    		System.out.println("The phonebook is empty");
    	    System.out.println();
    	}
        display(root);
    }
}