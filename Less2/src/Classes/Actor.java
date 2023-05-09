package Classes;

import Interfaces.iActorBehaviour;

import Interfaces.iReturnOrder;

/**
 Проротип клиента ( абстрактный класс) с подключенным интерфейсом
 */
public abstract class Actor implements iActorBehaviour {

    /** имя клиента */
    protected String name;

    /** совершение заказа */
    protected boolean isMakeOrder;

    /** получение заказа */
    protected boolean isTakeOrder;

    /** возврат товара */
    protected boolean isReturnOrder;

    /**
     * конструктор
     * @param name имя клиента
     */
    public Actor(String name) {
        this.name = name;
    }

    /** получение имени клиента */
    public abstract String getName();

    public boolean isMakeOrder() {
        return isMakeOrder;
    }
}
