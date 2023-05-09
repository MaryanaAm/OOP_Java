package Interfaces;

/** Интерфейс очереди */
public interface iQueueBehaviour {

    /** встать в очередь */
    void takeInQueue(iActorBehaviour actor);

    /** выйти из очереди */
    void releaseFromQueue();

    /** сделать заказ */
    void giveOrder();

    /** забрать заказ */
    void takeOrder();


}