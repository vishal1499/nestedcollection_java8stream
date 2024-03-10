import java.util.Comparator;
import java.util.stream.Stream;

public class FindTheSecondSmallestAndLargestElements {

    public static void main(String[] args) {
        Integer[] arr = {6,3,5,7,3,5,};

        //find second smallest value
        Integer ssval = Stream.of(arr).distinct().sorted().skip(1).findFirst().orElse(null);

        Integer slval = Stream.of(arr).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);

        System.out.println(ssval);
        System.out.println(slval);

    }
}
