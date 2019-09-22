package model;

public class Earthquake implements Comparable<Earthquake> {

    private Properties properties;
    private Geometry geometry;

    private double kilometers;


    public Earthquake() {}

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public String getTitle() {
        return this.properties.getTitle();
    }

    public double getLatitude() {
        return this.geometry.getCoordinates().get(1);
    }

    public double getLongitude() {
        return this.geometry.getCoordinates().get(0);
    }

    @Override
    public int compareTo(Earthquake o) {
        if (getLatitude() == o.getLatitude() && getLongitude() == o.getLongitude()) return 0;
        else if (getKilometers() >= o.getKilometers()) return 1;
        else if (getKilometers() < o.getKilometers()) return -1;
        else return 0;
    }

}
