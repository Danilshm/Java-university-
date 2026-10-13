package stringcomparator;

import java.util.Comparator;

/* An external top-level class version of the Comparator. 
   Has the benefit of being accessible across multiple classes. */
public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return Integer.compare(s1.length(), s2.length());
	}

}