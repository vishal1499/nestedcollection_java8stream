import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

public class MulitplePrograms {
    public static void main(String[] args) {

        FindMaxSalaryOfEmployeeByDepartment();

        createADateObjectUsingCalendarClass();

    }

    private static void createADateObjectUsingCalendarClass() {
            //Calendar.getInstance()
    }

    private static void FindMaxSalaryOfEmployeeByDepartment() {
        Empl e1 = new Empl("James","Plano","1",2000.0, "IT");
        Empl e2 = new Empl("James1","Plano1","2", 2500.0,"IT");
        Empl e3 = new Empl("James3","Plano","3", 5000.0,"Accounts");
        Empl e4 = new Empl("James4","Plano4","4",1000.0, "Accounts");
        Empl e5 = new Empl("James5","Plano4","3", 5000.0,"HR");
        Empl e6 = new Empl("James6","Plano1","4",10000.0, "HR");

        List<Empl> list = Arrays.asList(e1,e2,e3,e4,e5,e6);

        Map<String, Double> finalMap = new HashMap<>();

        Map<String, Double> finalMap1 = finalMap;
        list.stream().collect(Collectors.groupingBy(Empl::getDepartment)).forEach((key, val) -> {
            val.sort(Comparator.comparing(Empl::getSalary));
            finalMap1.put(key,val.getLast().getSalary());
        });
        System.out.println("finalMap2: " + finalMap1);

        finalMap = list.stream().collect(
                Collectors.groupingBy(Empl::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Empl::getSalary)), emp->emp.get().getSalary())));

        System.out.println("finalMap3: " +finalMap);
        finalMap.put("asa",2.8);
        System.out.println("finalMap4: " +finalMap);
        System.out.println("finalMap5: " + finalMap1);


    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Empl {
    String name;
    String city;
    String id;
    Double salary;
    String department;
}