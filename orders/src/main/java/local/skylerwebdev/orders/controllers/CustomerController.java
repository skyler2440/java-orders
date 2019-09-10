package local.skylerwebdev.orders.controllers;

//IMPORT PACKAGES
import local.skylerwebdev.orders.models.Customer;
import local.skylerwebdev.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//SET MAPPING
@RestController
@RequestMapping("/data/customers")
@Component
public class CustomerController
{
    //PULL IN BEANS FROM CUSTOMERSERVICE
    @Autowired
    private CustomerService customerService;

    //127.0.0.1:2019/data/customers/orders -- List all customers with their orders...
    @GetMapping(value = "/orders",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    //127.0.0.1/data/customers/{name} -- List customer when name is searched
    @GetMapping(value = "/{name}",
                produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable String name)
    {
        Customer c = customerService.findCustomerByName(name);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    //127.0.0.1:2019/data/customers/new -- Adds a new customer
    @PostMapping(value = "/new")
    public ResponseEntity<?> saveCustomer(
            @Valid @RequestBody Customer newCustomer)
    {
        newCustomer = customerService.save(newCustomer);
        //SETS UP RESPONSE HEADER TO RETURN ID OF CUSTOMER CREATED
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //127.0.0.1:2019/data/customers/{custcode} -- updates customer but does not update order
    @PutMapping(value = "/{custcode}")
    public ResponseEntity<?> updateCustomer(
            @RequestBody
                    Customer updateCustomer,
            @PathVariable long custcode)
    {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //127.0.0.1:2019/data/customers/{custcode} -- deletes customer and orders
        @DeleteMapping("/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

