package sets;
import java.util.HashSet;
import java.util.Set;


public class HashSetCollisionsDemo {

	public static void main(String[] args) {
		Set<String> words = new HashSet<>();
		
		/* When a HashSet comes to add an object it firstly
		 * invokes the hashCode() method on that object. Should
		 * the value not exist already in the hash table it adds
		 * the object. If it finds a match, it looks at each element
		 * within that bucket to assess equality. Each object is
		 * compared using == to compare object references. If this
		 * is false it then calls the equals() method to compare
		 * the internal state of the objects; if this is still false
		 * then it adds the object. This is known as a collision -
		 * two different objects that have the same hash code.
		 * Collisions should be avoided where possible with a good
		 * hashCode function.
		 */
		
		words.add("eat"); //new hash code : added
		words.add("tea"); //new hash code : added
		words.add("VII"); //new hash code : added
		words.add("from"); //new hash code : added
		words.add("tea"); //duplicate hash code, same == (due to string literals sharing references) : not added
		words.add("Ugh"); //duplicate hash code as "VII", different ==, different equals() : added (example collision, rare with String)
		words.add(new String("tea")); //duplicate hash code, different == (due to different object references), same equals() (due to same char array) : not added
		
		
		System.out.println(words.toString());
		System.out.println("Size of set : " + words.size());
		
		System.out.println("\nElements and their hash code:");
		//Can use for-each over a HashSet due to it implementing Iterable
		for (String s : words) {
			System.out.println(s + " : hashcode=" + s.hashCode());
		}
		
		/*Out of 7 attempted additions, only 5 were added.
		 * There were 2 genuine duplicates identified and
		 * 1 collision now exists in the HashSet. This is 
		 * not a huge issue, it just reduces efficiency.
		 */
						
	}

}
