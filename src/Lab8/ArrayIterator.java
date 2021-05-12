package Lab8;

public class ArrayIterator<T> {
    private T[] selectedArray;
    private int index;

    public ArrayIterator(T[] selectedArray) {
        this.selectedArray = myCopy(selectedArray);
        index = -1;
    }

    public T getNext() {
        T res = null;
        if (hasNext()) {
            index++;
            res = selectedArray[index];
        }
        return res;
    }

    public T getPrevious() {
        T res = null;
        if (hasPrevious()) {
            index--;
            res = selectedArray[index];
        }
        return res;
    }

    public boolean hasNext() {
        if(index == this.myLen() - 1)
            index++;
        return this.index < this.myLen() - 1;
    }

    public boolean hasPrevious() {
        if(index == 0)
            index--;
        return this.index > 0;
    }

    //helpers
    private T[] myCopy(T[] arr) {
        T[] newArr = (T[]) new Object[arr.length];
        int i = 0;
        for (T el : arr) {
            newArr[i] = el;
            i++;
        }
        return newArr;
    }

    private int myLen() {
        int i = 0;
        for (T ignored : selectedArray) {
            i++;
        }
        return i;
    }
}
