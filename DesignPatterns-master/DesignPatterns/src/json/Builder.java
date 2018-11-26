
package json;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import singleton.model.Element;

public interface Builder {

  Element getResult();

  void build() throws JsonParseException, JsonMappingException, IOException;

  Element buildImage(HashMap<String, Object> map);

  Element buildParagraph(HashMap<String, Object> map);

  Element buildTable(HashMap<String, Object> map);

  Element buildImageProxy(HashMap<String, Object> map);

  Element buildSection(HashMap<String, Object> map);

}
