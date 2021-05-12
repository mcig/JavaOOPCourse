package problem1;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(4);
        animal1.voice();
        Cat cat1 = new Cat(4);
        cat1.voice();
        Animal castedAnimal = cat1;
        castedAnimal.voice();

        if (castedAnimal instanceof Animal) System.out.println("This is an Animal");
        if (castedAnimal instanceof Cat) System.out.println("This is a Cat");
        if (castedAnimal instanceof Dog) System.out.println("This is a Dog");

    }
}
