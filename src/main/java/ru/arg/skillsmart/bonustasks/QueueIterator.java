package ru.arg.skillsmart.bonustasks;

import ru.arg.skillsmart.algorithms.Queue;

public class QueueIterator<T> {
    public T iterate(Queue<T> queue, int n) {
        T result = null;
        if (n == 0 || queue.size() == 0) {
            return null;
        }

        for (int i = 1; i <= n; i++) {
            if (i == n) {
                result = queue.dequeue();
            } else {
                queue.enqueue(queue.dequeue());
            }
        }
        return result;
    }
}
