package stringcomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringSortingExternalDemo {

	public static void main(String[] args) {

		//uses interface type List as a container for the ArrayList (can easily swap to e.g. LinkedList)
		List<String> fruits = new ArrayList<>();
		fruits.add("Pineapple");
		fruits.add("Kiwi");
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Watermelon");
		fruits.add("Grape");
		fruits.add("Orange");

		/* -- sort fruits based on the compareTo implementation of the String class, i.e. their natural order -- */
		fruits.sort(Comparator.naturalOrder()); //equivalent to Collections.sort(fruits);

		//print fruits
		System.out.println("Natural order sort results...");
		fruits.forEach(f -> System.out.println(f));


		/* -- sort fruits based on their string length -- */

		//uses external top-level class as a callback object
		fruits.sort(new StringLengthComparator());

		//print fruits
		System.out.println("\nCustom sort based on string length...");
		fruits.forEach(System.out::println); //using method reference notation

	}

}

