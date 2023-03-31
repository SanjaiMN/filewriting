
import java.io.*;

public class PropertyChanger 
{
	 public static void main(String[] args) throws IOException 
	 {
		 String filePath = "_config.properties";
	        String keyToModify = "password";
	        String newValue = "Sanjai2019";
	        
	        File inputFile = new File(filePath);
	        File tempFile = new File("temp.properties");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String line;
	        while ((line = reader.readLine()) != null) 
	        {
	        	if(line.length()!=0 && line.charAt(0)!='#') 
	        	{
		            String[] parts = line.split("=");
		            if (parts.length >= 2 && parts[0].equals(keyToModify)) {
		                // Modify the value of the key
		                writer.write(keyToModify + "=" + newValue + "\n");
		            } 
		            else {
		                // Keep the line as-is
		                writer.write(line + "\n");
		            }
	        	}
	        	else {
	                // Keep the line as-is
	                writer.write(line + "\n");
	            }
	        }
	        reader.close();
	        writer.close();

	        // Replace the original file with the modified file
	        inputFile.delete();
	        tempFile.renameTo(inputFile);
	 }
	
}
