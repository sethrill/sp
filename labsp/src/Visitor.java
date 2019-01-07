
public abstract class Visitor {
	public abstract void Visit(Element element);
	
	public abstract void Visit(Image image);
	public abstract void Visit(ImageProxy imageProxy);
	public abstract void Visit(Paragraph paragraph);
	public abstract void Visit(Table table);
}
