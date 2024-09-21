package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class FileInput {

	@Test
	public String fileinputMethod(String string) throws IOException {
	FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
	
	Properties p = new Properties();
	p.load(fis);
	
	return p.getProperty(string);
	
}
}