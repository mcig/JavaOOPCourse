package lab05;

import java.util.Random;

public class Car extends Vehicle {

    protected String homeland;

    public Car(String model, int minkms, int maxkms) {
        this.model = model;
        this.minkms = minkms;
        this.maxkms = maxkms;
    }

    /**
     * This method returns a random speed between minkms and maxkms
     *
     * @return
     */
    public int getRandomSpeed() {
        Random r = new Random();
        int low = minkms;
        int high = maxkms + 1;
        return r.nextInt(high - low) + low;
    }

    /**
     * This method is for printing the sound of the car.
     */
    public void sound() {
        System.out.print("Car sound: Vroom Vroom\n");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car newCar = new Car(model,minkms,maxkms);
        newCar.homeland = homeland;
        return newCar;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Car)) return false;
        Car paramCar = (Car)obj;

        boolean b1 = model.equals(paramCar.model);
        boolean b2 = minkms == paramCar.minkms;
        boolean b3 = maxkms == paramCar.maxkms;
        boolean b4 = homeland.equals(paramCar.homeland);
        return b1 && b2 && b3 && b4;
    }

    @Override
    public String toString() {
        return "This is a car from " + homeland + " with model " + model + " that can do minimum of: " + minkms + "kms and maximum of:" + maxkms + "kms";
    }
}
