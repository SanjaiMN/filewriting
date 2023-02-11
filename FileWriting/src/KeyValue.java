import java.io.*;
import java.util.*;
public class KeyValue 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(System.in);
		//getting input
		System.out.println("Type a key value pair to append");
		String input = in.nextLine();
		//creating a file object
		File file=new File("src\\filename.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		//appending it into a file
		FileWriter fi = new FileWriter(file,true);
		//\n is for new line
		fi.write(input+"\n");
		fi.close();
	}
	
}
