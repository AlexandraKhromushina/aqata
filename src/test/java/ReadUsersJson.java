import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// TODO switch from in-step requests to changeable JSONs
public class ReadUsersJson
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args, String fileName)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray userList = (JSONArray) obj;
            System.out.println(userList);

            //Iterate over array
            userList.forEach( emp -> parseUsersObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseUsersObject(JSONObject obj)
    {
        String userName = (String) obj.get("name");
        String userEmail = (String) obj.get("email");
        String userGender = (String) obj.get("gender");
        String userStatus = (String) obj.get("status");
    }
}