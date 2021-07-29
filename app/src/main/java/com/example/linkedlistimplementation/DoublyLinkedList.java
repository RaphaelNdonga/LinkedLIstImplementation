package com.example.linkedlistimplementation;

public class DoublyLinkedList<E> implements Deque<E> {

    /**
     * The node class contains an element,
     * and 2 node objects that point to other nodes(head and tail)
     *
     * @param <E>
     */
    public static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        //--------------------End of the nested node class------------------------
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, trailer);
        trailer = new Node<>(null, header, null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFirst(E element) {
        addBetween(element,header,header.getNext());
    }

    @Override
    public void addLast(E element) {
        addBetween(element,trailer.getPrev(),trailer);
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeLast() {
        return remove(trailer.getPrev());
    }

    @Override
    public E removeFirst() {
        return remove(header.getNext());
    }

    private void addBetween(E element, Node<E> predecessor, Node<E> successor){
        Node<E> newNode = new Node<>(element,predecessor,successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    //------------------------------End of doubly linked list ------------------------------
}
