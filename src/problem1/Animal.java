package problem1;

public class Animal {
    private int numberOfLegs;

    public Animal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public Animal() {
        this.numberOfLegs = 4;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public void voice() {
        System.out.println("Animal said: " + "bruh");
    }
}
