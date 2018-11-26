import java.util.ArrayList;
import java.util.List;

public class SubChapter {
	private String name;
	private List<Paragraph> paragraphs = new ArrayList<Paragraph>();
	private List<Table> tables = new ArrayList<Table>();
	private List<Image> images = new ArrayList<Image>();

	public SubChapter(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addParagraph(Paragraph paragraph) {
		this.paragraphs.add(paragraph);
	}
	
	public void createNewParagraph(String paragraphText) {
		this.paragraphs.add(new Paragraph(paragraphText));
	}
	
	public void createNewTable(String tableTitle) {
		this.tables.add(new Table(tableTitle));
	}
	
	public void createNewImage(String imageName) {
		this.images.add(new Image(imageName));
	}

	public Paragraph[] getParagraphs() {
		return (Paragraph[])this.paragraphs.toArray(new Paragraph[0]);
	}
	
	public void addTable(Table table) {
		this.tables.add(table);
	}

	public Table[] getTables() {
		return (Table[])this.tables.toArray(new Table[0]);
	}
	
	public void addImage(Image image) {
		this.images.add(image);
	}

	public Image[] getImages() {
		return (Image[])this.images.toArray(new Image[0]);
	}

	public void print() {
		System.out.println("Subchapter: " + this.getName());
		for(Paragraph paragraph: this.paragraphs) {
			paragraph.print();
		}
		for(Image image: this.images) {
			image.print();
		}
		for(Table table: this.tables) {
			table.print();
		}
	}

	
	
	
}
