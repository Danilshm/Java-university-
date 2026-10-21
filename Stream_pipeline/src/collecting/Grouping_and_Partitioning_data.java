package collecting;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//this static import allows static methods of the Collectors class to be referenced directly for convenience
import static java.util.stream.Collectors.*; 

public class Grouping_and_Partitioning_data {

	public static void main(String[] args) {
		/* This program shows two more advanced (but powerful) ways of collecting data - via grouping and partitioning. 
		 * Both these operations create maps of grouped data, often with each key being mapped to a collection of values.
		 */

		//populate an unmodifiable list of random strings for testing
		List<String> keywords = List.of("Apple", "Tomato", "Mango", "Boon", "Beer", "Banana", "Beer", "Ananas");

		System.out.println(" --- 1. Using three overloaded groupingBy(...) variations - output");

		/* --- 1. Grouping streams into maps of keys to collections of values using different variations of groupingBy --- */
		Map<Character, List<String>> map1 = keywords.stream().collect(groupingBy(s -> s.charAt(0))); //groups strings by their first character
		System.out.println("Map<Character>, List<String> results:\n" + map1.toString() + "\n"); //a List is used by default to store the 'grouped' values

		Map<Character, TreeSet<String>> map2 = keywords.stream().collect(groupingBy(s -> s.charAt(0), toCollection(TreeSet::new))); //allows a specific collection to be chosen for the values
		System.out.println("Map<Character>, TreeSet<String> results:\n" + map2.toString() + "\n"); //as TreeSet is used, the values are now ordered and duplicates have been removed

		TreeMap<Character, TreeSet<String>> map3= keywords.stream().collect(groupingBy(s -> s.charAt(0), TreeMap::new, toCollection(TreeSet::new))); //allows a specific map to be chosen
		System.out.println("TreeMap<Character>, TreeSet<String> results:\n" + map3.toString()); //as TreeMap is used, the keys are now ordered


		//populate an unmodifiable list of names for testing
		List<Name> names = List.of(new Name("Joe", "Bloggs"), new Name("Fred", "Bloggs"), new Name("Joe","Black"), new Name("Bob", "Von"), new Name("Joe","Tims"));

		System.out.println("\n --- 2. Using mapping(...) to obtain alternate values - output");

		/* --- 2. The mapping collector allows values to be mapped, instead of having to remain as the input elements --- */
		Map<String, List<Name>> uniqueFirstNames1 = names.stream().collect(groupingBy(Name::getFirstName)); //groups names (i.e. Name objects) by their first name
		System.out.println("Map<String>, List<Name> results:\n" + uniqueFirstNames1.toString() + "\n");

		Map<String, List<String>> uniqueFirstNames2 = names.stream().collect(groupingBy(Name::getFirstName, mapping(Name::getFamilyName, toList()))); //groups family name (strings) by their first name
		System.out.println("Map<String>, List<String> results:\n" + uniqueFirstNames2.toString()); //the mapping collector accepts a function and another collector to choose the collection type , e.g. toList, toSet, etc.


		//populate an unmodifiable list of orders for testing
		List<OrderLine> orders = List.of(new OrderLine("Milk", 99, 2), new OrderLine("Cheese", 350, 1), new OrderLine("Bread", 130, 3), new OrderLine("Milk", 99, 1));

		System.out.println("\n --- 3. Using the partitioningBy(...) method - output");

		/* --- 3. Partitioning is a special case of grouping where a map has a key of type boolean - so there can be at most two groups --- */
		Map<Boolean, List<OrderLine>> lessThan3 = orders.stream().collect(partitioningBy(o -> o.getQuantity() < 3)); //partitioningBy accepts a predicate and groups on its result of true or false
		System.out.println("Orders with quantity less than 3: " + lessThan3.get(true));
		System.out.println("Orders with quantity of 3 or more: " + lessThan3.get(false));

		Map<Boolean, Integer> lessThan3cost = orders.stream().collect(partitioningBy(o -> o.getQuantity() < 3, summingInt(OrderLine::getCost))); //a collector can also be provided to reduce the values of each partition into a single value
		System.out.println("Cost of all orders with quantity less than 3: " + lessThan3cost.get(true));
		System.out.println("Cost of all orders with quantity of 3 or more: " + lessThan3cost.get(false));
		
		
	}

}
