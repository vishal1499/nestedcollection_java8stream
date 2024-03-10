package FunctionalInterfacePOC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConsumerSupplierPredicatePOC {

    public static void main(String[] args) {
        //Consumer
        Consumer<Integer> consumer = a -> System.out.println(a);
        consumer.accept(2);

        List<Integer> list = Arrays.asList(new Integer[]{122, 22, 63, 24, 45, 5, 3, 2, 1, 8, 3, 5, 9});

        Stream<Integer> intstream = list.stream();
        intstream.forEach(a -> System.out.print(a+","));

        //This will land-up in error//intstream.forEach(a -> System.out.println(a));

        //Supplier
        Supplier<Stream<List<Integer>>> supInputStream = () -> Stream.of(list);
        //Stream<List<Integer>> stream = supInputStream.get();

        supInputStream.get().forEach(a -> System.out.println(a));

        supInputStream.get().forEach(b -> System.out.println(b));

        //Predicate
        Predicate<Integer> pred = a ->  {
                                           if(a%2 ==0)
                                            return true;
                                           else return false;
                                        };

        System.out.println(pred.test(3));

    }
}
