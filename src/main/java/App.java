import controller.EarthquakesController;

import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final int NUMBER_OF_ELEMENTS_TO_DISPLAY = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


        double startLatitude = scanner.nextDouble();
        double startLongitude = scanner.nextDouble();


        EarthquakesController controller = new EarthquakesController(startLatitude, startLongitude);

        controller.checkEarthquakes();
        controller.showTopNearestEarthquakes(NUMBER_OF_ELEMENTS_TO_DISPLAY);

    }
}

