package mapflatMapPOc;

import java.util.List;

public class Customers {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customers customers1)) return false;

        return getCustomers() != null ? getCustomers().equals(customers1.getCustomers()) : customers1.getCustomers() == null;
    }

    @Override
    public int hashCode() {
        return getCustomers() != null ? getCustomers().hashCode() : 0;
    }
}
