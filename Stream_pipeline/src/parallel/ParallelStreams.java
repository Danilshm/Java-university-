package parallel;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class ParallelStreams {

	public static void main(String[] args) {
		/* This program illustrates the ease of creating parallel streams - a stream partitioned into multiple substreams by the Java runtime.
		 * You can either invoke collection.parallelStream() or convert a sequential stream using .parallel().
		 * Whilst all stream operations can execute either in serial or parallel, some operate more efficiently in parallel due to their
		 * characteristics. Notably, if the operation has no concern over ordering and/or the user does not need to conserve ordering, then each
		 * substream can work independently.
		 * During this program you will see some operations that lend themselves to parallelism, and those specifically designed for concurrency.
		 *
		 * It is also worth noting that in practice the decision on whether to use a parallel stream also depends on the size of the input
		 * dataset, as for small amounts of data, the overhead of coordinating threads, outweighs the time gain.
		 */

		//populate an unmodifiable list of strings for testing
		List<String> fruits = List.of("Pineapple", "Kiwi", "Apple", "Banana", "Watermelon", "Grape", "Orange");

		System.out.println(" --- 1. Using parallelStream() or parallel() - output");

		/* --- 1. Parallel streams can be made via collection.parralelStream() or stream.parallel()  --- */
		fruits.parallelStream().map(String::toUpperCase).forEachOrdered(System.out::println);
		//note the output here - forEachOrdered(...) above maintains the encounter order of the stream whereas
		//forEach(...) below runs in parallel and has no concern over the encounter order
		System.out.println("");
		IntStream.range(0, 20).parallel().filter(i -> i%2 == 0).forEach(System.out::println);
		//map(...) and filter(...) can both be ran in parallel and will merge substreams together when finished


		System.out.println("\n --- 2. Using anyMatch, allMatch and noneMatch in parallel - output");

		/* --- 2. findAny, anyMatch, allMatch and noneMatch can benefit from parallelism  --- */
		String fruit = fruits.parallelStream().filter(s -> s.length() > 4).findAny().orElse("Not found");
		System.out.println("Fruit with length greater than 4? " + fruit);
		//findAny can return a result found by any one of the substreams
		boolean any = new Random().ints(50, 1, 100).parallel().anyMatch(i -> i == 60);
		System.out.println("Any match to 60 from random numbers? " + any);
		//anyMatch can return a result that matches from any one of the substreams
		boolean all = fruits.parallelStream().allMatch(s -> s.contains("a"));
		System.out.println("Do all fruits contain 'a'? " + all);
		//allMatch and noneMatch can process substreams independently and combine their results
		boolean none = fruits.stream().parallel().noneMatch(s -> s.contains("z"));
		System.out.println("Do no fruits contain 'z'? " + none);
		//for the above 3 operations, threads associated with each substream periodically check the
		//result of other threads, so when a result is determined, they can stop. As an example, if
		//one thread identifies a match when running noneMatch, then a result of false can be returned
		//without having to process the remaining data.


		System.out.println("\n --- 3. Using distinct() in parallel (ordered and unordered) - output");

		/* --- 3. distinct() may benefit from parallelism when the stream is flagged as being unordered --- */
		IntStream s1 = IntStream.range(1, 11);
		IntStream s2 = IntStream.range(1, 11); //create two streams of numbers 1 .. 10, then merge them with concat, and collect to a list
		List<Integer> combined = IntStream.concat(s1, s2).boxed().collect(Collectors.toList()); //list will hold sequence 1, 2 .. 10, 1, 2 .. 10

		System.out.println("Distinct with ordering retained...");
		//if we run distinct in parallel with an ordered stream (noting a list is an ordered source), the original ordering will remain (i.e. 1 .. 10),
		//but the performance will suffer (as a thread cannot discard an element until the preceding thread has finished)
		combined.parallelStream().distinct().forEachOrdered(x -> System.out.print(x + " "));

		System.out.println("\n\nDistinct with ordering not necessarily retained... (may need to run several times)");
		//doing the same on an unordered stream will not necessarily retain 1 .. 10. Unique elements are still kept, but not necessarily the first occurrence
		combined.parallelStream().unordered().distinct().forEachOrdered(x -> System.out.print(x + " "));
		//we used forEachOrdered in both examples above to print the elements as forEach would run in parallel and not show the actual ordering in the stream after executing the distinct operation


		System.out.println("\n\n --- 4. Using limit in parallel (ordered and unordered) - output");

		/* --- 4. limit may benefit from parallelism when the stream is flagged as being unordered --- */
		int[] numbers = IntStream.range(1, 1000).toArray(); //convenient way to create an array of numbers 1 - 999

		System.out.println("Limit with ordering retained...");
		//if we run limit in parallel with an ordered stream, then you get the first 10 even numbers
		Arrays.stream(numbers).parallel().filter(x -> x % 2 == 0).limit(10).forEachOrdered(x -> System.out.print(x + " "));

		System.out.println("\n\nLimit with ordering not necessarily retained... (may need to run several times)");
		//doing the same on an unordered stream will limit the stream to any 10 even numbers
		Arrays.stream(numbers).parallel().filter(x -> x % 2 == 0).unordered().limit(10).forEachOrdered(x -> System.out.print(x + " "));
		//if filter is removed in the above examples then the first 10 numbers are always returned as for SIZED sources, such as an array, the limit operation is optimised to run at
		//the same speed for both ordered and unordered streams. Running a filter causes this characteristic to be removed, and shows the potential benefit of parallel unordered streams.


		System.out.println("\n\n --- 5. Using toConcurrentMap and groupingByConcurrent in parallel - output");

		/* --- 5. toConcurrentMap and groupingByConcurrent should be used when working with parallel streams --- */
		ConcurrentMap<Integer, String> cmKeyValue = fruits.parallelStream().collect(Collectors.toConcurrentMap(String::length, s -> s, (a, b) -> a + "_" + b));
		System.out.println("Map integer keys to merged string values: " + cmKeyValue);
		//when working with parallel streams, if you use the serial counterparts of toMap and groupingBy then it has to merge maps, which is computationally expensive.
		//by using toMapConcurrent and groupingByConcurrent you ensure a single concurrent map is used for the parallel collection process, but you sacrifice ordering
		ConcurrentMap<Integer, List<String>> cmKeyListValues = fruits.parallelStream().collect(Collectors.groupingByConcurrent(String::length));
		System.out.println("\nMap integer keys to lists of string values: " + cmKeyListValues);


	}

}
