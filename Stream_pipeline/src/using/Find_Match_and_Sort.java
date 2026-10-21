package using;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;


/* A review has a description and rating.
 * 
 * This has been defined via a record class with two fields. The fields are final and so cannot be
 * modified - there are no set methods, but you are provided with accessor methods.
 * A record class is intended to serve as a simple data carrier, and cannot be extended via inheritance.
 *
 * One typical use case would be to use records for immutable data transfer objects related to storage
 * and communication with databases. */
record Review(String description, int rating) { }


public class Find_Match_and_Sort {

	public static void main(String[] args) {
		/* This program illustrates how streams can be sorted in combination with custom comparators.
		 * It also shows how some terminal operations return an Optional that may or may not have a value present.
		 * Furthermore, there are different means of finding elements or checking if elements exist in a stream.
		 */

		//List.of is a convenient way to create a fixed-size list that cannot be modified - doing so throws an exception
		List<String> fruits = List.of("Pineapple", "Kiwi", "Apple", "Banana", "Watermelon", "Grape", "Orange");
		
		System.out.println(" --- 1. Using sorted() - output");
		
		/* --- 1. Sorting a stream into its natural order using sorted() --- */
		fruits.stream().sorted().forEach(System.out::println); //uses the (natural order) comparator to sort stream with the intermediate sorted() operation

		
		System.out.println("\n --- 2. Using findFirst() and Optional - output");
		
		/* --- 2. Finding the first element of a stream using findFirst() and Optional --- */
		Optional<String> firstElem = fruits.stream().sorted().findFirst(); //returns an Optional value as stream may be empty

		//can check if optional holds a value using isPresent
		if (firstElem.isPresent()) {
			System.out.println("First string element from natural order sort is... " + firstElem.get()); //gets the actual value of the optional element
		}
		

		//populate a further unmodifiable list of reviews for testing
		List<Review> reviews = List.of(new Review("Excellent - exactly as described", 4), new Review("Awful - will not use again", 1), new Review("Outstanding and faultless", 5), new Review("Could be better", 3));
		
		System.out.println("\n --- 3. Using sorted(Comparator) and max(Comparator) - output");
		
		/* --- 3. Sorting a stream into a custom order using sorted(Comparator) and using max(Comparator) to get the maximum element --- */
		fruits.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println); //use custom comparator to sort (based on string length) and then print out the list

		//use custom comparator find the maximum value of a stream (based on string length). An Optional is returned, as the stream may be empty.
		String maxLength = fruits.stream().max(Comparator.comparing(String::length)).orElse("No string found"); //orElse provides an alternative value if the Optional is empty
		System.out.println("\nMax length string is... " + maxLength + "\n");

		reviews.stream().sorted(Comparator.comparing(Review::rating).reversed()).forEach(System.out::println); //sort based on review rating in desc order
		
		
		System.out.println("\n --- 4. Using findAny() and anyMatch - output");
		
		/* --- 4. Finding and matching any element using findAny() and anyMatch --- */
		String len5 = fruits.stream().filter(s -> s.length() == 5).findAny().orElse("No fruit found"); //orElse provides an alternative value if an element is not found
		//a filter can be followed by a find to retrieve a given element
		System.out.println("Fruit of length 5 is: " + len5);

		//if you do not want to retrieve an element and just want to check if it exists you can use anyMatch, which accepts a predicate
		System.out.println("\nAny match with Banana? " + fruits.stream().anyMatch(s -> s.equals("Banana")));

		System.out.println("\nAny match with faultless? " + reviews.stream().anyMatch(r -> r.description().contains("faultless"))); //note the use of contains instead of equals here
		
		
		
		/* --- TO DO : tasks --- */

		/* TASK 1. Use the noneMatch terminal operation, that is similar to anyMatch (accepting a predicate), 
		 * but returns true if no elements match the given predicate. You should check that no element
		 * in the list of fruits matches the string "Toast".
		 */



		/* TASK 2. Use the allMatch terminal operation - the opposite of noneMatch.
		 * Use IntStream.of (example in BuildingStreams.java) to generate a stream of
		 * 5 even numbers, then provide allMatch with a suitable predicate to ascertain whether
		 * all elements are indeed even. Make one of the numbers odd and test it then returns false.
		 */



		/* TASK 3. Use the min() terminal operation on a DoubleStream.
		 * Use DoubleStream.of to generate a stream of 5 decimal point numbers.
		 * Then use the min() terminal operation that does not require a Comparator as min and max of numbers
		 * are well defined. This will return an OptionalDouble, which you can invoke the orElse method on
		 * to return -1 if a number is not found. You should ensure it works correctly and outputs the minimum number regardless of its position in the stream.
		 */



		/* TASK 4. Use the sorted(Comparator) intermediate operation shown above.
		 * Ensure the Name class is within your project and then use List.of to easily create
		 * a List of 3 Name objects, each with different first and last names.
		 * You should then use a stream pipeline and provide the sorted method with a Comparator that
		 * sorts them based on their first name, and then prints them out using the forEach terminal operation.
		 */


		
		/* TASK 5. Using the same list you created from the previous task, use the mapToInt(...) intermediate operation
		 * to map Name objects to integers based on their length. Follow this with a call to the then max() terminal
		 * operation, that will return an OptionalInt. If this is present, you should output the result it stores. */

		

	}

}
