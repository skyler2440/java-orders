package local.skylerwebdev.orders.controllers;

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

@RestController
@RequestMapping("/data/customers")
@Component
public class CustomerController
{
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

    //127.0.0.1:2019/data/customers/new
    @PostMapping(value = "/new")
    public ResponseEntity<?> saveCustomer(
            @Valid @RequestBody Customer newCustomer)
    {
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}

