package datastructures.stacks;

public class MyStack {

    private static Node first = null;

    private static class Node {
        String item;
        Node next;
    }

    private static class stackEception extends Exception {
        public stackEception(String str) {
            super(str);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() throws stackEception {
        if (first == null) {
            throw new stackEception("the stack is empty");
        }
        String item = first.item;
        first = first.next;

        return item;
    }

    public int size() {

        boolean notEmpty = true;
        int count = 0;
        while (notEmpty) {
            if (first != null) {
                // this.pop();
                count++;
                continue;
            }
            break;
        }
        return count;
    }

    public static void main(String[] args) throws stackEception {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
