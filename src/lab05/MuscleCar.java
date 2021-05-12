package lab05;

public class MuscleCar extends Car {

	public MuscleCar(String model, int minkms, int maxkms) {
		/*
		 * Fill this block. Assume that, the homeland of the muscle car is USA.
		 */
		super(model,minkms,maxkms);
		this.homeland = "USA";
	}

	/*
	 * Override the sound() method. However, firstly the code inside of the sound()
	 * method in the superclass must be called.
	 */
	@Override
	public void sound() {
		super.sound();
		System.out.println("MuscleCar Sound: Hrrr Hrrr");
	}
}
