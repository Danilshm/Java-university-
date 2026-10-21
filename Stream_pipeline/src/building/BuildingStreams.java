package building;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

	public static void main(String[] args) {
		/* This program shows different approaches through which stream pipelines can be built.
		 * Some of these involve creating streams from existing data structures, whilst others focus more
		 * on generating streams from hard coded predefined values, or by using functions.
		 */
		
		System.out.println(" --- 1. collection.stream() - output");
		
		/* --- 1. Streams can be made from any Collection type, i.e. sets or lists using the .stream() method --- */
		Collection<String> c = new HashSet<>();
		//Collection<String> c = new ArrayList<>(); //you can uncomment this and comment line above
		c.add("apple");
		c.add("banana");
		c.add("pear");
		//if you do not wish to run a terminal operation you can store the intermediate result in a variable of type Stream
		Stream<String> strStream = c.stream().filter(s -> s.charAt(0) == 'b');
		strStream.forEach(System.out::println);
		
		
		System.out.println("\n --- 2. Stream.of(...) and IntStream.of(...) - output");
		
		/* --- 2. Streams can be made from values using Stream.of --- */
		strStream = Stream.of("java 8", "is", "fun");
		System.out.println(strStream.collect(Collectors.joining(" ... ")));
		
		//when working with numbers, you can use primitive specialisations, e.g. IntStream.of(...)
		System.out.println("Average of numbers... " + IntStream.of(2,4,6,8,10).average().getAsDouble());
		
		
		System.out.println("\n --- 3. Arrays.stream(...) - output");
		
		/* --- 3. Streams can be made from arrays using Arrays.stream --- */
		int[] nums = {1, 2, 3, 4, 5};
		IntStream numStream = Arrays.stream(nums);
		System.out.println("Sum is " + numStream.sum());
		//Note: Stream<T> is for objects, IntStream, LongStream and DoubleStream 
	    //are for the corresponding primitives. Arrays.stream generates them accordingly.
		String[] strings = {"A", "B", "C", "D", "E"};
		Stream<String> letters = Arrays.stream(strings);
		System.out.println("Number of letters: " + letters.count());
				
		
		System.out.println("\n --- 4. Stream.iterate(...) - output");
		
		/* --- 4. Streams can be made from the iterate function -
		 * an infinite sequential ordered stream can be generated using Stream.iterate --- */
		Stream.iterate(0, x -> x + 4).skip(2).limit(5).forEach(System.out::println);
		//skip will skip numbers 0 and 4, limit then limits the generation to a further 5 numbers in this sequence
		
		System.out.println(); //here takeWhile is used with iterate, it takes values until the predicate becomes false
		Stream.iterate("*", s -> s + "*").takeWhile(s -> s.length() < 5).forEach(System.out::println);
		
		System.out.println(); //iterate can also accept a predicate to become finite - below is similar to: for (int i = 0; i <= 9; i = i + 3)
		Stream.iterate(0, i -> i <= 9, i -> i + 3).forEach(System.out::println);
		
		
		System.out.println("\n --- 5. Stream.generate(...) - output");
		
		/* --- 5. Streams can be made from the generate function -
		 * an infinite sequential unordered stream can be generated using Stream.generate --- */
		DoubleStream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
		
		//NOTE - In approach 5 above Stream. could have been used instead, however DoubleStream was used to avoid autoboxing. 
		//       Conversely approach 4 could have used IntStream to avoid autoboxing.
		
		
		System.out.println("\n --- 6. Stream.empty() - output");
		
		/* --- 6. Empty streams can also be made, which may sometimes be useful in the context of
		 * a method that accepts or returns a stream, and when the data set is indeed empty. */
		strStream = Stream.empty();
		System.out.println("Items in empty stream: " + strStream.count());
		
		
		System.out.println("\n --- 7. string.chars() - output");
		
		/* --- 7. Streams can be made from strings using the .chars() method --- */
		"hello world".chars().forEach(ch -> System.out.println((char) ch)); 
		//chars() returns an IntStream so the values need to be cast to a char if you wish to treat them as characters
		
		
		System.out.println("\n --- 8. string.lines() - output");
		
		/* --- 8. Streams can also be made from strings using the .lines() method -
		 * this produces a stream of strings based on new lines --- */
		"hello world\ngoodbye\nworld".lines().forEach(System.out::println);
		
		
		System.out.println("\n --- 9. random.ints(...) - output");
		
		/* --- 9. Streams of numbers can be made from the the Random class using the .ints(...) generator method  --- */
		var r = new Random();
		IntStream randNums = r.ints(10, 1, 21); //generates 10 random numbers between 1 and 20
		randNums.distinct().sorted().forEach(System.out::println); //ensures numbers are distinct (i.e. no duplicates) and sorted
	
	
		System.out.println("\n --- 10. IntStream.range(...) - output");
		
		/* --- 10. Streams of integers can be made from the range function -
		 * a sequential ordered stream can be generated using IntStream.range --- */
		IntStream.range(1, 10).forEach(i -> System.out.print(i + " ")); //startInclusive to endExclusive with incremental steps of 1, i.e. 1 - 9
		
		
	}

}
