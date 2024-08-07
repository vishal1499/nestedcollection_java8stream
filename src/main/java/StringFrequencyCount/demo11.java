package StringFrequencyCount;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo11 {

    public static void main(String[] args) {
        String[] listA={"the", "you" , "how"};
        String[] listB = {"the dog ate the food", "how is the weather" , "how are you"};

        /*Set<String> strset = Stream.of(listB).collect(Collectors.toSet());

        Map<String, Long> frequency1 =
         Stream.of(listB).
                map(a -> a.split("\\s")).
                flatMap(words -> Arrays.stream(words)).
                //distinct().
                 //forEach(System.out::print);
                filter(strset::contains).
                 collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(frequency1);*/

         String input = "gain java knowledge";
         Map<String,Long> countMap = Arrays.
                 stream(input.split("")).
                 collect(
                         Collectors.groupingBy(Function.identity(), Collectors.counting())
                 );
        System.out.println("1: "+countMap);


        String str2 = "Gain java knowledge gain knowledge python";

        System.out.println("2: "+Stream.of(str2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //count  frequency of each string in a string array sentence
        String[] str3 = {"Gain", "java","knowledge","gain","knowledge","python"};
        System.out.println("2.1: "+Arrays.stream(str3).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        //count  frequency of each string in a string list sentence
        List<String> li = Arrays.asList(str3);
        System.out.println("3: "+li.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        System.out.println(li.stream().filter(a -> a.startsWith("k")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        // count frequency of characters in a string sentence
        System.out.println("4: "+li.stream().
                map(s -> Arrays.stream(s.split(""))).
                flatMap(stringStream -> stringStream.sorted()).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

            }


}
