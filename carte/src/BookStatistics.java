import java.util.HashMap;
import java.util.Map;

public class BookStatistics extends Visitor {

	private int images = 0;
	private int tables = 0;
	private int paragraphs = 0;
	
	Map<String, Integer> elementTypeOccurences = new HashMap<String, Integer>();
	
	@Override
	public void Visit(Element element) {
		
		String elementTypeName = element.getClass().getName();
		if(this.elementTypeOccurences.containsKey(elementTypeName))
		{
			int occurences = this.elementTypeOccurences.get(elementTypeName);
			this.elementTypeOccurences.put(elementTypeName, occurences + 1);
		}
		else
		{
			this.elementTypeOccurences.put(elementTypeName, 1);
		}
	}

	@Override
	public void Visit(Image image) {
		this.images++;

	}

	@Override
	public void Visit(ImageProxy imageProxy) {
		this.images++;
	}

	@Override
	public void Visit(Paragraph paragraph) {
		this.paragraphs++;

	}

	@Override
	public void Visit(Table table) {
		this.tables++;

	}

	public void printStatistics() {
		System.out.println("Book Statistics:"); 
		System.out.println("*** Number of images:"+this.images); 
		System.out.println("*** Number of tables:"+this.tables); 
		System.out.println("*** Number of paragraphs:"+this.paragraphs); 
	}
	
	private void printStatistics2() {
		System.out.println("Book Statistics:");
		int numberOfImages = 0;
		if(this.elementTypeOccurences.containsKey("Image"))
		{
			numberOfImages = elementTypeOccurences.get("Image");
			
		}
		if(this.elementTypeOccurences.containsKey("ImageProxy"))
		{
			numberOfImages += elementTypeOccurences.get("ImageProxy");
			
		}
		if(numberOfImages > 0) {
			System.out.println("*** Number of images:"+numberOfImages);
		}
		
		
		
		if(this.elementTypeOccurences.containsKey("Table"))
		{
			System.out.println("*** Number of tables:"+elementTypeOccurences.get("Table"));
		}
		if(this.elementTypeOccurences.containsKey("Paragraph"))
		{
			System.out.println("*** Number of paragraphs:"+elementTypeOccurences.get("Paragraph"));
		}
		}

}
