
package json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import singleton.model.Book;

public class JSONReader {
  public static void main(final String[] args) throws JsonParseException, JsonMappingException, IOException {
    singleton.model.Book book = new Book("Carte 1");

    final ObjectMapper mapper = new ObjectMapper();
    final HashMap<String, Object> readValue = mapper.readValue(new File("book.json"), HashMap.class);
    for (Object value : readValue.values()) {
      System.out.println("value = " + value);
    }
    System.out.println("read value = " + readValue);
    //Then some code that uses the readValue.
    //Keep in mind that the mapper.readValue() method does throw some exceptions
    //So you'll need to handle those too.    
  }
}
