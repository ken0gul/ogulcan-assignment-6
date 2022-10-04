package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public class Car implements Comparator<Car> {
	private String name;
	private YearMonth date;
	private Integer numberOfSales;

//	private List<Car> sales;
	public Car(String date, String numberOfSales) {
		YearMonth dates = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		this.date = dates;
		this.numberOfSales = Integer.valueOf(numberOfSales);
//		this.sales = new ArrayList<>();
	}

	public YearMonth getDate() {
		return date;
	}

	public Integer getNumberOfSales() {
		return numberOfSales;
	}
	
	public String getName() {
		return this.name;
	}


	@Override
	public String toString() {
		return "Car [date=" + date + ", numberOfSales=" + numberOfSales + "]";
	}

	@Override
	public int compare(Car sale1, Car sale2) {
		return sale1.getNumberOfSales().compareTo(sale2.getNumberOfSales());
	}

}
