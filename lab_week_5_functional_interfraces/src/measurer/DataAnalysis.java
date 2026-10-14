package measurer;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;


public class DataAnalysis {

	public static <E> int sum (List<E> objects, Measurer<E> m) {
		return objects.stream().mapToInt(obj -> m.measure(obj)).sum();
	}

	public static <E> double avg (List<E> objects, Measurer<E> m) {
		return objects.stream().mapToInt(m::measure).average().orElse(0); //m::measure equivalent to obj -> m.measure(obj)
	}

	public static <E> Optional<E> maxObject(List<E> objects, Measurer<E> m) {
		return objects.stream().max(Comparator.comparing(m::measure));
	}

	public static <E> int maxValue(List<E> objects, Measurer<E> m) {
		return objects.stream().mapToInt(m::measure).max().orElse(0);
	}

}
