package GroupByPartitionBy;

import beans.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {
        Employee e1 = new Employee("James","Plano","1",2000.0, "IT");
        Employee e2 = new Employee("James1","Plano1","2", 2500.0,"IT");
        Employee e3 = new Employee("James3","Plano","3", 5000.0,"Accounts");
        Employee e4 = new Employee("James4","Plano4","4",1000.0, "Accounts");

        List<Employee> employees = new ArrayList<>();

        employees.add(e1);employees.add(e2);employees.add(e3);employees.add(e4);

        Map<String,List<Employee>> empgroup=  employees.stream().
                collect(Collectors.groupingBy(employee -> employee.getCity()));

        Map<String, Set<Employee>> empmap = employees.stream().collect(Collectors.groupingBy(emp -> emp.getCity(),Collectors.toSet()));

        empgroup.forEach((k,v) -> System.out.println("Key: " + k +", value:" + v));

        Map<Boolean, List<Employee>> partMap =
                employees.parallelStream().collect(Collectors.partitioningBy(employee -> employee.getCity().equals("Plano")));
        System.out.println("===============================================================");
        partMap.forEach((k,v) -> System.out.println("Key: " + k +", value: " + v));
    }




}
