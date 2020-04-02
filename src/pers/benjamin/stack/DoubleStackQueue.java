package pers.benjamin.stack;

import java.util.Stack;

public class DoubleStackQueue {

    public static void main(String[] args) {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();

        doubleStackQueue.push(1);
        doubleStackQueue.push(2);
        doubleStackQueue.push(3);

        System.out.println(doubleStackQueue.pop());
        System.out.println(doubleStackQueue.pop());
        doubleStackQueue.push(4);
        System.out.println(doubleStackQueue.pop());

        while (doubleStackQueue.size() > 0) {
            System.out.println(doubleStackQueue.pop());
        }

    }

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public void push(int val) {
        first.push(val);
    }

    public Integer pop() {
        if (first.size() == 0) {
            return -1;
        }

        if (first.size() == 1) {
            return first.pop();
        }

        while (first.size() > 0) {
            second.push(first.pop());
        }

        int val = second.pop();

        while (second.size() > 0) {
            first.push(second.pop());
        }

        return val;
    }

    public int size() {
        return first.size();
    }

}
