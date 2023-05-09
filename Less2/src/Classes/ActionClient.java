package Classes;

import Classes.Actor;
import Interfaces.iReturnOrder;

/** Класс "Акционный клиент"
 */
public class ActionClient extends Actor implements iReturnOrder {

    /** Название акции */
    private String promoAction;

    /**
     * конструктор акции в магазине
     * @param name имя клиента
     */
    public ActionClient(String name) {
        super(name);
        this.promoAction = getAction();
    }
    public String getAction() {
        return " - 15% ";
    }
    public String getPromoAction() {
        return this.promoAction;
    }
    /** получаем имя клиента */
    @Override
    public String getName() {
        return super.name;
    }


    // Сделать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setMakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    // Забрать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }

    // Сделал ли клиент заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    // Получил ли клиент свой заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    // В качестве клиента возвращает самого себя
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public Actor getActor() {
        return this;
    }

    // Вернуть заказ
    // Перезаписываем метод из интерфейса iReturnOrder
    @Override
    public void setReturnOrder(boolean returnOrder) {
        super.isReturnOrder = returnOrder;
    }

    // Вернул ли клиент свой заказ
    // Перезаписываем метод из интерфейса iReturnOrder
    @Override
    public Boolean isReturnOrder() {
        return super.isReturnOrder;
    }
}

