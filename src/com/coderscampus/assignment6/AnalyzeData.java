package com.coderscampus.assignment6;

import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeData {

	
	public static List<Car> analyze(String model,String fileName) throws FileNotFoundException {
		
		// Read the file
		ReadFilesService modelName = new ReadFilesService(fileName);
		modelName.readFile(fileName);
		
		
		// Get sales to store into a list and stream through it
		// Create 3 different List for 3 different year
		List<Car> car = modelName.getSales();
		List<Car> sales17 = car.stream()

				.filter(item -> item.getDate().getYear() < 2018)
				.collect(Collectors.toList());
		
		List<Car> sales18 = car.stream()

				.filter(item -> item.getDate().getYear() < 2019)
				.collect(Collectors.toList());
		
		List<Car> sales19 = car.stream()

				.filter(item -> item.getDate().getYear() < 2020)
				.collect(Collectors.toList());
		// Total sales of Tesla model3 in 2017
		Integer totalSales17 = sales17.stream()
								 .collect(Collectors.summingInt(i -> i.getNumberOfSales()));
		
		// Total sales of Tesla model3 in 2018 
		Integer totalSales18 = sales18.stream()
				 .collect(Collectors.summingInt(i -> i.getNumberOfSales()));
		
		// Total sales of Tesla modelX in 2019
		Integer totalSales19 = sales19.stream()
				 .collect(Collectors.summingInt(i -> i.getNumberOfSales()));
		
		// Best and Worst Months
		String bestMonth=	car.stream()
				   .max(Comparator.comparing(Car::getNumberOfSales))
				   .map(item -> item.getDate())
				   .get().format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
		
		String worstMonth=	car.stream()
				   .min(Comparator.comparing(Car::getNumberOfSales))
				   .map(item -> item.getDate())
				   .get().format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
		// Print it out
		
		printHello(model, totalSales17, totalSales18, totalSales19, bestMonth, worstMonth);
		
		
		return car;
	}
	public static void printHello(String model, Integer totalSales17, Integer totalSales18, Integer totalSales19, String bestMonth, String worstMonth ) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println("2017 -> " + "$"+totalSales17 + "\n"
				+ "2018 -> " +"$"+ totalSales18 + "\n2019 -> " + "$"+totalSales19);
		System.out.println("The best month for Model S was: " + bestMonth
				+ "\nThe worst month for Model S was: " + worstMonth +"\n");
	}
}
