import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class apiCall {
    public static void main(String[] args) throws IOException {
        //apiCall.get("SrijitG13");
 
    }
 
    public static String getValue(String key, Map<String, String> map) {
        return map.get(key);
    }
 
    public static String get(String username, String url) throws IOException {
        // "https://www.instagram.com/"+username+"/?__a=1"
        // https://api.github.com/users/Hellboy-Aaryan
        // https://covid19.mathdro.id/api
 
        URL urlForGetRequest = new URL(url);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        Map<String, String> map = new HashMap<>();
 
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            //System.out.println(response.toString());
            String s = response.toString();
 
            //System.out.println(s);
            /*
            List<String> list = new ArrayList<>();
 
            String[] arr1 = s.split(",");
            for (String string : arr1) {
                String[] s2 = string.split(":");
                for (String string2 : s2) {
                    string2 = string2.replace("{", "");
                    string2 = string2.replace("}", ""); 
                    string2 = string2.replace('"'+"", "");
                    string2 = string2.replace("[", "");
                    string2 = string2.replace("]", "");
 
                    list.add(string2);
                }
            }
 
            for (int i = 0; i < arr1.length; i+=2) {
                String key = list.get(i);
                String value = list.get(i+1);
 
                map.put(key, value);
 
                //System.out.println(key + " : " + value);
            }*/
            
            return s;
        } else {
            System.out.println("User not found");
        }
 
        return null;
    
    }
}