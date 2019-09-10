package local.skylerwebdev.orders.services;

import local.skylerwebdev.orders.models.Order;

import java.util.List;

public interface OrderService
{
    List<Order> findAll();

    Order findOrderById(long id);

    Order findOrderByName(String name);

    void delete(long id);

    Order save(Order order);

    Order update(Order order, long id);
}
