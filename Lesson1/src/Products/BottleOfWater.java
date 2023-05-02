package Products;

/**
 * класс напитков
 */
public class BottleOfWater extends Product {

    /** объем продукта */
    private int volume;

    /**
     * конструктор горячих напитков
     * @param name наименование продукта
     * @param price цена продукта
     * @param volume объем продукта
     */
    public BottleOfWater(String name, double price, int volume)
    {
        super(name, price);
        this.volume = volume;
    }

    /** получаем объем продукта */
    public int getVolume() {
        return volume;
    }

    /** устанавливаем объкем продукта */
    public void setVolume(int volume) {
        this.volume = volume;
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
                '}';
    }

}

