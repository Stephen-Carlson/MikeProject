package Tools;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;

public class ItemScraper {

  public static final  ConcurrentHashMap<String, HashMap<String, String>> completeItems = new ConcurrentHashMap<>();
  public static CompletableFuture<ConcurrentHashMap<String, HashMap<String, String>>> ScrapeItemsAsync() {
    return CompletableFuture.runAsync(() -> {
      try {
        // Make a GET request to the URL
        String url = "https://roll20.net/compendium/dnd5e/Index%3AItems";
        Document response = Jsoup.connect(url).get();

        // Parse the HTML content of the page
        Document soup = response;

        // Find all the items on the page
        Elements items = soup.select("li");

        // Create a list to store the data
        HashMap<String, String> itemData = new HashMap<>();
        //ConcurrentHashMap<String, HashMap<String, String>> completeItems = new ConcurrentHashMap<>();
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
          try {
            //System.out.println(key);
            String url1 = "https://roll20.net" + itemData.get(key);
            Document resp1 = Jsoup.connect(url1).get();
            Document soup1 = resp1;
            String desc = soup1.select("meta[name=description]").attr("content").trim().replaceAll("\n", "");;
            //System.out.println(desc);
            Elements attributes = soup1.select(".row.attrListItem");
            HashMap<String, String> attributesDict = new HashMap<>();
            attributesDict.put("desc",desc);
            for (Element attribute : attributes) {
              String name = attribute.selectFirst(".col-md-3.attrName").text();
              String value = attribute.selectFirst(".value").text();
              attributesDict.put(name, value);
            }
           completeItems.put(key, attributesDict);
          } catch (Exception e) {
            continue;
          }
        }
      } catch (IOException e){
        System.out.println("oops");
        System.out.println(e);
      }
    }).thenApply(aVoid -> {
      System.out.println("Done");
      // System.out.println(ItemScraper.completeItems.size());
      // System.out.println(ItemScraper.completeItems.get("Shortbow"));
      try {
        writeToCSV(ItemScraper.completeItems);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return completeItems;
    });
  }
  public static void writeToCSV(ConcurrentHashMap<String, HashMap<String, String>> items) throws IOException{
    //File outfile = new File("/src/Data/Roll20Items.csv");
    FileWriter outFileWriter = new FileWriter("Roll20Items.csv");
    String delim = "|";
    //determine max number of attributes
    int max = 0;
    for(String key: items.keySet()){
      if(items.get(key).size() > max){
        max = items.get(key).size();
      }
    }
    //have accurate max here
    //header row
    outFileWriter.append("Item Name");
    for(int i = 0; i<max; ++i){
      outFileWriter.append(delim);
      outFileWriter.append("AttributeName"+i);
      outFileWriter.append(delim);
      outFileWriter.append("AttributeValue"+i);
    }
    outFileWriter.append("\n");
    //actual data now
    for(String key: items.keySet()){
      outFileWriter.append(key);
      for(var attributeKey: items.get(key).keySet()){
        outFileWriter.append(delim);
        outFileWriter.append(attributeKey);
        outFileWriter.append(delim);
        outFileWriter.append(items.get(key).get(attributeKey));
    }
    outFileWriter.append("\n");
    } 
    outFileWriter.close();
  }
}