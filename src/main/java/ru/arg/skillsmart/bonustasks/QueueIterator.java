package ru.arg.skillsmart.bonustasks;

import ru.arg.skillsmart.algorithms.Queue;

public class QueueIterator<T> {
    public T iterate(Queue<T> queue, int n) {
        for (int i = 1; i < n; i++) {
            queue.enqueue(queue.dequeue());
        }
        return queue.dequeue();
    }
}
