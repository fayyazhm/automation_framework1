package fayyaz.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.JsonMappingException;

public class dataReader {
	
	
	public List<HashMap<String,String>> getJsonToHashMap() throws IOException {
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\fayyaz\\data\\purchaseorder.json"));
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
