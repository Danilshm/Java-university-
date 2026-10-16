package collection;


import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {

        Collection<String> c = new ArrayList<String>();
        //try other collections LinkedList<String>(); TreeSet<String>(); HashSet<String>(); 
        
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add("six");
        c.add("seven");
        c.add("eight");
        c.add("nine");
        c.add("three"); //try a duplicate
        c.add("ten");

        System.out.println("======Output using toString()=============");
        System.out.println(c.toString());
        System.out.println("size=" + c.size());

        System.out.println("======Output using for-each loop=============");
        for (String s : c) { //for each string in the collection
            System.out.println(s);
        }
        
        System.out.println("======Output using forEach method=============");
        c.forEach(System.out::println);
        
        System.out.println("======Output using Iterator=============");
        
        Iterator<String> iter = c.iterator();
        while (iter.hasNext()) {
            String str = iter.next(); 
            System.out.println(str);
        }
        System.out.println("=======Remove six===========");
        
        c.remove("six");
        System.out.println(c);

        if (c.contains("six")) {
            System.out.println("six is in the collection");
        } else {
            System.out.println("six is NOT in the collection");
        }

        //try other methods
        
    }
}
