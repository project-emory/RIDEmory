package com.projectpandas.ridemory.services;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    // TODO:
    // Traffic times
    // Uber/Lyft price estimates
    // Transloc
    // DONE:
    // ATL TSA wait times

    public final HttpClient client;
    public static final String TSAWaitTimeAPI = "https://www.atl.com/times/";
    public static final String[] checkpoints = { "MAIN", "NORTH", "LOWER NORTH", "SOUTH", "INT'L" };

    // @Autowired
    public InfoService() {
        client = HttpClient.newHttpClient();

        // example request code using Http
        // HttpRequest request = HttpRequest.newBuilder()
        // .uri(URI.create(TSAWaitTimeAPI))
        // .GET()
        // .build();

        // CompletableFuture<String> response = client.sendAsync(request,
        // BodyHandlers.ofString())
        // .thenApply(HttpResponse::body);
    }

    public Map<String, Integer> getATLWaitTime() {
        // hard coded, since scraping directly from www.atl.com is specific to ATL
        // airport
        // will need to use some other api for general wait times

        try {
            Map<String, Integer> times = new HashMap<>();
            Document doc = Jsoup.connect(TSAWaitTimeAPI).get();
            Elements els = doc.select("div.row");

            for (int i = 4; i < 9; i++) {
                String checkpoint = checkpoints[i - 4];
                Integer wait = Integer.parseInt(els.get(i).select("span").html());
                times.put(checkpoint, wait);
            }

            return times;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
