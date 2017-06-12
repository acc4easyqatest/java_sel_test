import test.ship.StarShip;

public class FirstTest {
	
	public static void main (String[] args) {
		//создаем экземпляр класса StarShip с высотой
		StarShip ship = new StarShip(253.25);

		//вызываем метод, который нам все о корабле расскажет
		displayHeight(ship);

	}
	public static void displayHeight(StarShip littleShip){
		System.out.println ("Высота корабля составляет : " + getStarShipHeight(littleShip) + " метров" );
	}
	/*демо обращения к атрибуту  класса*/
	//выведем высоту пирамиды
	public static double getStarShipHeight (StarShip littleShip) {
		return littleShip.shipHeight;
	}
}
