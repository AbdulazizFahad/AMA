import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event> {
	
    
    private String title;
    private Date date;
    private String location;
    private LinkedList<Contact> listOfContactsInEvent;
    private Event next;
    private boolean isEventType; // if true --> Event , if false --> appointment 

	public Event(String title, Date date, String location, boolean isEvent) {
        this.isEventType=isEvent;
        this.title = title;
        this.date = date;
        this.location = location;
        listOfContactsInEvent= new LinkedList();
        next=null;
    }
	public Date getDate() {
			return date;
		}
	public String getLocation() {
		return location;
	}

	public Event getNext() {
			return next;
	}

	public void setNext(Event next) {
			this.next = next;
	}

	public boolean getIsEventType() {
			return isEventType;
	}

	public void setIsEventType(boolean isEventType) {
			this.isEventType = isEventType;
	}

	public LinkedList<Contact> getListOfContactsInEvents() {
			return listOfContactsInEvent;
	}

	public void setListOfContactsInEvents(LinkedList<Contact> ListOfContactsInEvents) {
			this.listOfContactsInEvent = ListOfContactsInEvents;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(Date date) {
			this.date = date;
	}
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public void deleteContact(String name) {
        listOfContactsInEvent.DeleteContact(name);
    }
    @Override
	public int compareTo(Event event) {   
		return this.title.compareTo(event.title); 
    }
    @Override
    public String toString() {
        if(listOfContactsInEvent.isEmpty()) 
            return ""; // Empty 
        String contacts="";
        if(isEventType) { // if ture so isEventType is Event 
        
            listOfContactsInEvent.findFirst();
            while(!listOfContactsInEvent.Last()) {
            
                contacts+=listOfContactsInEvent.retrieve().getName()+", ";
                listOfContactsInEvent.findNext();
            }
            contacts+=listOfContactsInEvent.retrieve().getName()+", ";
        }
        else { // its appointment
        
            listOfContactsInEvent.findFirst();
            contacts+=listOfContactsInEvent.retrieve().getName()+", ";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String f = dateFormat.format(date);
        return "Event title: " + title + "\n" +
               "Contact name: " + contacts + "\n" +
               "Event date and time (MM/DD/YYYY HH:MM): " + f + "\n" +
               "Event location: " + location;
    }
}