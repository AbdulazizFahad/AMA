
public class Event implements Comparable<String> {
	
	private String title;
	private String date;
	private String time;
	private String location;
	private Contact contact;

	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
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
	public void displayEvent() {
		System.out.println("Event Title: "+title);
		System.out.println("Event Date(MM/DD/YYYY): "+date);
		System.out.println("Event Time(HH:MM): "+time);
		System.out.println("Event Location: "+location);

	}

	@Override
	public int compareTo(String title) { // Same process in compareTo in Contact 
		return this.title.compareTo(title);
	} 	
}
