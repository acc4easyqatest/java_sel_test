public class FirstTest {
	
	public static void main (String[] args) {
		helloTest();
		helloTest("username");
		System.out.println (helloTest("значение 1", "значение 2"));

	}

	/*демо методов*/
	//метод без параметров
	public static void helloTest () {
		System.out.println ("We are here! Hello! ");
	}
	//метод с параметром
	public static void helloTest (String value) {
		System.out.println ("We are here! Hello! " + value);
	}
	//метод с возвратом значения
	public static String helloTest (String value1, String value2 ) {
		return "We are here! Hello! " + value1 + " " + value2;
	}
}
