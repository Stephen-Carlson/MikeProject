package Tools;
//import java.io.IOException;
//import java.util.ArrayList;
import java.io.IOException;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ItemScraper {
  public void ScrapeItems() throws IOException {
    // Make a GET request to the URL
    String url = "https://roll20.net/compendium/dnd5e/Index%3AItems";
    Document response = Jsoup.connect(url).get();

    // Parse the HTML content of the page
    Document soup = response;

    // Find all the items on the page
    Elements items = soup.select("li");

    // Create a list to store the data
    //Map<String, Map<String, String>> data = new HashMap<>();
    Map<String, String> itemData = new HashMap<>();
    Map<String, HashMap<String,String>> completeItems = new HashMap<>();
    // Loop through each item
    for (Element item : items) {
      // Extract the item name and href
      Element itemName = item.selectFirst("a");
      // filter out unwanted items
      String href = itemName.attr("href");
      if (href != null && !href.contains("https") && !href.contains("http")) {
        itemData.put(itemName.text().trim(), href);
      }
    }
    // Make one request per item to get attributes
    
    for (String key : itemData.keySet()) {
      try{
      System.out.println(key);
      String url1 = "https://roll20.net" + itemData.get(key);
      Document resp1 = Jsoup.connect(url1).get();
      Document soup1 = resp1;
      Elements attributes = soup1.select(".row.attrListItem");
      HashMap<String, String> attributesDict = new HashMap<>();
      for (Element attribute : attributes) {
        String name = attribute.selectFirst(".col-md-3.attrName").text();
        String value = attribute.selectFirst(".value").text();
        attributesDict.put(name, value);
      }
      completeItems.put(key,attributesDict);
      }catch(IOException e){
        continue;
      }
    }
    System.out.println(completeItems.size());
    System.out.println(completeItems.get("Abacus"));
    System.out.println(completeItems.get("Whip"));
    System.out.println(completeItems.get("Piton"));
  }
  }