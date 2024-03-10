package Java8CodingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculateAverageOfAListOfIntegers {
    // Write a Java program to calculate the average of a list of integers using streams.

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,32,43,6,1,3,43,2);
        Double dVal = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println(dVal);

        Supplier<Stream<Integer>> sup = () -> list.stream();

        double[] dbar = sup.get().mapMultiToDouble((integer, doubleConsumer) ->{
               if(integer % 2 == 0){
                   System.out.println("sel: " + integer);
                   doubleConsumer.accept((double)  integer * 2);
               }
                } ).toArray();

        Arrays.stream(dbar).forEach(System.out::println);

        System.out.println("===================");
        System.out.println(list.stream().map(a -> a+2).anyMatch(a -> {
            if(a%2 == 0){
                return true;
            }else{
                return false;
            }
        }));


        List<String> list1 = Arrays.asList("vishal", "amit","bob");

        List<StringBuffer> buf = list1.stream().map(StringBuffer::new).collect(Collectors.toList());
        buf.addFirst(new StringBuffer("Mike"));
        buf.stream().forEach(System.out::println);

        System.out.println(list1.stream().map(String::toUpperCase).sorted(String::compareTo).collect(Collectors.toList()));

        System.out.println("************");
        System.out.println(list1.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println("-----------");
        System.out.println(list1.stream().map(String::toLowerCase).sorted(Comparator.naturalOrder()).collect(Collectors.toList()));


        List<Double> list2 = Arrays.asList(4.2,5.1,6.7,6.7,2.1,7.2,8.8,4.2,9.3,2.1,1.4);

        //round of to nearest int and increase by 1 and do sum
        list2.stream().mapToInt(Double::intValue).filter(a -> a%2==0).sum();

        System.out.println(list2.stream().distinct().collect(Collectors.toList()));


        List<String> strList = Arrays.asList("one" , "Apple", "dog," , "baby", "Ample");

        System.out.println(strList.stream().filter(a -> a.toLowerCase().startsWith("a")).count());

    }


}
