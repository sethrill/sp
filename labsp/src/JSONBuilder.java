import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONBuilder implements Builder {

	HashMap<String, Object> _map;
	Element _section;
	
	public JSONBuilder(String filename) {
		File file = new File(filename);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			_map = mapper.readValue(file, HashMap.class);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Element getResult() {
		// result este chiar sectiunea citita si creata
		return _section;
	}

	@Override
	public void build() {
		//citec toata sectiunea din json. _map e dictionaru key-value citit din json
		_section = buildSection(_map);
		
	}

	@Override
	public Element buildSection(HashMap<String, Object> map) {
		String classValue = (String)map.get("class");
		if(classValue.compareTo("Section")==0)
		{
			
			String title = (String)map.get("title");
			Section section = new Section(title);
			
			ArrayList children = (ArrayList)map.get("children");
			for(Object child: children)
			{
				//fiecare copil e tot un dictionar key-value
				HashMap<String, Object> childMap = (HashMap<String, Object>)child;
				Element childElement = null;
				String childClassName = (String)childMap.get("class");
				//decid in functie de class .. ce Element trebuie sa construiesc
				if( childClassName.compareTo("Paragraph")==0)
				{
					childElement = buildParagraph(childMap);
				}
				if( childClassName.compareTo("ImageProxy")==0)
				{
					childElement = this.buildImageProxy(childMap);
				}
				if( childClassName.compareTo("Image")==0)
				{
					childElement = this.buildImage(childMap);
				}
				if( childClassName.compareTo("Table")==0)
				{
					childElement = this.buildTable(childMap);
				}
				if( childClassName.compareTo("Section")==0)
				{
					//daca copilul unei sectiuni este tot o sectiune
					//fac un apel recursiv sa citesc sectiunea
					childElement = this.buildSection(childMap);
				}
				
				if(childElement != null) {
					//daca a fost create child element, il adaug la sectiune
					section.add(childElement);
				}
			}
			
			return section;
		}
		return null;
	}

	@Override
	public Element buildParagraph(HashMap<String, Object> map) {
		
		String text = (String)map.get("text");
		Paragraph paragraph = new Paragraph(text);
		return paragraph;//revin in 2 min
		
	}

	@Override
	public Element buildImage(HashMap<String, Object> map) {
		String url = (String)map.get("url");
		Image image = new Image(url);
		return image;
	}

	@Override
	public Element buildImageProxy(HashMap<String, Object> map) {
		String url = (String)map.get("url");
		ImageProxy imageProxy = new ImageProxy(url);
		return imageProxy;
	}

	@Override
	public Element buildTable(HashMap<String, Object> map) {
		String title = (String)map.get("title");
		Table table = new Table(title);
		return table;
	}

	
	

}
