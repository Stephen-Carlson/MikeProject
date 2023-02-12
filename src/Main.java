import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.HashMap;

import Tools.ItemScraper;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, HashMap<String, String>> items = ItemScraper.ScrapeItemsAsync().get();
        System.out.println(items.get("Ring of Protection"));
        executor.shutdown();
      }
}