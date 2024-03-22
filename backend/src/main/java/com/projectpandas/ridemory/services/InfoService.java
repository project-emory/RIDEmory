package com.projectpandas.ridemory.services;

import com.projectpandas.ridemory.config.APIKeys;
import com.projectpandas.ridemory.models.Ride;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final String GoogleMapAPIKEY = APIKeys.googleAPIKey;

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

    public String getTrafficTimeEstimate(Ride ride) {
        List<Double> origin = ride.getTo();
        List<Double> destination = ride.getFrom();
        // GeoJsonPoint origin=ride.getOrigin();
        // GeoJsonPoint destination=ride.getDestination();
        try {
            String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin.get(0) + ","
                    + origin.get(1) + "&destinations=" + destination.get(0) + "," + destination.get(1)
                    + "&departure_time=now&traffic_model=best_guess&key=" + GoogleMapAPIKEY;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Error retrieving traffic time. Status code: " + response.statusCode());
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
