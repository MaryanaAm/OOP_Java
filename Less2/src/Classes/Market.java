package Classes;

import java.util.ArrayList;
import java.util.List;

import Classes.ActionClient;
import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;


/**
 * Класс магазина
 */
public class Market implements iMarketBehaviour, iQueueBehaviour {

    /**
     * Коллекция очереди с типом интерфейса клиента
     */
    private List<iActorBehaviour> queue;
    private static int numberOfActionClient;
    private static final int maxNumberOfActionClient;

    static {
        maxNumberOfActionClient = 500;
        numberOfActionClient = 0;
    }

    /**
     * Конструктор создания коллекции очереди
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    /**
     * Регистрация в вкции
     */
    private boolean registerInAction() {
        ++numberOfActionClient;
        if (maxNumberOfActionClient >= numberOfActionClient) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * получение количества клиентов в акции
     */
    public int getNumberOfActionClient() {
        return numberOfActionClient;
    }

    /**
     * обновление сведений о количестве клиентов в акции
     */
    public void updateNumberOfActionClient() {
        --numberOfActionClient;
    }

    /**
     * метод входа в магазин клиента и добавление в очередь
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(actor.getActor().getName() + " клиент зашел в магазин ");
        takeInQueue(actor);
    }

    /**
     * Добавление клиента в очередь
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().getName() + " клиент добавлен в очередь ");
    }


    /**
     * метод определения выхода клиентов из магазина и удаления из очереди
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }
    }

    /**
     * Обновление статуса магазина. (переопределение метода)
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }



    /**
     * совершение заказ (перезапись метода)
     */
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isTakeOrder()) {
                if (actor instanceof ActionClient && !registerInAction()) {
                    actor.setMakeOrder(false);
                    String message = actor.getActor().getName() + " отказано! Превышение лимита акции. ";
                    System.out.println(message);
                } else if (actor.getActor().getName() != "Tax audit") {
                    ((iReturnOrder) actor).setReturnOrder(true);
                    String message = actor.getActor().getName() + " оформил заявление на возврат товара";
                    System.out.println(message);

                    if (actor instanceof ActionClient) {
                        updateNumberOfActionClient();
                    }
                } else {
                    actor.setMakeOrder(true);
                    String message = actor.getActor().getName() + " сделал заказ";
                    System.out.println(message);
                }
            }

        }

    }

    /**
     * статус заказа (перезапись метода)
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент получил заказ ");
            } else if (actor.getActor().isReturnOrder) {
                ((iReturnOrder) actor).setReturnOrder(true);
                System.out.println(actor.getActor().getName() + " произвел возврат заказа");
            }
        }
    }

    /**
     * перезапись метода выхода из очереди
     */
    @Override
    public void releaseFromQueue () {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder() || ((iReturnOrder) actor).isReturnOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }
}



