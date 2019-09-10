package local.skylerwebdev.orders.repos;

//NEEDED IMPORTS
import local.skylerwebdev.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

//SET UP INTERFACE FOR CRUD REPO
public interface CustomersRepository extends CrudRepository<Customer, Long>
{
    //JPA TO SEARCH CUSTOMER BY NAME
    Customer findByCustname (String custname);
}
