package com.coderscampus.assignment6;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		List<Car> model3 = AnalyzeData.analyze("Model3", "model3.csv");
		List<Car> modelS = AnalyzeData.analyze("modelS", "modelS.csv");
		List<Car> modelX = AnalyzeData.analyze("ModelX", "modelX.csv");

	}

}
