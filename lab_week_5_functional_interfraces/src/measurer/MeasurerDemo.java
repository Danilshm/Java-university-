package measurer;

import java.util.List;
import java.util.ArrayList;


public class MeasurerDemo {

	public static void main(String[] args) {

		List<String> fruit = new ArrayList<>();
		fruit.add("apple");
		fruit.add("orange");
		fruit.add("kiwi");

		int total = DataAnalysis.sum(fruit, String::length);
		System.out.println("Sum of fruit (length): " + total);
		
		double average = DataAnalysis.avg(fruit, String::length);
		System.out.println("Average of fruit (length): " + average);

		int max = DataAnalysis.maxValue(fruit, String::length);
		System.out.println("Max length fruit is: " + max);

		String maxStr = DataAnalysis.maxObject(fruit, String::length).orElse("Not present");
		System.out.println("Name of max fruit is: " + maxStr);

	}

}
