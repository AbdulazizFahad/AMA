
public class Event implements Comparable<String> {
	
	private String title;
	private String date;
	private String time;
	private String location;
	private LinkedList<Contact> contactsInEvent = new LinkedList<Contact>();

	public Event(String title, String date, String time, String location) {
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public LinkedList<Contact> getContactsInEvent() {
		return contactsInEvent;
	}

	public void setContactsInEvent(LinkedList<Contact> contactsInEvent) {
		this.contactsInEvent = contactsInEvent;
	}
	public void displayEvent() {
		System.out.println("Event Title: "+title);
		System.out.println("Event Date: "+date);
		System.out.println("Event Time: "+time);
		System.out.println("Event Location: "+location);

	}

	@Override
	public int compareTo(String title) { // Same process in compareTo in Contact 
		return this.title.compareTo(title);
	} 
	
	

	
	
}
