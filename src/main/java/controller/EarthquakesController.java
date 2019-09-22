package controller;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import model.Earthquake;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Haversine;

import java.util.TreeSet;


public class EarthquakesController {
    private static final String URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";

    private TreeSet<Earthquake> earthquakes;
    private Gson gson;
    private double startLatitude;
    private double startLongitude;

    public EarthquakesController(double startLatitude, double startLongitude) {
        earthquakes = new TreeSet<>();
        gson = new Gson();

        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
    }


    public void checkEarthquakes() {
        HttpResponse<JsonNode> request = getAllAvailableEarthquakes(URL);
        JSONArray allFeatures = getAllFeatures(request);

        for (int i = 0; i < allFeatures.length(); i++) {
            Earthquake earthquake = mapJsonToObject(allFeatures, i);
            earthquakes.add(earthquake);
        }
    }

    private HttpResponse<JsonNode> getAllAvailableEarthquakes(String URL) {
        return Unirest.get(URL).asJson();
    }

    private JSONArray getAllFeatures(HttpResponse<JsonNode> request) {
        JSONObject allData = request.getBody().getObject();
        return allData.getJSONArray("features");
    }


    private Earthquake mapJsonToObject(JSONArray allFeatures, int i) {
        Earthquake earthquake = gson.fromJson(allFeatures.getJSONObject(i).toString(), Earthquake.class);

        double kilometers = calculateDistanceBetweenTwoPoints(earthquake.getLatitude(), earthquake.getLongitude());
        earthquake.setKilometers(kilometers);

        return earthquake;
    }

    private double calculateDistanceBetweenTwoPoints(double endLatitude, double endLongitude) {
        return Haversine.calculateDistance(startLatitude, startLongitude, endLatitude, endLongitude);
    }


    public void showTopNearestEarthquakes(int numberOfElements) {
        earthquakes.stream()
                .limit(numberOfElements)
                .forEach(earthquake ->
                        System.out.println(earthquake.getTitle() + " || " + Math.round(earthquake.getKilometers())));
    }
}
