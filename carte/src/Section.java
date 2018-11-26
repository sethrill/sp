import java.util.ArrayList;
import java.util.List;


public class Section extends Element {

	private List<Element> elements = new ArrayList<Element>();
	private String name;
	
	public Section(String name) {
		this.name = name;
	}
	
	public int add(Element element) {
		this.elements.add(element);
		return this.elements.size()-1;
	}
	
	public void remove(Element element) {
		this.elements.remove(element);
	}
	
	public Element getChild(int index) {
		return this.elements.get(index);
	}
	
	public void print() {
		System.out.println("Section: " + this.name);
		for(Element child: this.elements) {
			child.print();
		}
	}
	
	public void Accept(Visitor visitor) {
		for(Element child: this.elements) {
			
			if (child instanceof Image)
			{
				visitor.Visit((Image)child);//this call Visit(Image image)
			}
			else if (child instanceof ImageProxy)
			{
				visitor.Visit((ImageProxy)child);//this call Visit(ImageProxy imageProxy)
			}
			else if (child instanceof Paragraph)
			{
				visitor.Visit((Paragraph)child);//this call Visit(Paragraph paragraph)
			}
			else if (child instanceof Table)
			{
				visitor.Visit((Table)child);//this call Visit(Table table)
			}
			
			
		}
	}
}
