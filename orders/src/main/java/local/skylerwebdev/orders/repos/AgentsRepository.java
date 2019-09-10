package local.skylerwebdev.orders.repos;

import local.skylerwebdev.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long>
{
}
