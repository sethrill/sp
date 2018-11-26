
public class Paragraph extends Element  {
	private String text;
	private AlignStrategy strategy;

	public Paragraph(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void print() {
		if(this.strategy != null)
		{
			this.strategy.print(this.text);//strategia de aliniere va sti cum sa printeze textu aliniat
		}
		else
		{
			//daca nu avem nici o strategie de aliniere setata, printam textu "normal" cum era pana acum
			System.out.println("Paragraph: " + this.text);
		}
	}
	
	public void setAlignStrategy(AlignStrategy strategy) {
		
		
		this.strategy = strategy;
		
	}
}
