package collecting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.TreeSet;
import java.util.function.Function;

//this static import allows static methods of the Collectors class to be referenced directly for convenience
import static java.util.stream.Collectors.*; 

public class CollectingStreams {

	public static void main(String[] args) {
		/* This program illustrates common ways of collecting values from streams via various common reductions. 
		 * For example, values can be collected into arrays, lists, sets, maps, or strings, or reduced to single values, e.g. mean, average.
		 */
		
		System.out.println(" --- 1. Collect into arrays. - output");
		
		/* --- 1. Streams can be collected into arrays using the .toArray method --- */
		String[] strNums = Stream.of("One", "Two", "Three").map(String::toUpperCase).toArray(String[]::new);
		//streams of objects can be collected into an array using a constructor reference, i.e. T[]::new where T is the element type
		System.out.println(Arrays.toString(strNums));
		//for primitive types streams (e.g. IntStream), simply call toArray()
		int[] nums = IntStream.of(1, 2, 3).filter(x -> x % 2 == 1).toArray();
		System.out.println(Arrays.toString(nums));
		
		
		System.out.println("\n --- 2. Collect into strings. - output");
		
		/* --- 2. Streams of strings, can be collected into a single string using Collectors.joining  --- */
		String joined = Stream.of("One", "Two", "Three").collect(Collectors.joining(" @ "));
		System.out.println(joined);
		//NOTE - due to the static import of Collectors.* at the top of this class you can omit "Collectors." above and
		//       call the static methods directly, e.g. "joining" (see below). For the remaining part of this program we will do this.
		//String staticShowcase = Stream.of("One", "Two", "Three").collect(joining(" @ "));
				
		
		System.out.println("\n --- 3. Collect into sets. - output");
		
		/* --- 3. Streams can be collected into a set using Collectors.toSet() or Collectors.toCollection (duplicates automatically removed) --- */
		Set<String> set = Stream.of("Pear", "Banana", "Apple", "Pear").collect(toSet());
		System.out.println(set.getClass() + " " + set.toString()); //you cannot guarantee set type returned by toSet()
		TreeSet<String> tree = Stream.of("Pear", "Banana", "Apple", "Pear").collect(toCollection(TreeSet::new)); //using constructor reference
		System.out.println(tree.getClass() + " " + tree.toString()); //here we have a tree set and elements will be ordered
		
		
		//populate an unmodifiable list of orders for testing
		List<OrderLine> orders = List.of(new OrderLine("Milk", 99, 2), new OrderLine("Cheese", 350, 1), new OrderLine("Bread", 130, 3), new OrderLine("Milk", 99, 1));
		
		System.out.println("\n --- 4. Collect into lists. - output");
		
		/* --- 4. Streams can be collected into a list using Collectors.toList() or Collectors.toCollection --- */
		List<String> list = orders.stream().filter(o -> o.getQuantity() >= 2).map(OrderLine::getId).collect(toList());
		System.out.println("Id of orders with a quantity of 2 or more: " + list);
		//again toCollection allows a specific list implementation to be explicitly chosen
		ArrayList<Integer> arrayList = orders.stream().map(OrderLine::getUnitPrice).sorted().collect(toCollection(ArrayList::new));
		System.out.println("List of (asc) unit prices: " + arrayList);
		
		
		System.out.println("\n --- 5. Collect into maps. - output");
		
		/* --- 5. Streams can be collected into a map using overloaded variations of Collectors.toMap --- */
		Map<String, Integer> map = Stream.of("One", "Two", "Three").collect(toMap(s -> s, s -> s.length())); //maps strings to their length
		System.out.println("Map strings to their length: " + map); 
		
		/* NOTE: uncomment the line of code below and you will see an exception is thrown because there is a collision as the
		 * key representing (length) 3 maps to the strings "One" and "Two" */
		//Map<Integer, String> mapCollision = Stream.of("One", "Two", "Three").collect(toMap(s -> s.length(), s -> s)); //maps lengths to strings

		//a variation of toMap that solves the collision problem above allows a merger function to be provided that states what should happen
		//in the event of there being a collision. In this case, we merge (through concatenation) the existing value with the new value separated by a semicolon.
		Map<Integer, String> mapMerge = Stream.of("One", "Two", "Three").collect(toMap(String::length, Function.identity(), (a, b) -> a + "; " + b)); 
		System.out.println("Map lengths to corresponding strings using a merge: " + mapMerge); //Function.identity() above is equivalent to s -> s and String::length is the same as s -> s.length()
		
		//if you want to ensure a specific map type you can use another overloaded variation of toMap that accepts a supplier as a 4th argument
		HashMap<String, Integer> orderMap = orders.stream().collect(toMap(OrderLine::getId, OrderLine::getCost, (a, b) -> a + b, HashMap::new));
		System.out.println("Map order ids to their costs (milk order costs are added): " + orderMap);
		
		
		System.out.println("\n --- 6. Collect into numeric values. - output");
		
		/* --- 6. Streams can be collected (and reduced) into a single numeric value using Collectors.summingInt, summingDouble, etc --- */
		int totalCost = orders.stream().collect(summingInt(OrderLine::getCost));
		System.out.println("Total cost of all orders is " + totalCost + " pence.");
		
		
		
		/* --- TO DO : tasks --- */

		/* TASK 1. Use the Collectors.averagingInt method to reduce the unit price of all orders to
		 * a single average value of type double and then output this. This method can be used in
		 * a similar way to summingInt, with the notable difference being that it returns a double.
		 */
		
		
		
		/* TASK 2. Use the map(...) operation to map each order in the list of orders to its (String) id and then
		 * invoke Collectors.joining to join each of the id's into a single string, separated by a newline (\n). 
		 * Then output it to check the result.
		 */
		
		
		
		/* TASK 3. Ensure the Name class is within your project and then use List.of to create and populate a
		 * fixed-size list with 3 Name objects, initialised with names of your choice. 
		 * Then use the Collectors.toMap method to create a map of type <String, String> that maps first name keys
		 * to family name values. If more than one person has the same first name, then the family names should be
		 * concatenated into a single string as in the example above
		 */
		
		
		
		/* TASK 4. Using the same list from TASK 3 above, use the Collectors.toMap method to create a map 
		 * of type <Integer, String> that maps the length of full names as keys to the corresponding full name value. 
		 * If more than one person has the same length name, then the full names should be concatenated.
		 */
		
		
		
	}

}
