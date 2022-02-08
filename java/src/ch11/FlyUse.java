package ch11;

public class FlyUse {

	public static void main(String[] args) {

		Flyer f = new Drone();
		f.takeOff();
		f.fly();
		f.land();

		f = new Airplane();
		f.takeOff();
		f.fly();
		f.land();

	}

}
