package Interfaces;

import Classes.Actor;

/** Интерфейс клиента */
public interface iActorBehaviour  {

    /** сделать заказ */
    void setMakeOrder(boolean makeOrder);

    /** забрать заказ */
    void setTakeOrder(boolean pickUpOrder);

    /** сделан ли заказ */
    boolean isMakeOrder();

    /** забран ли заказ */
    boolean isTakeOrder();

    /** был ли произведен возврат товара*/


    /** возвращает клиента, которому принадлежит интерфейс */
    Actor getActor();

}

