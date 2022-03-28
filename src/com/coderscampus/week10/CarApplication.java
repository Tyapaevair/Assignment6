package com.coderscampus.week10;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarApplication {

    public static void main(String[] args) {

        CarService carService = new CarService();
        List<Car> model3 = carService.getSuspectfromFiles("model3.csv");
        List<Car> modelS = carService.getSuspectfromFiles("modelS.csv");
        List<Car> modelX = carService.getSuspectfromFiles("modelX.csv");

        createReport(model3, "Model3");
        createReport(modelS, "ModelLS");
        createReport(modelX, "ModelX");


    }
    private static void createReport(List<Car> carDate, String teslaModel){

        System.out.println(teslaModel);
        Map<Integer, List<Car>> groupByYear = carDate.stream()
              .collect(Collectors.groupingBy(s -> s.getDate().getYear()));

        String totalSales = groupByYear.entrySet()
              .stream()
              .map(s -> s.getKey() + " -> " + s.getValue().stream().mapToInt(Car::getSales).sum())
              .collect(Collectors.joining("\n"));

        System.out.println(totalSales);
        System.out.println("");

        Optional<Car> maxData = carDate.stream()
              .max((Car o1, Car o2) -> o1.getSales().compareTo(o2.getSales()));
        Optional<Car> minData = carDate.stream()
              .min((Car o1, Car o2) -> o1.getSales().compareTo(o2.getSales()));

        System.out.println("The best month for " + teslaModel + " was: " + maxData.orElse(new Car("Jan-20", "0")).getDate());
        System.out.println("The worst month for " + teslaModel + " was: " + minData.orElse(new Car("Dec-15", "0")).getDate());
        System.out.println("");
    }
}
