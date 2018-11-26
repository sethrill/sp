import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class main {
	
	public static void mainLab4() {
		//merge adaugat codul ala?
				
				long startTime = System.currentTimeMillis();
				ImageProxy img1 = new ImageProxy("Pamela Anderson");
				ImageProxy img2 = new ImageProxy("Kim Kardashian");
				ImageProxy img3 = new ImageProxy("Kirby Griffin");
				Section playboyS1 = new Section("Front Cover");
				playboyS1.add(img1);
				Section playboyS2 = new Section("Summer Girls");
				playboyS2.add(img2);
				playboyS2.add(img3);
				Book playboy = new Book("Playboy");
				playboy.addContent(playboyS1);
				playboy.addContent(playboyS2);
				long endTime = System.currentTimeMillis();
				System.out.println("Creation of the content took " + (endTime - startTime) + " milliseconds");
				
				startTime = System.currentTimeMillis();
				playboyS1.print();
				endTime = System.currentTimeMillis();
				
				System.out.println("Printing of the section 1 took " + (endTime - startTime) + " milliseconds");
					
				startTime = System.currentTimeMillis();
				playboyS1.print();
				endTime = System.currentTimeMillis();
				
				System.out.println("Printing again the section 1 took " + (endTime - startTime) + " milliseconds");


				
				
	}
	
	public static void main_Lab5()
	{
		Section cap1 = new Section("Capitolul 1");
		Paragraph p1 = new Paragraph("Paragraph 1");
		cap1.add(p1);
		Paragraph p2 = new Paragraph("Paragraph 2");
		cap1.add(p2);
		Paragraph p3 = new Paragraph("Paragraph 3");
		cap1.add(p3);
		Paragraph p4 = new Paragraph("Paragraph 4");
		cap1.add(p4);
			
		System.out.println("Printing without Alignment");

		System.out.println();
		cap1.print();
			
		p1.setAlignStrategy(new AlignCenter());
		p2.setAlignStrategy(new AlignRight());
		p3.setAlignStrategy(new AlignLeft());
			
		System.out.println();
		System.out.println("Printing with Alignment");
		System.out.println();
		cap1.print();

		
	}
	
	public static void main_lab6()
	{
		Section cap1 = new Section("Capitolul 1");
		Paragraph p1 = new Paragraph("Paragraph 1");
		cap1.add(p1);
		Paragraph p2 = new Paragraph("Paragraph 2");
		cap1.add(p2);
		Paragraph p3 = new Paragraph("Paragraph 3");
		cap1.add(p3);
		Paragraph p4 = new Paragraph("Paragraph 4");
		cap1.add(p4);
		cap1.add(new ImageProxy("ImageOne"));
		cap1.add(new Image("ImageTwo"));
		cap1.add(new Paragraph("Some text"));
		cap1.add(new Table("Table 1"));
			
		BookStatistics stats = new BookStatistics();
		cap1.Accept(stats);
		stats.printStatistics();
		
		
		// Element[] bookElements = book.GetElements();
		
		//for(Element bookElement: bookElements)
		//{ bookElement.Accept(visitor); }
		// visitor-ul visita fiecare element al cartii . si strangea ce statistica avea de gand
		
		
		
		
		
	}

	public static void main(String[] args) {
		String filename = "C:\\Users\\Alex\\Desktop\\java\\carte\\book.json";
		Builder jsonBuilder = new JSONBuilder(filename);
		jsonBuilder.build();//abstractizata constructia elementelor
		Element myBook = jsonBuilder.getResult();
		myBook.print();
		
		
		
		
	}

}
 
