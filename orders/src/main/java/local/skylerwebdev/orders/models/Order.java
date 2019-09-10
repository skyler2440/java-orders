package local.skylerwebdev.orders.models;

// NEEDED IMPORTS
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//NAME SQL TABLE
@Entity
@Table (name = "orders")
public class Order
{
    //SET ID AND AUTO GENERATE SET OTHER FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orddescription;

    //MANY TO ONE TO JOIN CUSTOMER ID
    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    // SET CONSTRUCTOR TO EDIT FIELDS
    public Order(double ordamount, double advanceamount, Customer customer, String orddescription )
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescription = orddescription;
        this.customer = customer;
    }

    //SET DEFAULT CONSTRUCTOR
    public Order()
    {
    }

    //GETTERS AND SETTERS
    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamt()
    {
        return advanceamount;
    }

    public void setAdvanceamt(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
