import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author www.epam.com
 */
public class Main4 {

    /*
    * Complete the function below.
    */
    static void cutSticks(int[] lengths) {
        String topic = "pizza";
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            //System.out.println(content);

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonParser().parse(content.toString()).getAsJsonObject();
            JsonObject parse = jsonObject.get("parse").getAsJsonObject();
            String text = parse.get("text").toString();

            int i = 0;
            Pattern p = Pattern.compile(topic);
            Matcher m = p.matcher(text);
            while (m.find()) {
                i++;
            }
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        int[] array = new int[]{6, 5, 4, 4, 2, 2, 8};
        cutSticks(array);
    }
}
