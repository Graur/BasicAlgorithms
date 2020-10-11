package ru.arg.skillsmart.algorithms;

import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new ru.arg.skillsmart.algorithms.DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if (count == 0 && new_capacity == DEFAULT_CAPACITY) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            capacity = DEFAULT_CAPACITY;
        } else if (new_capacity > capacity || new_capacity < capacity) {
            T[] buffer = (T[]) Array.newInstance(this.clazz, new_capacity);
            System.arraycopy(array, 0, buffer, 0, count);
            array = buffer;
            capacity = new_capacity;
        }
    }

    public T getItem(int index)
    {
        if (index >=0 && index < count) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index == count) {
            append(itm);
        } else if (index >= 0 && index < count) {
            int newCount = count + 1;
            if (newCount > capacity) {
                makeArray(capacity * 2);
            }
            System.arraycopy(array, index,
                    array, index + 1,
                    count - index);
            array[index] = itm;
            count = newCount;
        } else {
            throw new IndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

    public void remove(int index)
    {
        if (index >= 0 && index < count) {
            int newCount = count - 1;
            System.arraycopy(array, index + 1,
                    array, index,
                    newCount - index);
            array[newCount] = null;
            count = newCount;
            int newCapacity = (int) (capacity / 1.5);
            if (count < capacity * 0.5) {
                if (newCapacity < 16) {
                    newCapacity = 16;
                }
                makeArray(newCapacity);
            }
        } else {
            throw new IndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

}