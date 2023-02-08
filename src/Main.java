import java.io.IOException;

import Tools.ItemScraper;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        ItemScraper i = new ItemScraper();
        i.ScrapeItems();
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1_000_000_000);
    }
}