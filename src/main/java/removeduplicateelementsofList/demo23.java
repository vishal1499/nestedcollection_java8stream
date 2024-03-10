package removeduplicateelementsofList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo23 {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("my", "name" ,"is","my","name","vim");

        li.stream().distinct().collect(Collectors.toList()).forEach(System.out::print);

    }
}
