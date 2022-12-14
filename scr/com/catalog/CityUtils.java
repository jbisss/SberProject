package com.catalog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CityUtils {
    /**
     * Checks if scanner has a line to parse
     *
     * @param scanner receives a scanner
     * @return null if scanner has nothing to parse or a parsed string
     *
     */
    private static String hasNext(Scanner scanner) {
        String string;
        if(scanner.hasNext()) {
            string = scanner.next();
        } else {
            string = null;
        }
        return string;
    }

    /**
     * Uploading data about cities to a list
     *
     * @return a list of cities
     */
    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            String filename = "file/city_ru.csv";
            Path path = Paths.get(filename);
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter(System.getProperty("line.separator"));
            while(scanner.hasNext()){
                cities.add(parseToCity(scanner.next()));
            }
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    /**
     * Parsing a string from the file
     *
     * @param nextLine receives a string with a data
     * @return {@link City}
     */
    private static City parseToCity(String nextLine){
        Scanner scanner = new Scanner(nextLine);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String parsedName = hasNext(scanner);
        String parsedRegion = hasNext(scanner);
        String parsedDistrict = hasNext(scanner);
        String parsedPopulation = hasNext(scanner);
        String parsedFoundation = hasNext(scanner);
        return new City(parsedName, parsedRegion, parsedDistrict, parsedPopulation, parsedFoundation);
    }
}
