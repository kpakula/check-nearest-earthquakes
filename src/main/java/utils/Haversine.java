package utils;

public class Haversine {
    private static final int RADIUS_OF_EARTH = 6371;

    public static double calculateDistance(double startLatitude, double startLongitude,
                                          double endLatitude, double endLongitude) {

        double rStartLatitude = Math.toRadians(startLatitude);
        double rEndLatitude = Math.toRadians(endLatitude);
        double rLatitude = Math.toRadians((endLatitude - startLatitude));
        double rLongitude = Math.toRadians((endLongitude - startLongitude));

        double a = formula(rLatitude) + Math.cos(rStartLatitude) * Math.cos(rEndLatitude) * formula(rLongitude);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (RADIUS_OF_EARTH * c);
    }

    private static double formula(double value) {
        return Math.pow(Math.sin(value / 2), 2);
    }
}
