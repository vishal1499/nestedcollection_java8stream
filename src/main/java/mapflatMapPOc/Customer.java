package mapflatMapPOc;

import java.util.List;
import java.util.Map;

public class Customer {

    int id;
    String name;
    List<Map<String, String>> addresses ;

    List<Map<String, String>> phoneDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, String>> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Map<String, String>> addresses) {
        this.addresses = addresses;
    }

    public List<Map<String, String>> getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(List<Map<String, String>> phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;

        if (getId() != customer.getId()) return false;
        if (!getName().equals(customer.getName())) return false;
        if (!getAddresses().equals(customer.getAddresses())) return false;
        return getPhoneDetails().equals(customer.getPhoneDetails());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAddresses().hashCode();
        result = 31 * result + getPhoneDetails().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "mapflatMapPOc.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneDetails +
                '}';
    }
}
