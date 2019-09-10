package local.skylerwebdev.orders.repos;

import local.skylerwebdev.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
}
