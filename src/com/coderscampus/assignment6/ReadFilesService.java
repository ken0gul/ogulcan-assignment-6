package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFilesService {
	private List<Car> sales;

	public ReadFilesService(String fileName) {
		this.sales = new ArrayList<>();
	}

	public List<Car> getSales() {
		return sales;
	}

	public void readFile(String fileName) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				if (line.contains("Date")) {
					continue;
				}
				String date = line.split(",")[0];
				String sales = line.split(",")[1];
				this.sales.add(new Car(date, sales));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
