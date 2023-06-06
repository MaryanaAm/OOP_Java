// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
public class App {
    public static void main(String[] args) {
        ICalculableFactory calculableFactory = new CalculableFactory();
        ViewCalculator view = new ViewCalculator(calculableFactory);
        view.run();
    }
}