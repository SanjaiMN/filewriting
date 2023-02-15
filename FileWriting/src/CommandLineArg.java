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
		System.out.println("username" + map.get("username")+"and password="+map.get("password"));
		
//		String name = System.getProperties().getProperty("stack");
		System.out.println("VM options: " + map);
       
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
