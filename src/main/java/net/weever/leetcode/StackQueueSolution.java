package net.weever.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueueSolution {

    public void method() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("hello");
        deque.add("world");
        if (!deque.isEmpty()) {
            String element = deque.poll();
            System.out.println(element);
        }
    }
}
