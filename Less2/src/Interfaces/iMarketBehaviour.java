package Interfaces;

import java.util.List;

import Classes.Actor;


/** Интерфес магазина */
public interface iMarketBehaviour {

    /** клиент вошел в магазин (метод) */
    void acceptToMarket(iActorBehaviour actor);

    /** клиент вышел из магазина (метод) */
    void releaseFromMarket(List<Actor> actors);

    /** обновление статуса */
    void update();
}
