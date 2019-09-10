package local.skylerwebdev.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;
    private double advanceamt;
    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private String orddescription;

    public Order(double ordamount, double advanceamt, String orddescription)
    {
        this.ordamount = ordamount;
        this.advanceamt = advanceamt;
        this.orddescription = orddescription;
    }

    public Order(double ordamount)
    {
        this.ordamount = ordamount;
    }

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
        return advanceamt;
    }

    public void setAdvanceamt(double advanceamt)
    {
        this.advanceamt = advanceamt;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }
}
