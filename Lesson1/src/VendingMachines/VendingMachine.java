package VendingMachines;

import Products.Product;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private int volume;
    private List<Product> products;// = new ArrayList<Product>();
    private List<String> workLog;// = new ArrayList<String>();
    private Double money;

    public VendingMachine(int volume){
        this.volume = volume;
        products = new ArrayList<Product>();
        workLog = new ArrayList<String>();
    }

    public VendingMachine() {
    }

    public void addProduct(Product prod)
    {
        products.add(prod);
    }

    public void addSales(String line)
    {
        workLog.add(line);
    }

    public Product getProdByName(String name)
    {
        for(Product prod: products)
        {
            if(prod.getName().contains(name))
            {
                return prod;
            }
        }
        return null;
    }

    public List<Product> getProdAll()
    {
        return products;
    }
    public String buy(Product product, Double money) {
        if(money >= product.getPrice()) {
            Double change = money - product.getPrice();
            money = 0.0;
            return "Продукт: " + product.getName() + ". Сдача: " + change;
        }
        else{
            return "Недостаточно денег для покупки";
        }
    }

}
