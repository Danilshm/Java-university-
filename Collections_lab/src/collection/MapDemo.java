package collection;


import java.util.*;

public class MapDemo {
	public static void main (String[] arg) {
		Map<String, String> hmap = new HashMap<String, String>(); 
		//or new TreeMap<String, String>();

		//populate the table
		hmap.put("fred", "1255");
		hmap.put("mary", "7864");
		hmap.put("ali",  "2897");
		hmap.put("nina", "1255");
		//....add more....
		System.out.println(hmap);	//list the elements

		//...try out other methods...
		String ext = hmap.get("ali");
		System.out.println("Ali's extension is " + ext);

		hmap.remove("ali");		//remove ali's entry

		//use the key to retrieve a value
        if (hmap.containsKey("ali"))
			System.out.println("ali is in the map");

        
        //process each value
        System.out.println("======Access data using values()=============");
        for (String extn : hmap.values()) {
            System.out.println(extn);
        }
        
        //process each key
        System.out.println("======Access data using keySet()=============");
        for (String name : hmap.keySet()) {
            System.out.println(name + "-->" + hmap.get(name)); //retrieve element for name
        }
        
        //as of Java 8, you can now use the Map interface's forEach method to access each key-value pairing using a lambda expression
        System.out.println("======Access each entry=============");
        hmap.forEach((k,v) -> System.out.println(k + "-->" + v));

	}
}



