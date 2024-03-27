package beans;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

    String name;
    String city;
    String id;
    Double salary;
    String department;


}
