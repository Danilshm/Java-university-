package maps;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class HashMapCollisionsDemo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		/* When a HashMap comes to put in a new mapping it firstly
		 * invokes the hashCode() method on the key. Should
		 * it not exist already in the hash table it adds
		 * the mapping. If it finds a match, it compares the two
		 * keys for equality, if true it simply updates the value
		 * and returns the old value associated with that key.
		 * If the keys are not equal, this is known as a collision -
		 * two different objects that have the same hash code.
		 * In this case, it adds the mapping, however, both keys
		 * exist in the same bucket. The bucket is found via the hashCode().
		 * When a bucket contains more than one key, it holds them in a LinkedList.
		 * Therefore, the worst case scenario of every key having the same hash code
		 * is a LinkedList representation for adding and getting values.
		 * Collisions should therefore be avoided where possible with a good
		 * hashCode function.
		 */
		
	    map.put("eat", 1); //new key hash code : added
		map.put("tea", 2); //new key hash code : added
		map.put("VII", 3); //new key hash code : added
		map.put("from", 4); //new key hash code : added
		map.put("tea", 5); //duplicate key hash code : value updated
		map.put("Ugh", 6); //duplicate key hash code as "VII", not equal : added
		map.put(new String("tea"), 7); //duplicate key hash code : value updated
		
		
		/* It's possible to iterate over each key in a Map.
		 * In doing so you can process the keys and also use
		 * each key to get the associated value from the map.
		 * See below:
		 */
		/*for (String s : map.keySet()) {
			System.out.println("key:" + s + ", value:" + map.get(s) + ", hash code=" + s.hashCode());
		}*/
		
		/* Better still, as of Java 8, you can now use the forEach method to access each key-value pairing using a lambda expression. */
		map.forEach((k,v) -> System.out.println("key:" + k + ", value:" + v + ", hash code=" + k.hashCode()));
		
		
		/*If the put method does not find a matching key hash code it 
		 * knows it can safely add the new mapping, and returns null.
		 *If it finds a matching hash code, it tests the keys equality,
		 *should they be equal it replaces the value associated with
		 *that key and returns the old value held.
		 *
		 *In the example below, 22 replaces 7, which is returned into x.
		 */
		int x = map.put("tea", 22);
		System.out.println("x = " + x + ", Key 'tea' maps to value " + map.get("tea"));

		
		/* When getting a value, the hash code of the key
		 * is computed to find the associated bucket. Should
		 * there be more than one key in this bucket, it
		 * uses the equals method to find the correct one.
		 * 
		 * The two method calls below both locate the same
		 * bucket due to the identical hash codes of the
		 * two strings, but then determines the correct value
		 * based upon a call to equals().
		 */
		System.out.println(map.get("Ugh"));
		System.out.println(map.get("VII"));
		
		
	}

}
