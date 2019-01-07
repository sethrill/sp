import java.util.concurrent.TimeUnit;

public class Image extends Element {
	private String imageName;

	public Image(String imageName) {
		this.imageName= imageName;
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public void print() {
		System.out.println("Image with name: " + this.imageName);
	}
	
	
	
}
