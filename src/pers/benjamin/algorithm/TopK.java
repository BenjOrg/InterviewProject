package pers.benjamin.algorithm;

import java.util.PriorityQueue;

/**
 * @author Benjamin
 * @date 2020/4/4 23:11
 * @module
 * @purpose
 */
public class TopK {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 4, 4, 5, 6, 7, 8, 2, 3, 10, 20};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int datum : data) {
            if (priorityQueue.size() >= 3) {
                priorityQueue.poll();
            }
            priorityQueue.add(datum);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }
}
