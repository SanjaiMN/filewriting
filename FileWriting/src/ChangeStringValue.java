
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.*;

public class ChangeStringValue 
{

    public static void main(String[] args) throws Exception 
    {
        String input = "src\\obligationBridge_stage_Add.json";

        JsonObject json = null;
        try
        {
            String jsonStr = new String(Files.readAllBytes(Paths.get(input)));
            JsonElement jsonElement = new JsonParser().parse(jsonStr);
            json = jsonElement.getAsJsonObject();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        // Modify the deviceCloudId value in the JsonObject
        //json.addProperty("resourceId", "6257729bd4b3214e8b127e17sanjai");
        JsonObject eventAttributeValueMap = json.getAsJsonObject("eventAttributeValueMap");
        if (eventAttributeValueMap != null) 
        {
            JsonObject deviceCloudIdObj = eventAttributeValueMap.getAsJsonObject("deviceCloudId");
            if (deviceCloudIdObj != null) {
                deviceCloudIdObj.addProperty("stringValue", "AQAAAAGGUbUr9QAAAAHW5oTt");
            }
        }

        // Write the updated JsonObject back to the file
        try 
        {
        	GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
    	    gsonBuilder.setPrettyPrinting();

    	    Gson gson = gsonBuilder.create();
            String updatedJsonStr = gson.toJson(json);
            Files.write(Paths.get(input), updatedJsonStr.getBytes());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}