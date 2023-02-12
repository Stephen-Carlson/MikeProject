import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class CharacterScrape {
  private final String USER_AGENT = "Mozilla/5.0";

  public static void main(String[] args) throws Exception {
    CharacterScrape http = new CharacterScrape();
    System.out.println("Sending request...");
    http.sendGet();
  }

  // HTTP GET request
  private void sendGet() throws Exception {
    String url = "https://www.dndbeyond.com/campaigns/1495997";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    // Add request header
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    // Add authorization header
    String auth = "your_username:your_password";
    byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
    String authHeaderValue = "Basic " + new String(encodedAuth);
    con.setRequestProperty("Authorization", authHeaderValue);

    // Send request
    int responseCode = con.getResponseCode();
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    System.out.println(response.toString());
  }
}
