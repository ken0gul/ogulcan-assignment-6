package com.coderscampus.assignment6;

import java.io.FileNotFoundException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AnalyzeData {

	
	public static void analyze(String model,String fileName) throws FileNotFoundException {
		
		// Read the file
		ReadFilesService modelName = new ReadFilesService(fileName);
		modelName.readFile(fileName);
		
		
		// Get sales to store into a list and stream through it
		// Create 3 different List for 3 different year
//		List<Car> car = modelName.getSales();
//		
//		List<Car> sales16 = getYearOfTheSales(car, 2016);
//		List<Car> sales17 = getYearOfTheSales(car, 2017);
//		List<Car> sales18 = getYearOfTheSales(car, 2018);
//		List<Car> sales19 = getYearOfTheSales(car, 2019);
		
		
	
		
		// Print it out
		
		
		printHello(model, modelName);
		
		
	}
	
	
	
	
	
	public static void printHello(String model,  ReadFilesService modelName ) {
		System.out.println("\n"+model + " Yearly Sales Report\n");
		List<Car> cars =  modelName.getSales();
		
		

		Map<Integer, Integer> m =cars.stream()
			.filter(item -> item.getYear() != null)
			.distinct()
			.collect(Collectors.groupingBy(Car::getYear, Collectors.summingInt(Car::getNumberOfSales)));
	
			
		 m.entrySet().stream()
					 .forEach(item -> System.out.println(item.getKey() + " -> " + item.getValue()));

			String bestMonth=	cars.stream()
					   .max(Comparator.comparing(Car::getNumberOfSales))
					   .map(item -> item.getDate())
					   .get().format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
			
			String worstMonth=	cars.stream()
					   .min(Comparator.comparing(Car::getNumberOfSales))
					   .map(item -> item.getDate())
					   .get().format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
			
			System.out.println("\nThe best month for " + model + " was: " + bestMonth);
			System.out.println("The worst month for " + model + " was: " + worstMonth);
		
		
	}
	
//	public static List<Car> getYearOfTheSales(List<Car> car, Integer year) {
//		
//		List<Car> list = car.stream()
//
//				.filter(item -> item.getDate().getYear() < (year+1))
//				.collect(Collectors.toList());
//		
//		return list;
//	}
}
