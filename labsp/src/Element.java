import java.util.ArrayList;
import java.util.List;

public class Element {

	private List<Element> children = new ArrayList<Element>(); 
	
	public int add(Element element) {
		this.children.add(element);
		return this.children.size()-1;
	}
	
	public void remove(Element element) {
		this.children.remove(element);
	}
	
	public Element getChild(int index) {
		return this.children.get(index);
	}
	
	public void print() {
		for(Element child: this.children) {
			child.print();
		}
	}
	
	/
	public void Accept(Visitor visitor) {
		
		for(Element child: this.children) {
			visitor.Visit(child); 
		}
	}
}
