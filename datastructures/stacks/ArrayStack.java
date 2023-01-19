import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Iterable<Item> {

    private static final int INITIAL_CAPACITY = 8;
    private Item[] arr;
    private static int n;

    public ArrayStack() {
        arr = (Item[]) new Object[INITIAL_CAPACITY];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void resize(int capacity) {
        assert capacity >= n;
        Item[] newArr = (Item[]) new Object[capacity];
        for (int i = 0; i <= n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void push(Item item) {
        if (arr.length == n)
            resize(2 * arr.length);
        arr[n++] = item;
    }

    public Item peek() {
        Item item = arr[n - 1];
        return item;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        if (n > 0 && n == arr.length / 4)
            resize(arr.length / 2);
        Item item = arr[n - 1];
        arr[n - 1] = null;
        return item;
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
        return arr.toString();
    }

    public Iterator<Item> iterator() {

        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {

        private int r;

        public LinkedIterator() {

            r = n;
        }

        public boolean hasNext() {
            return r > 0;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("there is no next element");
   
            return arr[--r];
        }

    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println("isempty" + stack.isEmpty());
        System.out.println("hasnext" + stack.iterator().hasNext());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("size" + stack.size());
        System.out.println("next" + stack.iterator().next());
        System.out.println("after pus" + stack.toString());
        System.out.println("peek" + stack.peek());
        System.out.println("after peek" + stack.toString());
        System.out.println("poped" + stack.pop());
        System.out.println("after pop" + stack.toString());
    }

}
