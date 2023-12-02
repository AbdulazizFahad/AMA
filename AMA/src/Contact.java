
 public class Contact implements Comparable<Contact> {

    private String name;
    private String phoneNumber;
    private String email;
    private String address;    
    private String birthday;
    private String notes;
    private LinkedList<Event> listOfEventsInContact = new LinkedList<Event>(); 

    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;            
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LinkedList<Event> getEvents() {
        return listOfEventsInContact;
    }

    public void setEvents(LinkedList<Event> events) {
        this.listOfEventsInContact = events;
    }
    public void addEvent(Event event) {
        this.listOfEventsInContact.add(event);
    }
    public void displayContactInfo() {
        System.out.println("Name: " + name);
        System.out.println("Phonenumber: " + phoneNumber);
        System.out.println("Email: " + email);             
        System.out.println("Address: " + address);
        System.out.println("Birthday: " + birthday);
        System.out.println("Notes: " + notes);
    }
    
    public void displayEventInfo() {
        if(listOfEventsInContact.isEmpty()) {
             System.out.println("There are no events or appointment for this contact");
             return;
        }
        listOfEventsInContact.findFirst();
        while(!listOfEventsInContact.Last()) {
            System.out.println(listOfEventsInContact.retrieve());
            System.out.println("");
            listOfEventsInContact.findNext();
        }
         System.out.println(listOfEventsInContact.retrieve());
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Name: ").append(name).append("\n");
        string.append("PhoneNumber: ").append(phoneNumber).append("\n");
        string.append("Email: ").append(email).append("\n");
        string.append("Address: ").append(address).append("\n");
        string.append("Birthday: ").append(birthday).append("\n");
        string.append("Notes: ").append(notes).append("\n\n");
        return string.toString();
    }
    @Override
    public int compareTo(Contact c) {     
        return this.name.compareTo(c.name);
    }
}