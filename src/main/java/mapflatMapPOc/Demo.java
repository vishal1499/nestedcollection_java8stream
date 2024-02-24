package mapflatMapPOc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {

       Customers customers = new Customers();
       List<Customer> customerList = new ArrayList<>();
       customerList.add(getCustomer1());
       customerList.add(getCustomer2());
       customers.setCustomers(customerList);

       //find all customers having USA address.


        customers.getCustomers().stream().//Stream of List<Customer>
                map(Customer::getAddresses).//get Stream of List<Map<String, String>> Address
                flatMap(Collection::stream).//get Stream of flattend Map
                filter(map -> map.get("country").equalsIgnoreCase("INDIA")).forEach(a -> {a.putAll(new HashMap<>());
            System.out.println(a);});



       //find all customers having home town in INDIA

        // sort all customers by phone couriers
    }

    private static Customer getCustomer1() {
        List<Map<String,String>> addresses = new ArrayList<>();
        List<Map<String,String>> phoneNumbers = new ArrayList<>();
        Map<String, String> address;
        Map<String, String> phone;
        Customer cust = new Customer();
        cust.setId(1);
        cust.setName("Sandeep");

        address = getAddressMap("Kanpur","UP","vasant kunj","219823","N-34","home town", "INDIA");
        addresses.add(address);
        address = getAddressMap("Dallas","Texas","Panthers Ave","75078","800","oversees", "USA");
        addresses.add(address);
        cust.setAddresses(addresses);

        phone = getPhoneDetails("9443392055","cell","ATT");
        phoneNumbers.add(phone);
        phone = getPhoneDetails("9723555055","cell","TMobile");
        phoneNumbers.add(phone);

        cust.setAddresses(addresses);
        cust.setPhoneDetails(phoneNumbers);
        return cust;
    }

    private static Customer getCustomer2() {
        List<Map<String,String>> addresses = new ArrayList<>();
        List<Map<String,String>> phoneNumbers = new ArrayList<>();
        Map<String, String> address;
        Map<String, String> phone;
        Customer cust = new Customer();
        cust.setId(2);
        cust.setName("Jack Dorsy");

        address = getAddressMap("Manhattan","NY","West 42nd Street","10036","Sute#400","office", "USA");
        addresses.add(address);
        address = getAddressMap("Mckenniy","Texas","Goal ave","75074","800","home town", "USA");
        addresses.add(address);
        cust.setAddresses(addresses);

        phone = getPhoneDetails("9443398755","phone","Verizon");
        phoneNumbers.add(phone);
        phone = getPhoneDetails("9723550055","cell","Verizon");
        phoneNumbers.add(phone);

        cust.setAddresses(addresses);
        cust.setPhoneDetails(phoneNumbers);
        return cust;
    }
    private static Map<String, String> getPhoneDetails(String number, String type, String courier) {
        Map<String, String> phone = new HashMap<>();
        phone.put("number", "9723392055");
        phone.put("type", "cell");
        phone.put("courier", "T-Mobile");
        return phone;
    }

    private static Map<String, String> getAddressMap(String city, String state, String street, String zip, String HNO, String type, String country) {
        Map<String, String> address = new HashMap<>();
        address.put("city", city);
        address.put("state", state);
        address.put("street", street);
        address.put("zip", zip);
        address.put("H.NO.", HNO);
        address.put("type", type);
        address.put("country" , country);
        return address;
    }
}