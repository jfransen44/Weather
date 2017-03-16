import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jeremyfransen on 3/11/17.
 */
public class GetWeatherData {

    private String baseUrl = "http://api.wunderground.com/api/a5fbdbcfd23b9cd3/geolookup/conditions/q/";
    
    //Constructors
    public GetWeatherData(){
    }

    //form url and retrieve data using city and state
    public String[] getDataFromCity (String cityState){
        JSONObject jsonObject = null;
        String city = "";
        String state = "";
        if (cityState.length() > 3) {
            city = cityState.substring(0, cityState.length() - 2);
            state = cityState.substring(cityState.length() - 2);
        }
        try {
            URL query = new URL(baseUrl +  state + "/" + city + ".json");
            InputStream inputStream = query.openStream();
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            jsonObject = new JSONObject(jsonTokener);
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getDataString(jsonObject);
    }

    public String[] getDataFromZip(String zipCode){
        JSONObject jsonObject = null;

        try {
            URL query = new URL(baseUrl + zipCode + ".json");
            InputStream inputStream = query.openStream();
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            jsonObject = new JSONObject(jsonTokener);
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

         return getDataString(jsonObject);
    }

    private String[] getDataString(JSONObject jsonObject){
        String[] s =  {"", "", "", ""};
        try {
            jsonObject = jsonObject.getJSONObject("current_observation");
            System.out.print("The current temperature is " + jsonObject.get("temperature_string"));
            System.out.print(" and feels like " + jsonObject.get("feelslike_string"));
            s[0] = jsonObject.getString("temperature_string");
            s[1] = jsonObject.getString("feelslike_string");
            s[2] = jsonObject.getString("weather");
            s[3] = jsonObject.getString("forecast_url");
        } catch (JSONException e) {
            //e.printStackTrace();
            System.out.println("NO DATA");
            s[0] = "No data available";
        }
        return s;
    }
}
