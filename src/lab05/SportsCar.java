package lab05;

public class SportsCar extends Car {

	public SportsCar(String model, int minkms, int maxkms) {
		/*
		 * Fill this block. Assume that, the homeland of the sports car is Europe.
		 */
		super(model,minkms,maxkms);
		this.homeland = "Europe";
	}

	/*
	 * Override the sound() method. However, firstly the code inside of the sound()
	 * method in the superclass must be called.
	 */

	@Override
	public void sound() {
		super.sound();
		System.out.println("SportsCar sound: Vutututututu");
	}
}
