
public class Table extends Element  {
	private String title;

	public Table(String title) {
		this.title =  title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void print() {
		System.out.println("Table with Title: " + this.title);
	}
}
