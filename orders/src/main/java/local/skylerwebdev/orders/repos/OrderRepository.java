package local.skylerwebdev.orders.repos;

import local.skylerwebdev.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
}
