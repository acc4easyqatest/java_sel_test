package test.ship;

/**
 * Created by Любовь on 2017.
 */
public class StarShip {

    /*какие у корабля атрибуты ?
    * высота (для начала)
    */

    public double shipHeight;

    //добавляем конструктор
    public StarShip(double shipHeight){
        this.shipHeight = shipHeight;
    }

    public double getStarShipHeight () {
        return this.shipHeight;
    }



}
