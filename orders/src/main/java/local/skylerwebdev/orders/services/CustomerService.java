package local.skylerwebdev.orders.services;

//NEEDED IMPORTS
import local.skylerwebdev.orders.models.Customer;

import java.util.List;

//SET UP CUSTOMERSERVICE INTERFACE WITH FUNCTIONS FOR SEARCH
public interface CustomerService
{
    List<Customer> findAll();

    Customer findCustomerByName(String name);

    void delete(long id);

    Customer save(Customer customer);

    Customer update(Customer customer, long id);

}
