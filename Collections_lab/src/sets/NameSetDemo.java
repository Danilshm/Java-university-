package sets;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class NameSetDemo {

	public static void main(String[] args) {
		//A unique set of names.
		Set<Name> names = new HashSet<>();
				
		names.add(new Name("Wayne", "Rooney")); 
		names.add(new Name("Luis", "Suarez")); 
		names.add(new Name("Wayne", "Rooney")); 
		names.add(new Name("Robin", "Persie")); 


		System.out.println(names.toString());
		
		System.out.println("Size of set: " + names.size());
		
		System.out.println("\nNames in set and their hash code...");
		for (Name n : names) {
			System.out.println(n.getFullName() + " : hashcode=" + n.hashCode());
		}

	}

}
