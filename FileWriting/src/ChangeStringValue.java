
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.*;

public class ChangeStringValue 
{

    public static void main(String[] args) throws Exception 
    {
        String input = "src\\obligationBridge_stage_Add.json";
        //using this method to avoid creating java object.
        JsonObject json = null;
        try
        {
        	//Getting the file contents from the json and parsing it.
            String jsonStr = new String(Files.readAllBytes(Paths.get(input)));
            JsonElement jsonElement = new JsonParser().parse(jsonStr);
            //initializing the json object as a tree head.
            json = jsonElement.getAsJsonObject();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        // modify the deviceCloudId value in the jsonobject
        //creating another jsonobject to get inside the json tree.
        JsonObject eventAttributeValueMap = json.getAsJsonObject("eventAttributeValueMap");
        if (eventAttributeValueMap != null) 
        {
        	//changing the value of deviceCloudID.
            JsonObject deviceCloudIdObj = eventAttributeValueMap.getAsJsonObject("deviceCloudId");
            if (deviceCloudIdObj != null) {
                deviceCloudIdObj.addProperty("stringValue", "AQAAAAGGUbUr9QAAAAHW5oTt");
            }
        }

        // Write the updated JsonObject back to the file
        try 
        {
        	//using this to preserve the json formatting.
        	GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
    	    gsonBuilder.setPrettyPrinting();

    	    Gson gson = gsonBuilder.create();
            String updatedJsonStr = gson.toJson(json);
            Files.write(Paths.get(input), updatedJsonStr.getBytes());
            System.out.println("Updated file successfully");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.out.println("Update failure");
        }
    }
}