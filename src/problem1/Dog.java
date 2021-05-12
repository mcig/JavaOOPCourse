package problem1;

public class Dog extends Animal {

    public Dog(int legs) {
        super(legs);
    }

    public Dog() {
        super();
    }

    @Override
    public void voice() {
        System.out.println("Dog said: " + "woof");
    }
}
