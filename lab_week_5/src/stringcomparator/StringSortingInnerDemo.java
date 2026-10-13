package stringcomparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringSortingInnerDemo {

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

		//uses named inner class (see below) as a callback object
		fruits.sort(new StringLenComparator());

		//print fruits
		System.out.println("\nCustom sort based on string length...");
		fruits.forEach(System.out::println); //using method reference notation

	}


	/* An inner class version of the Comparator in a static context - would not normally be static.
	   Has the benefit of being accessible throughout this entire class.*/
	public static class StringLenComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return Integer.compare(s1.length(), s2.length());
		}

	}
}
