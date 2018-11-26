import java.util.ArrayList;
import java.util.List;

public class Chapter {
	private String name;
	private List<SubChapter> subChapters = new ArrayList<SubChapter>();

	
	
	public Chapter(String name) {
		this.name = name;
	}
	
	public SubChapter[] getSubChapters() {
		return (SubChapter[])subChapters.toArray(new SubChapter[0]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void AddSubChapter(SubChapter subChapter) {
		this.subChapters.add(subChapter);
	}
	
	public int createSubChapter(String subChapterName) {
		this.subChapters.add(new SubChapter(subChapterName));
		return this.subChapters.size()-1;
	}
	
	public SubChapter getSubChapter(int indexOfSubChapter) {
		return this.subChapters.get(indexOfSubChapter);
	}
	
	public void print() {
		System.out.println("Chapter: " + this.name);
		for(SubChapter subchapter: this.subChapters) {
			subchapter.print();
		}
	}
}
