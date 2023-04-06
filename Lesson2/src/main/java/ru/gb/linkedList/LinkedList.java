package ru.gb.linkedList;

public interface LinkedList<T> extends Iterable<T> {

    // null <- 1 <-> 2 <-> 3 <-> 4 <-> 5 -> null
    void addFirst(T element);

    void addLast(T element);

    T getFirst();

    T getLast();

    T get(int index);

    void delete(int index);

    void add(T element, int index);

}
