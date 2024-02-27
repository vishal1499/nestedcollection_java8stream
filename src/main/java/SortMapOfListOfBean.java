import beans.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortMapOfListOfBean {

    public static void main(String[] args) {
         List<Employee> employees = Arrays.asList(new Employee("Amit","Dallas","1"),
                 new Employee("Alex","Dallas","2"),
                 new Employee("Mike","McKenniy","3"),
                 new Employee("Bob","Allen","4"),
                 new Employee("Zion","Frisco","5")
         ) ;

        List<Employee> employees1 = Arrays.asList(new Employee("Hmit","London","1"),
                new Employee("Kalex","NewYork","2"),
                new Employee("Mikke","McKenniy","3"),
                new Employee("Boab","Allen","4"),
                new Employee("Lion","Spring Creek","5")
        ) ;

        List<Employee> employees2 = Arrays.asList(new Employee("Smith","Denevar","1"),
                new Employee("yapex","New Jersy","2"),
                new Employee("Dikle","McKenniy","3"),
                new Employee("Load","Allen","4"),
                new Employee("Oion","Spring Creek","5")
        ) ;

        System.out.println(employees);

        Map<String, List<Employee>> empMaps = new HashMap<>();
        empMaps.put("Vice President", employees1);
        empMaps.put("Marketing", employees);
        empMaps.put("Director", employees2);
        System.out.println("1======");
        System.out.println(empMaps);

        Iterator<Map.Entry<String, List<Employee>>> it = empMaps.entrySet().iterator();
        Map<String, List<Employee>> newSortedMap = new HashMap<>();

        while(it.hasNext()){
            Map.Entry<String,List<Employee>> entry = it.next();
            String key = entry.getKey();
            List<Employee> list = entry.getValue();

            list.stream().sorted(
                    Comparator.comparing(Employee::getCity).
                            thenComparing(Employee::getName)).collect(Collectors.toList());
            newSortedMap.put(key,list);
        }

        System.out.println("2======");
        System.out.println(newSortedMap);

        Map<String,List<Employee>> sortedMap = newSortedMap.entrySet().stream().sorted(
                Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("3======");
        System.out.println(sortedMap);


    }
}
