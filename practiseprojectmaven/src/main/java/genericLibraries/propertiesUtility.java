package genericLibraries;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility  {
	
	
	
	
	Properties property;
	
	public void propertiesInit(String filepath) {
		
		
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		    }
		
		catch(Exception e) {
				e.printStackTrace();
			}
		
		property=new Properties();
			
		try {
				property.load(fis);
			}
			
		catch(Exception e) {
				e.printStackTrace();
			}
		}

	
	public String readDataFromProperties(String key) {
		
	return	property.getProperty(key);
	}
	
	
	/** this method is used to write data to properties file
	 * 
	 * @param key
	 * @param value
	 * @param filepath
	 * @param comments
	 */
	
	
	public void writeToProreties(String key,String value,String filepath,String comments) {
		property.put(key,value);
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(filepath);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		try {
			property.store(fos,comments);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
