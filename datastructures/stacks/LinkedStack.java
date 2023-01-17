package datastructures.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {

    public Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public LinkedStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("stack underflow");

        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Item item : this) {
            s.append(item);
            s.append(',');
        }
        s.append(']');
        StringBuilder arr = new StringBuilder("[");
        arr.append(s);
        arr.replace(arr.length() - 2, arr.length() - 1, "");
        // s = s.substring(0,s.length()-1);
        return arr.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);

    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("no next elemnt available");
            Item item = current.item;
            current = current.next;
            return item;

        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        // System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.toString());
        // System.out.println("size after "+stack.size());
        // System.out.println("string version"+stack.toString());
        // System.out.println("peeked elemnt"+stack.peek());
        // System.out.println(" the size of stack " +stack.size());
        // System.out.println("popped elemnt"+stack.pop());
        // System.out.println("size after "+stack.size());

    }

}
