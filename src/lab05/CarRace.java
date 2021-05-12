package lab05;

public class CarRace extends Race {
    /**
     * This method simulates a random race using two vehicles. Cars move forward one
     * by one. Cars make a sound every time when they move. Cars drive at a random
     * speed for each round. Print the necessary information on the screen for each
     * round.
     *
     * @param km length of the racetrack as kilometer unit
     * @param a  the first vehicle
     * @param b  the second vehicle
     * @return the winner object
     */

    @Override
    Vehicle simulateRace(int km, Vehicle a, Vehicle b) {
        int leftKmsA = km, leftKmsB = km;
        if (!(a instanceof Car) || !(b instanceof Car))
            return null;
        Car carA = (Car) a;
        Car carB = (Car) b;
        while (leftKmsA > 0 && leftKmsB > 0) {
            int speed;

            System.out.println("Car A:");
            speed = carA.getRandomSpeed();
            leftKmsA = calculateLeftKms(leftKmsA, speed);
            System.out.println("Moved Forward " + speed + "kms, Total of " + leftKmsA + "kms left");
            carA.sound();

            System.out.println("\nCar B:");
            speed = carB.getRandomSpeed();
            leftKmsB = calculateLeftKms(leftKmsB, speed);
            System.out.println("Moved Forward " + speed + "kms, Total of " + leftKmsB + "kms left");
            carB.sound();

            if (leftKmsA == 0 || leftKmsB == 0) break;
        }
        Vehicle winner = leftKmsA <= leftKmsB ? a : b;
        System.out.println("\nWinner Car:\n" + winner.toString());
        return winner;
    }

    /**
     * @param km    takes left kms
     * @param speed current speed that will be decreaed from km
     * @return the difference between km and speed or 0
     */
    private int calculateLeftKms(int km, int speed) {
        if(km - speed >= 0)
            return km-speed;
        else
            return 0;
    }

}
