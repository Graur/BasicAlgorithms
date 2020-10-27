package ru.arg.skillsmart.algorithms;

import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    int step;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
    }

    public int hashFun(String key) {
        int h = 0;
        byte[] bytes = key.getBytes();
        for (byte v : bytes) {
            h += v;
        }
        return h % size;
    }

    public boolean isKey(String key) {
        return get(key) != null;
    }

    public void put(String key, T value) {
        int index = hashFun(key);

        for (int i = 0; i < size; i++) {
            if (slots[index] == null || slots[index].equals(key)) {
                hits[index] = 0;
                slots[index] = key;
                values[index] = value;
                return;
            }
            index = index + step;
            if (index >= size) {
                index = index - size;
            }
        }

        int tmp = hits[0];
        int minElementIndex = 0;

        for (int i = 0; i < hits.length; i++) {
            if (hits[i] < tmp) {
                tmp = hits[i];
                minElementIndex = i;
            }
        }

        hits[minElementIndex] = 0;
        slots[minElementIndex] = key;
        values[minElementIndex] = value;
    }

    public T get(String key) {
        int index = hashFun(key);

        for (int i = 0; i < size; i++) {
            if (slots[index] == null) {
                return null;
            } else if (slots[index].equals(key)) {
                return values[index];
            }
            index = index + step;
            if (index >= size) {
                index = index - size;
            }
        }
        return null;
    }
}