package ru.gb.arrayList;

public class ArrayList<T> extends java.util.ArrayList {

    private T[] array;
    private int length = 0;
    private int size = 10;

    public ArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public ArrayList(){
        new ArrayList(size);
    }

    public boolean add(Object value) {
        chechArrayLength();
        array[length] = (T) value;
        length++;
        return true;
    }

    public void add(int index, Object value) {
        chechArrayLength();
        T[] array1 = (T[]) new Object[size];
        System.arraycopy(array, 0, array1, 0, index-1);
        array1[index] = (T) value;
        System.arraycopy(array, index, array1, index + 1, size - index);
        array = array1;
        length++;
    }

    private void chechArrayLength() {
        if (length > array.length) {
            size*=2;
            T[] array1 = (T[]) new Object[size];
            System.arraycopy(array, 0, array1, 0, array.length);
            array = array1;
        }
    }

    public T get(int index) {
        return array[index];
    }

    public T remove(int index) {
        T result = array[index];
        length--;
        T[] array1 = (T[]) new Object[size];
        System.arraycopy(array, 0, array1, 0, index);
        System.arraycopy(array, index + 1, array1, index, size - index - 1);
        array = array1;
        return result;
    }
}
