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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (!getName().equals(employee.getName())) return false;
        if (getCity() != null ? !getCity().equals(employee.getCity()) : employee.getCity() != null) return false;
        return getId().equals(employee.getId());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + getId().hashCode();
        return result;
    }
}
