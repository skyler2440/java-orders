package local.skylerwebdev.orders.repos;

import local.skylerwebdev.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long>
{

}
