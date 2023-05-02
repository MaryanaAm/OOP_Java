package Products;


/**
 * класс Горячих напитков
 * @author Maryana Amshokova
 * @version
 */
public class HotDrink extends Product{

    /** температура продукта */
    private int temperature;
    private int volume;

    /**
     * конструктор горячих напитков
     * @param name наименование продукта
     * @param price цена продукта
     * @param volume объем продукта
     * @param temperature температура продукта
     */
    public HotDrink(String name, double price, int volume, int temperature){
        super(name, price);
        this.volume = volume;
        if((temperature >= 50) || (temperature <=0)){
            throw new IllegalStateException(String.format("Температура указана некорректно!", temperature));
        }
        else
        {
            this.temperature = temperature;
        }
    }

    /** получаем температуру продукта */
    public int getTemperature() {
        return temperature;
    }

    /** устанавливаем температуру продукта */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * переопределение вывода продукта
     */
    @Override
    public String toString()
    {
        return  "Product{" +
                "name='" + super.getName() + '\'' +
                ", cost=" + super.getPrice() +
                ", volume=" + volume +
                ", temperature = " + temperature +
                '}';
    }
}
