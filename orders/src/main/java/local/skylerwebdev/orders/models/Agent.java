package local.skylerwebdev.orders.models;

// NEEDED IMPORTS
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//NAME SQL TABLE
@Entity
@Table(name ="agents")
public class Agent
{
    //SET ID AND AUTO GENERATE SET OTHER FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;
    // ONE TO MANY RELATION PULLS IN CUSTOMER LIST
    @OneToMany(mappedBy = "agent",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties("agents")
    private List<Customer> customers = new ArrayList<>();

    // SET CONSTRUCTOR TO EDIT FIELDS
    public Agent(String agentname, String workingarea, double commission, String phone, String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    //SET DEFAULT CONSTRUCTOR
    public Agent()
    {
    }

    //GETTERS AND SETTERS
    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getAgentname()
    {
        return agentname;
    }

    public void setAgentname(String agentname)
    {
        this.agentname = agentname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }
}
