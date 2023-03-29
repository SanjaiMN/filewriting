import java.io.File;

public class DirectoryCheck 
{

	public static void main(String[] args) 
	{
		File[] drives = File.listRoots();
		int count=0;
        for (File drive : drives) 
        {
            if(drive.getName().equals("S:\\"))
            {
            	count++;
            }
        }
		if(count==1)
		{
			//paste the file
		}
	}

}
