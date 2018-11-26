
public class ImageProxy extends Element{

	private String imageName;
	private Image realImage = null;
	
	public ImageProxy(String imageName) {
		this.imageName = imageName;
	}
	
	public void print() {
		
		if(realImage == null)
		{
			
			realImage = new Image(this.imageName);
		}
		realImage.print();
	}
}
