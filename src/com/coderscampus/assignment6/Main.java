package com.coderscampus.assignment6;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		 AnalyzeData.analyze("Model3", "model3.csv");
		 AnalyzeData.analyze("ModelS", "modelS.csv");
		 AnalyzeData.analyze("ModelX", "modelX.csv");

	}

}
