
package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MainClass {
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    JSONBuilder jsonBuilder = new JSONBuilder("book.json");
    jsonBuilder.build();

    singleton.model.Element myBook = jsonBuilder.getResult();
    myBook.print();
  }
}
