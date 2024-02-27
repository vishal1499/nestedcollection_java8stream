package ArrayMultiplicationUsingStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AMUS {

    public static void main(String[] args) {
        Integer[] inputArray = {1,2,3,4,5};

        List<Integer> arrayList = Arrays.asList(inputArray);
        Optional<Integer> intVal = arrayList.stream().reduce((a, b) -> a*b);
        if(intVal.isPresent()) {
            System.out.println(intVal.get());
        }else{
            System.out.println("no val" +
                    "");
        }


    }
}
