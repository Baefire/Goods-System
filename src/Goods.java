import java.io.Serializable;

public class Goods implements Serializable {
    private final String number;
    private String name;
    private float price,stocks;
    public Goods(String number, String name,float price,float stocks)
    {
        super();
        this.number = number;
        this.name = name;
        this.price = price;
        this.stocks = stocks;
    }

    public String getnum() {return number;}
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public float getprice()
    {
        return price;
    }
    public void setprice(float price)
    {
        this.price = price;
    }
    public float getstocks()
    {
        return stocks;
    }
    public void setstocks(float stocks)
    {
        this.stocks = stocks;
    }
}
