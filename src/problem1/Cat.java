package problem1;

public class Cat extends Animal {

    public Cat(int legs) {
        super(legs);
    }

    public Cat() {
        super();
    }

    @Override
    public void voice() {
        System.out.println("Cat said: " + "meow");
    }
}
