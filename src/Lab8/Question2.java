package Lab8;

public class Question2 {
    public static void main(String[] args) {
        Integer[] sampleIntegerArray = {3, 5, 7, 8, 9, 45, 56, 67, 78, 55, 45};
        String[] sampleStringArray = "Mustafa Çığ Gökpınar".split("");

        ArrayIterator<Integer> iterInt = new ArrayIterator<>(sampleIntegerArray);
        ArrayIterator<String> iterStr = new ArrayIterator<>(sampleStringArray);

        Question2.<Integer>test(iterInt, "Integer");
        Question2.<String>test(iterStr, "String");

    }

    public static <T> void test(ArrayIterator<T> iterator, String typeName) {
        System.out.println(typeName + " Array Forwards");

        while (iterator.hasNext()) {
            T x = iterator.getNext();
            System.out.print(x + " ");
        }

        System.out.println("\n" + typeName + " Array Backwards");

        while (iterator.hasPrevious()) {
            T x = iterator.getPrevious();
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
