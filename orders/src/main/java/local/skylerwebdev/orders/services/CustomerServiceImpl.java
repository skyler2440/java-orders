package local.skylerwebdev.orders.services;

import local.skylerwebdev.orders.models.Agent;
import local.skylerwebdev.orders.models.Customer;
import local.skylerwebdev.orders.models.Order;
import local.skylerwebdev.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAll()
    {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id)
    {
        return null;
    }

    @Override
    public Customer findCustomerByName(String name)
    {
        Customer currentCustomer = custrepos.findByCustname(name);
        if(currentCustomer != null)
        {
            return currentCustomer;
        }else
        {
            throw new EntityNotFoundException(name);
        }
    }

    @Override
    @Transactional
    public void delete(long id)
    {
    if(custrepos.findById(id).isPresent())
    {
        custrepos.deleteById(id);
    } else
    {
        throw new EntityNotFoundException(Long.toString(id));
    }
    }

    @Override
    @Transactional
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        for(Order o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamt(), o.getOrddescription(), newCustomer));
        }
        newCustomer.setAgent(customer.getAgent());

        return custrepos.save(newCustomer);
    }

    @Override
    @Transactional
    public Customer update(Customer customer, long id)
    {
        Customer currentCustomer = custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (customer.getCustname() != null)
        {
            currentCustomer.setCustname(customer.getCustname());
        }
        if (customer.getCustcity() != null)
        {
            currentCustomer.setCustcity(customer.getCustcity());
        }
        if (customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if (customer.getCustcountry() != null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }
        if (customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }
        if (customer.getOpeningamt() > 0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getReceiveamt() > 0)
        {
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if (customer.getPaymentamt() > 0)
        {
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if (customer.getPhone() != null)
        {
            currentCustomer.setPhone(customer.getPhone());
        }
        return custrepos.save(currentCustomer);
    }
}
