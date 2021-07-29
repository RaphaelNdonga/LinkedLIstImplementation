package com.example.linkedlistimplementation;

public interface Deque<E> {
    int size();

    void addFirst(E element);
    void addLast(E element);

    E first();
    E last();

    boolean isEmpty();

    E removeLast();
    E removeFirst();

}
