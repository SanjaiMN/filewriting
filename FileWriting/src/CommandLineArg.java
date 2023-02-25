import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ManagementFactory;

public class CommandLineArg 
{
	public static void main(String[] args) 
	{
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		List<String> vmOptions = runtimeMXBean.getInputArguments();
		
		Map<String,String> map = listtomap(vmOptions);
		
//		String name = System.getProperties().getProperty("stack");
		String username = null,password = null;
		try 
		{
			/*if you want username inside the program.you can just call map.get("username");
			this key should be same to which passed in VM arguments
			(-Dusername=sanjai,-Dpassword=sanjai if you gave -Duser=sanjai then use map.get("user");*/
			username=map.get("username");
			password=map.get("password");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
       System.out.println(username+" "+password);
    }
	public static Map<String,String> listtomap(List<String> list) 
	{
        Map<String, String> map = new HashMap<>();
        String delimiter = "=";

        for (String item : list) 
        {
            String[] keyValue = item.split(delimiter);
            map.put(keyValue[0].substring(2), keyValue[1]);
        }

        return map;
    }
}
