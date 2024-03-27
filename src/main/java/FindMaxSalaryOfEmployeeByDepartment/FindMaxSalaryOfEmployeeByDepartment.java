package FindMaxSalaryOfEmployeeByDepartment;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaxSalaryOfEmployeeByDepartment {

    public static void main(String[] args) {

        Empl e1 = new Empl("James","Plano","1",2000.0, "IT");
        Empl e2 = new Empl("James1","Plano1","2", 2500.0,"IT");
        Empl e3 = new Empl("James3","Plano","3", 5000.0,"Accounts");
        Empl e4 = new Empl("James4","Plano4","4",1000.0, "Accounts");
        Empl e5 = new Empl("James5","Plano4","3", 5000.0,"HR");
        Empl e6 = new Empl("James6","Plano1","4",10000.0, "HR");

        List<Empl> list =  Arrays.asList(e1,e2,e3,e4,e5,e6);

        Map<String,Double> finalMap = new HashMap<>();

        list.stream().collect(Collectors.groupingBy(Empl::getDepartment)).
                forEach((key, val) -> {
            val.sort(Comparator.comparing(Empl::getSalary).reversed());
                    finalMap.put(key, val.getFirst().salary);
                    //System.out.println(key +": "+ val.getFirst().salary);
        });
        System.out.println(finalMap);
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
