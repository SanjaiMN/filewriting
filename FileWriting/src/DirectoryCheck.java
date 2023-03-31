import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryCheck {

    public static void main(String[] args) throws IOException 
    {
    	Path directorycheck = Paths.get("S:\\STB_VIDEOS");
        
        if (Files.exists(directorycheck) && Files.isDirectory(directorycheck)) 
        {
        	//paste the file
        	System.out.println("exists");
        } 
        else 
        {
        	System.out.println("not exist");
            // directory does not exist
        }
    }
    
}
