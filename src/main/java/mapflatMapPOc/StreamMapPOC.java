package mapflatMapPOc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapPOC {


    public static void main(String[] args) {
        Integer[] array = {11,45,8,9,3,7,22,34};

        System.out.println(Stream.of(array).max(Integer::compareTo).get());

        List<Integer> list = Arrays.asList(array);

        System.out.println(list.stream().map(a -> a+1).collect(Collectors.toList()));

        System.out.println(list.stream().map(a-> a*a).collect(Collectors.toList()));

        AtomicInteger val = new AtomicInteger(1);
        System.out.println(val.incrementAndGet());
    }
}
