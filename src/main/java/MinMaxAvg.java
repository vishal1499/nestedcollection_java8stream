import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MinMaxAvg {
    public static void main(String[] args) {
        Integer[] array = {6,2,7,4,1,2,};

        Supplier<Stream<Integer>> sup = () -> Stream.of(array);

        Optional<Integer> opt = sup.get().max(Integer::compareTo);
        System.out.println(!opt.isEmpty() == true ? opt.get() : 0);

        opt = sup.get().min(Integer::compareTo);
        System.out.println(!opt.isEmpty() == true ? opt.get() : 0);

        opt = sup.get().reduce((a,b) -> a*b);
        System.out.println(!opt.isEmpty() == true ? opt.get() : 0);

        OptionalDouble optD = sup.get().mapToDouble(value -> value).average();
        System.out.println(optD.getAsDouble());
        Double dou = optD.isPresent() == true ? Math.round(optD.getAsDouble()) : 0.0;
        System.out.println(dou);


    }
}
