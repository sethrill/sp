import java.util.ArrayList;
import java.util.List;


public class Book {
	private String title;
	private TableOfContents tableOfContents = new TableOfContents("");
	private List<Element> elements = new ArrayList<Element>();
	private List<Author> authors = new ArrayList<Author>();
	

	public Book(String title) {
		this.title = title;
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	
	public void addContent(Element element) {
		this.elements.add(element);
	}
	
	
	public TableOfContents getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(TableOfContents tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	public void print() {
		
		System.out.println("Book: " + this.title);
		for(Author author: this.authors) {
			author.print();
		}
		this.tableOfContents.print();
		for(Element element: this.elements) {
			element.print();
		}
	}
	
	public void Accept(Visitor visitor) {
		for(Element element: this.elements) {
			visitor.Visit(element);
		}
	}
	
}
