
public class Event implements Comparable<String> {
	
	private String title;
	private String date;
	private String time;
	private String location;
	public LinkedList<Contact> contactsInEvent = new LinkedList<Contact>();
	
	public Event(String title, String date, String time, String location) {
		super();
		title = title;
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
	public void displayEvent() {
		System.out.println("Event title: "+title);
		System.out.println("Event title: "+date);
		System.out.println("Event title: "+time);
		System.out.println("Event title: "+location);

	}

	@Override
	public int compareTo(String Etitle) { // Same process in compareTo in Contact 
		return this.title.compareTo(title);
	} 
	
	

	
	
}
