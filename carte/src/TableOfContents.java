
public class TableOfContents {

	private String text;
	
	public TableOfContents(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void print() {
		System.out.println("Table of Contents: " + this.text);
	}
}
