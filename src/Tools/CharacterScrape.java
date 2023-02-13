
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class CharacterScrape {
  private String code;
  private String clientId;
  private String clientSecret;
  private String redirectUri;

  public CharacterScrape(String code, String clientId, String clientSecret, String redirectUri) {
    this.code = code;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.redirectUri = redirectUri;
  }

  public void scrape() throws IOException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    try {
      HttpPost request = new HttpPost("https://oauth2.googleapis.com/token");

      List<NameValuePair> requestParams = new ArrayList<>();
      requestParams.add(new BasicNameValuePair("code", code));
      requestParams.add(new BasicNameValuePair("client_id", clientId));
      requestParams.add(new BasicNameValuePair("client_secret", clientSecret));
      requestParams.add(new BasicNameValuePair("redirect_uri", redirectUri));
      requestParams.add(new BasicNameValuePair("grant_type", "authorization_code"));

      request.setEntity(new UrlEncodedFormEntity(requestParams));

      CloseableHttpResponse response = httpClient.execute(request);
      try {
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
          String responseJson = EntityUtils.toString(responseEntity);
          // Parse the JSON to extract the access token
        }
      } finally {
        response.close();
      }
    } finally {
      httpClient.close();
    }
  }
}
